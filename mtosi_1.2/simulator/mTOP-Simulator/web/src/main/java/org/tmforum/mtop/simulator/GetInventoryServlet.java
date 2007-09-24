
package org.tmforum.mtop.simulator;

import java.io.*;
import java.net.*;
import javax.ejb.EJB;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.tmforum.mtop.simulator.GetInventory;
import org.tmforum.mtop.simulator.ThinClientException;

/**
 * GetInventoryServlet is the servlet class which handles the thin
 * client <i>getInventory</i> and </i>getInventoryIterator</i> requests.<br>
 * It gets the operation filter parameters from <i>filter.jsp<i>,
 * calls the </i>GetInventory</i> bean to create the response, and then dispatch the
 * result to the jsp for the display in the web browser.
 */
public class GetInventoryServlet extends HttpServlet {
    
    @EJB
    private GetInventory getInventoryBean;
    private HttpSession session = null;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private ServletContext context = null;
    private boolean iteratorRequest = false;
    private boolean endOfReply = false;
    private int nbIterator = 0;
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected synchronized boolean  processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.request = request;
        this.response = response;
        
        session = request.getSession(true);
        String action = request.getServletPath();
        String lastBI = null;
        String requestedBatchSizeS = null;
        
        
        if (action.equals("/constructRequest.do")) {
            // getInventory request
            iteratorRequest = false;
            request.setAttribute("lastRequestWasIterator", false);
            createFilter();
        }
        
        requestedBatchSizeS = (String)request.getSession().getAttribute("requestedBatchSize");
        
        if (action.equals("/iterator.do")) {
            // getInventoryIterator request
            nbIterator++;
            request.setAttribute("iteratorRequest", "GetInventoryIterator nb: " + nbIterator);
            request.setAttribute("lastRequestWasIterator", true);
            requestedBatchSizeS = (String)request.getParameter("rqbs");
            iteratorRequest = true;
        } else if (action.equals("/refresh.do")) {
             request.getRequestDispatcher("filter.jsp").forward(request, response);
        }
        
        Long requestedBatchSizeL = new Long(requestedBatchSizeS);
        Map baseInstances = (HashMap) request.getSession().getAttribute("BImap");
        Map includedObjectTypes = (HashMap) request.getSession().getAttribute("IOTmap");
        
        request.setAttribute("baseInstances", baseInstances);
        request.setAttribute("includedObjectTypes", includedObjectTypes);
        int requestedBatchSize = requestedBatchSizeL.intValue();
        request.setAttribute("rqbs", requestedBatchSize);
        
        Integer nbBaseInstances  = (Integer)request.getSession().getAttribute("nbBaseInstances");
        Integer nbIncludedObjectTypes  = (Integer)request.getSession().getAttribute("nbIOTs");
        
         // trace for tests purposes
//        System.out.println("requestedBatchSize= " + requestedBatchSize);
//        System.out.println("nbBI " + nbBaseInstances.intValue() + "nbIOTT " + nbIncludedObjectTypes.intValue());
//        System.out.println("GetInventoryServlet: nbBaseInstances " + session.getAttribute("nbBaseInstances"));
//        System.out.println("GetInventoryServlet: nbIotsss " + session.getAttribute("nbIOTS"));
        
        boolean success = doCreateGetInventoryRequest(
                baseInstances, includedObjectTypes,
                lastBI, requestedBatchSizeL, iteratorRequest);
        
