/*
 * NewServlet.java
 *
 * Created on 15 avril 2007, 15:54
 */

package org.tmforum.mtop.simulator;

import java.io.*;
import java.net.*;
import javax.ejb.EJB;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author baptiste
 * @version
 */
public class PopulateServlet extends HttpServlet {
    
    @EJB
    private Populate getInventoryBean;
    private HttpSession session = null;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private ServletContext context = null;
    
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
        
        if (action.equals("/populate.do")) {
            if (!doPopulate())
                request.getRequestDispatcher("error.jsp").forward(request, response);
            else
                request.getRequestDispatcher("confirm.jsp").forward(request, response);
        }
        
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
    
    public boolean doPopulate() throws ServletException, IOException {
        System.out.println("*************PopulateServlet:doPopulate()*************");
        String file = (String)request.getAttribute("fileUpload");
        file = getServletContext().getRealPath("/") + "" + file;
        System.out.println("file: " + file);
        return getInventoryBean.unmarshallXmlExample(file);
    }     
  
    
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}
