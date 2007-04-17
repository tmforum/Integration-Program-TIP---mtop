/*
 * NewServlet.java
 *
 * Created on 15 avril 2007, 19:56
 */

package org.tmforum.mtop.simulator;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.apache.commons.fileupload.*;
/**
 *
 * @author baptiste
 * @version
 */
public class FileUploadServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        doWork(req, res);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        doWork(req, res);
    }
    
    private void doWork(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        DiskFileUpload upload = new DiskFileUpload();
        try {
            List items = upload.parseRequest(req);
            FileItem item = (FileItem) items.get(0);
            Iterator it = items.iterator();
            String name = item.getName();
            
            File savedFile = new File(getServletContext().getRealPath(
                    "/")
                    + item.getName());
            item.write(savedFile);
            req.setAttribute("fileUpload", name);
            //req.setAttribute("confirmUpload", "the data of " + name + " are in the database !");
        }
        
        catch (Exception e) {
            e.printStackTrace();
         } finally {
            req.getRequestDispatcher("populate.do").forward(req, res);
        }
    }
}