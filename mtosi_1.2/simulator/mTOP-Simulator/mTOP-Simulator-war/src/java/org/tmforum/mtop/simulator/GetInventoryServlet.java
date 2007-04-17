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
public class GetInventoryServlet extends HttpServlet {
    
    @EJB
    private GetInventory getInventoryBean;
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
        
        if (action.equals("/constructRequest.do")) {
            String baseInstance = request.getParameter("baseInstance");
            String includedObjectType = request.getParameter("includedObjectType");
            String granularity = request.getParameter("granularity");
            doCreateGetInventoryRequest(baseInstance, includedObjectType, granularity);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.close();
        
        return false;
    }
    
    public boolean doCreateGetInventoryRequest(String baseInstance, String includedObjectType, String granularity) throws ServletException, IOException {
        File resp = getInventoryBean.createGetInventoryRequest(baseInstance, includedObjectType, granularity);
        String path = getServletContext().getRealPath("/") + "" + resp.getName();
        try {
            FileInputStream fis = new FileInputStream(resp);
            BufferedInputStream bis = new BufferedInputStream(fis);
            long l = resp.length();
            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            for(long i=0;i<l;i++) {
                bos.write(bis.read());
            }
            bos.flush();
            bos.close();
            bis.close();
            
        } catch (Exception e) {
            System.err.println("File access error !");
            e.printStackTrace();
        }
        request.setAttribute("path", path);
        request.getRequestDispatcher("result.jsp").forward(request, response);
        
        return true;
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
    
    
    
    
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}
