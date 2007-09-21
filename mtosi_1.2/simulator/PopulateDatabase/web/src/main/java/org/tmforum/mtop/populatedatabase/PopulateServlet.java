/*
 * PopulateServlet is the servlet which handles the populateDatabase requests 
 * from the web browser. It calls the Populate bean of the EJB module to 
 * unmarshall and populate the database and display the state (populated or not) 
 * to the web browser. The user can choose to delete or not the previous records
 * of the database by activating the checkbox.
 */

package org.tmforum.mtop.populatedatabase;

import java.io.*;
import java.net.*;
import javax.ejb.EJB;
import java.util.*;
import org.apache.commons.fileupload.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.tmforum.mtop.populatedatabase.Populate;

/**
 * Servlet which calls the EJB bean to populate the database with the
 * xml file of the user.
 */
public class PopulateServlet extends HttpServlet {
    
    @EJB
    private Populate populateDatabaseBean;
    private HttpSession session = null;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private ServletContext context = null;
    private String errorMsg = null;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected synchronized boolean  processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.request = request;
        this.response = response;
        
        session = request.getSession(true);
        String action = request.getServletPath();
        
        if (action.equals("/populate.do")) {
            errorMsg = null;
            this.doWork(request, response);
            System.out.println("errorMsg: " + errorMsg);
            
            if (errorMsg == null) {
                if (!doPopulate())
                    request.setAttribute("error", "The database was not populated !");
                else
                    request.setAttribute("validMsg", "The database was populated  with "
                            + request.getAttribute("fileUpload"));
            } else
                request.setAttribute("error", "Please specify a file !");
        }
      
        request.getRequestDispatcher("populate.jsp").forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.close();
        
        return false;
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Call the bean of the EJB module to populate the database.
     *  @return true if the database has bean populataed false otherwise.
     */
    public boolean doPopulate() throws ServletException, IOException {
        String file = (String)request.getAttribute("fileUpload");
        boolean deletePrevRecords = false;
        file = getServletContext().getRealPath("/") + "" + file;
        
        String delete = (String)request.getAttribute("deleteDB");
        if (delete != null) {
            deletePrevRecords = true;
        }
        
        return populateDatabaseBean.unmarshallXmlExample(file, deletePrevRecords);
    }
    
    /**
     * Upload the file on the server
     */
    public void doWork(HttpServletRequest request, HttpServletResponse response)
    throws ServletException {
        HttpSession session = request.getSession();
        DiskFileUpload upload = new DiskFileUpload();
        HashMap paramMap = new HashMap();
        InputStream xmlFile = null;
        String s = "";
        try {
            List items = upload.parseRequest(request);
            Iterator itr = items.iterator();
            
            while(itr.hasNext()){
                FileItem item = (FileItem) itr.next();
                if(item.isFormField()) {
                    String fieldName = item.getFieldName();
                    if(fieldName.equals("deleteDB")) {
                        request.setAttribute("deleteDB", fieldName);
                    }
                    //paramMap.put(item.getFieldName(), item.getString());
                } else if(item.getFieldName().equals("xmlFile")) {
                    File fullFile = new File(item.getName());
                    xmlFile = item.getInputStream();
                    if(xmlFile != null && !xmlFile.equals("")) {
                        File savedFile = new File(getServletContext().getRealPath("/"), fullFile.getName());
                        item.write(savedFile);
                        request.setAttribute("fileUpload", fullFile.getName());
                        s = fullFile.getName();
                    }
                }
            }
            String file = (String)request.getAttribute("fileUpload");
            file = getServletContext().getRealPath("/") + "" + s;
        } catch (IOException ioe) {
            errorMsg = "Please Specify a xml file";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