        if (!success) {
            request.setAttribute("ok", false);
            request.getRequestDispatcher("filter.jsp").forward(request, response);
        } else {
            request.setAttribute("ok", true);
            
            if (endOfReply) {
                nbIterator = 0;
                
                if(iteratorRequest || (requestedBatchSize > 0))  {
                    request.setAttribute("allRetrieved", true);
                    request.getRequestDispatcher("filter.jsp").forward(request, response);
                } else {
                    request.setAttribute("endOfReply", true);
                    request.getRequestDispatcher("filter.jsp").forward(request, response);
                }
                
            } else {
                request.getRequestDispatcher("filterIterator.jsp").forward(request, response);
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.close();
        
        return false;
    }
    
    /**
     * Send the getInventory or getInventoryIterator request to the bean of the EJB module.
     * It then creates the the xml and html response files.
     * @param baseInstances map that contains the baseInstances entered in the browser
     * @param includedObjectTypes map that contains the included object types entered in the browser
     * @return true if the no exceptions occured, false otherwise
     */
    public boolean doCreateGetInventoryRequest(
            Map baseInstances, Map includedObjectTypes,
            String last, Long requestedBatchSize, boolean iteratorRequest)
            throws ServletException, IOException {
           String path = null;
        
        try {
            // CALL THE GETINVENTORY BEAN TO CREATE THE RESPONSE
            File xmlResponseFile = getInventoryBean.createThinClientRequest(
                    baseInstances, includedObjectTypes,
                    requestedBatchSize, iteratorRequest);
            
            // CALL THE GETINVENTORY TO CHECK IF IT WAS THE LAST BATCH
            this.endOfReply = getInventoryBean.endOfReply();
            path = getServletContext().getRealPath("/") + "" + xmlResponseFile.getName();
            FileInputStream fis = new FileInputStream(xmlResponseFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            long l = xmlResponseFile.length();
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            for(long i=0; i<l; i++) {
                bos.write(bis.read());
            }
            
            bos.flush();
            bos.close();
            bis.close();
            
        } catch(ThinClientException tce) {
            request.setAttribute("error", tce.getMessage());

            return false;
        }
        
        String pathStyleSheet = getServletContext().getRealPath("/") + "" + "styleSheet.xsl";
        String pathTable = getServletContext().getRealPath("/") + "" + "table.html";
        File styleSheetFile = new File(pathStyleSheet);
        File htmlResponseFile = new File(path);
        File table = new File(pathTable);
        Stylizer stylizer = new Stylizer();
        stylizer.transform(styleSheetFile, htmlResponseFile, table);
        request.setAttribute("path", path);
        
        return true;
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Get all the filter parameters (requestedBatchSize, baseInstances, includedObjectTypes)
     * entered in the browser into instances.
     */
    public void createFilter() {
        Enumeration parameters = request.getParameterNames();
        
        int i = -1;
        int k = 0;
        int nbIots = 0;
        int nbBaseInstances = 0;
        String parameterName =null;
        String parameterValue =null;
        HashMap BImap = new HashMap();
        HashMap BImapType = new HashMap();
        HashMap IOTmap = new HashMap();
        String objectType = null;
        String granularity = null;

        // loop through all parameters of web client
        while((parameters.hasMoreElements()))  {
            while (i < 0 ) {
                parameterName = (String)parameters.nextElement();
                parameterValue = (String)request.getParameter(parameterName);
                
                if (parameterName.equals("rqbs"));
                session.setAttribute("requestedBatchSize", parameterValue);
                i++;
            }
            i++;
            
            parameterName =  parameterName.substring(0, 2);
            
            
            if ( !(parameterName.equals("io")) ) {
                
                while( (parameterName.substring(0,1).equals("b"))  ||  parameterName.substring(0,1).equals("r") ) {
                    
                    for(int j = 1; j <= 4; j++) {
                        parameterName = (String)parameters.nextElement();
                        parameterValue = (String)request.getParameter(parameterName);

                        if (!(parameterName.substring(0,1).equals("b"))) {
                            nbBaseInstances--;
                            
                            break;
                        }
              
                        BImap.put("baseInstanceType"+j+nbBaseInstances, parameterValue);
                        parameterName = (String)parameters.nextElement();
                        parameterValue = (String)request.getParameter(parameterName);
                        
                        if (!(parameterName.substring(0,1).equals("b"))){
                            parameterName = (String)parameters.nextElement();
                            nbBaseInstances--;
                            
                            break;
                        }
                        
                        BImap.put("baseInstanceValue"+j+nbBaseInstances, parameterValue);
                    } // for
                    
                    nbBaseInstances++;
                    
                }
            } // end baseInstance table
            
            int s = 0;
            
            while ( (parameterName.substring(0, 2).equals("io")) && (s < 10) ) {
                s++;
                parameterValue = (String)request.getParameter(parameterName);
                IOTmap.put("objectAcronym"+nbIots, parameterValue);
                parameterName = (String)parameters.nextElement();
                parameterValue = (String)request.getParameter(parameterName);
                IOTmap.put("granularity"+nbIots, parameterValue);
                nbIots++;

                if (!parameters.hasMoreElements()) {
                    break;
                }
                parameterName = (String)parameters.nextElement();
                parameterValue = (String)request.getParameter(parameterName);
            }
            
            session.setAttribute("nbBaseInstances", new Integer(nbBaseInstances)) ;
            session.setAttribute("nbIOTs", new Integer(nbIots));
            BImap.put("nbBaseInstances", nbBaseInstances);
            IOTmap.put("nbIOTs", nbIots);
            session.setAttribute("BImap", BImap);
            session.setAttribute("IOTmap", IOTmap);
            session.setAttribute("objectType", objectType);
            session.setAttribute("granularity", granularity);
           
            if (!parameters.hasMoreElements()) {
                break;
                
            }
        } 
    }
}

