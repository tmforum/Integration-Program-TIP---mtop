/*
 * GetInventoryBean.java
 *
 * Created on 15 avril 2007, 15:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.List;
import java.util.ListIterator;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import java.io.FileInputStream;
import java.io.File;

/**
 *
 * @author baptiste
 */
@Stateless
public class PopulateImpl implements Populate {
    
    @PersistenceContext
    private EntityManager em;
    
    /** Creates a new instance of GetInventoryBean */
    public PopulateImpl() {
    }
    
    // Populate the database with the unmarshalled InventoryDataT object
    public void populateDatabase(GetInventoryResponseT getInventoryResponse) {
        InventoryDataT inventory = getInventoryResponse.getInventoryData();
        List<MDInventoryT> mdInvs = getInventoryResponse.getInventoryData().getMdList().getMd();
        for (MDInventoryT mdInv : mdInvs) {
            ManagementDomainT md = mdInv.getMdAttrs();
            NamingAttributesT nat = new NamingAttributesT();
            md.setNameAtt(nat);
            em.persist(md);
            List<MEInventoryT> meInvs = mdInv.getMeList().getMeInv();
            for (MEInventoryT meInv : meInvs) {
                ManagedElementT me = meInv.getMeAttrs();
                me.setNameAtt(nat);
                em.persist(me);
                List<EHInventoryT> ehInvs = meInv.getEhList().getEhInv();
                for (EHInventoryT ehInv : ehInvs) {
                    EquipmentHolderT eh = ehInv.getEhAttrs();
                    eh.setNameAtt(nat);
                    em.persist(eh);
                    EQInventoryT eqInv = ehInv.getEqInv();
                    EquipmentT eq = eqInv.getEqAttrs();
                    eq.setNameAtt(nat);
                    em.persist(eq);
                    nat.setMdNm(mdInv.getMdNm());
                    nat.setMeNm(meInv.getMeNm());
                    nat.setEhNm(ehInv.getEhNm());
                    nat.setEqNm(eqInv.getEqNm());
                    em.persist(nat);
                    nat = new NamingAttributesT();
                }
            }
        }
    }
      
    // Unmarshall the InventoryData xml example file into a InventoryDataT object.
    public void unmarshallXmlExample(String path) {
        GetInventoryResponseT getInventoryResponse = null;
        try {
            JAXBContext jc = JAXBContext.newInstance( "v1.tmf854" );
            ObjectFactory factory = new ObjectFactory();
            Unmarshaller u = jc.createUnmarshaller();
            JAXBElement<?> poElement = (JAXBElement<?>)u.unmarshal( new File(path) );
            getInventoryResponse = (GetInventoryResponseT) poElement.getValue();
        } catch( JAXBException je ) {
            je.printStackTrace();
        }
        populateDatabase(getInventoryResponse);
    }
    
    
    public void persist(Object object) {
        // TODO:
        // em.persist(object);
    }
}
