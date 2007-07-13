
package ws.v1.tmf854;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import v1.tmf854.HeaderT;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.v1.tmf854 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Arg0_QNAME = new QName("tmf854.v1.ws", "arg0");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.v1.tmf854
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1.ws", name = "arg0")
    public JAXBElement<HeaderT> createArg0(HeaderT value) {
        return new JAXBElement<HeaderT>(_Arg0_QNAME, HeaderT.class, null, value);
    }

}
