/*
 * NewServlet.java
 *
 * Created on 15 avril 2007, 15:54
 */

package org.tmforum.mtop.simulator;

import java.io.*;
import java.net.*;
import javax.ejb.EJB;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author baptiste
 * @version
 */
public class GetInventoryServlet extends HttpServlet {
    
    @EJB
    private GetInventoryImpl getInventoryBean;
    private HttpSession session = null;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private ServletContext context = null;
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
//    protected synchronized boolean  processRequest(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        this.request = request;
//        this.response = response;
//
//        session = request.getSession(true);
//        String action = request.getServletPath();
//        String lastBI = null;
//
//
//        if (action.equals("/constructRequest.do")) {
//
//            Integer nbBaseInstances = new Integer(1);//request.getParameter("nbBI"));
//            //List<Map> baseInstances = new ArrayList<Map>(nbBaseInstances);
//            Map baseInstances [] = new Map[nbBaseInstances.intValue()];
//            System.out.println("nbBi: " + nbBaseInstances.intValue());
//            String biNumber = request.getParameter("biNumber");
//            System.out.println("biNumber: " + biNumber);
//
//            for (int i = 0; i < baseInstances.length; i++) {
//
//                String bi1Field1 = request.getParameter("bi1Field1");
//                String bi1Field2 = request.getParameter("bi1Field2");
//                String bi1Field3 = request.getParameter("bi1Field3");
//
//                String bi2Field1 = request.getParameter("bi2Field1");
//                String bi2Field2 = request.getParameter("bi2Field2");
//                String bi2Field3 = request.getParameter("bi2Field3");
//
//                String bi3Field1 = request.getParameter("bi3Field1");
//                String bi3Field2 = request.getParameter("bi3Field2");
//                String bi3Field3 = request.getParameter("bi3Field3");
//
//                String bi4Field1 = request.getParameter("bi4Field1");
//                String bi4Field2 = request.getParameter("bi4Field2");
//                String bi4Field3 = request.getParameter("bi4Field3");
//
//                String bi5Field1 = request.getParameter("bi5Field1");
//                String bi5Field2 = request.getParameter("bi5Field2");
//                String bi5Field3 = request.getParameter("bi5Field3");
//
//                String bi6Field1 = request.getParameter("bi6Field1");
//                String bi6Field2 = request.getParameter("bi6Field2");
//                String bi6Field3 = request.getParameter("bi6Field3");
//
//                String bi7Field1 = request.getParameter("bi7Field1");
//                String bi7Field2 = request.getParameter("bi7Field2");
//                String bi7Field3 = request.getParameter("bi7Field3");
//
//                String bi8Field1 = request.getParameter("bi8Field1");
//                String bi8Field2 = request.getParameter("bi8Field2");
//                String bi8Field3 = request.getParameter("bi8Field3");
//
//                String bi9Field1 = request.getParameter("bi9Field1");
//                String bi9Field2 = request.getParameter("bi9Field2");
//                String bi9Field3 = request.getParameter("bi9Field3");
//
//
//                Map baseInstance = new HashMap();
//                if (biNumber.equals("1")) {
//                    System.out.println("11111111111111111111111");
//                    if (bi1Field1 == "" && bi1Field2 == "" && bi1Field3 == "" && bi2Field1 == "") {
//                        // MD
//                        System.out.println("MDDDDDDDDDDDD");
//                        lastBI = bi1Field1;
//                        baseInstance.put("bi1Field1", bi1Field1);
//                    } else if (bi1Field1 != "" && bi1Field2 == "" && bi1Field3 == "") {
//                        System.out.println("MEEEEEEEEEEEE");
//                        lastBI = bi1Field2;
//                        baseInstance.put("bi1Field2", bi1Field2);
//                        baseInstance.put("bi1Field3", bi1Field3);
//                    } else if (bi1Field1 != "" && bi1Field2 != "" && bi1Field3 == "") {
//                        System.out.println("EHHHHHHHHHHHHH");
//                        lastBI = bi1Field3;
//                        baseInstance.put("bi1Field1", bi1Field1);
//                        baseInstance.put("bi1Field2", bi1Field2);
//                        baseInstance.put("bi1Field3", bi1Field3);
//                    }
//                } else if (biNumber.equals("2")) {
//                    // bi2
//                    if (bi2Field1 != "" && bi2Field2 == "" && bi2Field3 == "") {
//                        lastBI = bi2Field2;
//                        baseInstance.put("bi2Field2", bi2Field2);
//                        baseInstance.put("bi2Field3", bi2Field3);
//                    } else if (bi2Field1 != "" && bi2Field2 != "" && bi2Field3 == "") {
//                        // MD ME EH
//                        System.out.println("aaaaaaaaaaaaa");
//                        lastBI = bi1Field3;
//                        baseInstance.put("bi2Field1", bi2Field1);
//                        baseInstance.put("bi2Field2", bi2Field2);
//                        baseInstance.put("bi2Field3", bi2Field3);
//
//                    }
//                } else if (biNumber.equals("3")) {
//                    // b3
//                    if (bi3Field1 != "" && bi3Field2 == "" && bi3Field3 == "") {
//                        lastBI = bi3Field2;
//                        baseInstance.put("bi3Field2", bi3Field2);
//                        baseInstance.put("bi3Field3", bi3Field3);
//                    } else if (bi3Field1 != "" && bi3Field2 != "" && bi3Field3 == "") {
//                        // MD ME EH
//                        System.out.println("aaaaaaaaaaaaa");
//                        lastBI = bi3Field3;
//                        baseInstance.put("bi3Field1", bi3Field1);
//                        baseInstance.put("bi3Field2", bi3Field2);
//                        baseInstance.put("bi3Field3", bi3Field3);
//                    }
//                } else if (biNumber.equals("4")) {
//                    // b4
//                    if (bi4Field1 != "" && bi4Field2 == "" && bi4Field3 == "") {
//                        lastBI = bi4Field2;
//                        baseInstance.put("bi4Field2", bi4Field2);
//                        baseInstance.put("bi4Field3", bi4Field3);
//                    } else if (bi4Field1 != "" && bi4Field2 != "" && bi4Field3 == "") {
//
//                        System.out.println("aaaaaaaaaaaaa");
//                        lastBI = bi4Field3;
//                        baseInstance.put("bi4Field1", bi4Field1);
//                        baseInstance.put("bi4Field2", bi4Field2);
//                        baseInstance.put("bi4Field3", bi4Field3);
//                    }
//                }
//
//                else if (biNumber.equals("5")) {
//                    // b5
//                    if (bi5Field1 != "" && bi5Field2 == "" && bi5Field3 == "") {
//                        lastBI = bi5Field2;
//                        baseInstance.put("bi5Field2", bi5Field2);
//                        baseInstance.put("bi5Field3", bi5Field3);
//                    } else if (bi5Field1 != "" && bi5Field2 != "" && bi5Field3 == "") {
//                        // MD ME EH
//                        System.out.println("aaaaaaaaaaaaa");
//                        lastBI = bi5Field3;
//                        baseInstance.put("bi5Field1", bi5Field1);
//                        baseInstance.put("bi5Field2", bi5Field2);
//                        baseInstance.put("bi5Field3", bi5Field3);
//
//                    }
//                } else if (biNumber.equals("6")) {
//                    // b6
//                    if (bi6Field1 != "" && bi6Field2 == "" && bi6Field3 == "") {
//                        lastBI = bi6Field2;
//                        baseInstance.put("bi6Field2", bi6Field2);
//                        baseInstance.put("bi6Field3", bi6Field3);
//                    } else if (bi6Field1 != "" && bi6Field2 != "" && bi6Field3 == "") {
//                        lastBI = bi6Field3;
//                        baseInstance.put("bi6Field1", bi6Field1);
//                        baseInstance.put("bi6Field2", bi6Field2);
//                        baseInstance.put("bi6Field3", bi6Field3);
//                    }
//                } else if (biNumber.equals("7")) {
//                    // b7
//                    if (bi7Field1 != "" && bi7Field2 == "" && bi7Field3 == "") {
//                        lastBI = bi7Field2;
//                        baseInstance.put("bi7Field2", bi7Field2);
//                        baseInstance.put("bi7Field3", bi7Field3);
//                    } else if (bi7Field1 != "" && bi7Field2 != "" && bi7Field3 == "") {
//                        lastBI = bi7Field3;
//                        baseInstance.put("bi7Field1", bi7Field1);
//                        baseInstance.put("bi7Field2", bi7Field2);
//                        baseInstance.put("bi7Field3", bi7Field3);
//
//                    }
//                } else if (biNumber.equals("8")) {
//                    // b8
//                    if (bi8Field1 != "" && bi8Field2 == "" && bi8Field3 == "") {
//                        lastBI = bi8Field2;
//                        baseInstance.put("bi8Field2", bi8Field2);
//                        baseInstance.put("bi8Field3", bi8Field3);
//                    } else if (bi8Field1 != "" && bi8Field2 != "" && bi8Field3 == "") {
//
//                        System.out.println("aaaaaaaaaaaaa");
//                        lastBI = bi8Field3;
//                        baseInstance.put("bi8Field1", bi8Field1);
//                        baseInstance.put("bi8Field2", bi8Field2);
//                        baseInstance.put("bi8Field3", bi8Field3);
//                    }
//                } else if (biNumber.equals("9")) {
//                    // b9
//                    if (bi9Field1 != "" && bi9Field2 == "" && bi9Field3 == "") {
//                        lastBI = bi9Field2;
//                        baseInstance.put("bi9Field2", bi9Field2);
//                        baseInstance.put("bi9Field3", bi9Field3);
//                    } else if (bi9Field1 != "" && bi9Field2 != "" && bi9Field3 == "") {
//                        lastBI = bi9Field3;
//                        baseInstance.put("bi9Field1", bi9Field1);
//                        baseInstance.put("bi9Field2", bi9Field2);
//                        baseInstance.put("bi9Field3", bi9Field3);
//
//                    }
//                }
//                baseInstance.put("biNumber", biNumber);
//                System.out.println("bi.size " + baseInstance.size());
//                System.out.println("bi1Field2 " + bi1Field2);
//                baseInstances[i] = baseInstance;
//            }
//
//            //iots
//            int nbIncludedObjectTypes = 1;//Integer.parseInt(request.getParameter("nbIOT"));
//            Map includedObjectTypes [] = new Map[nbIncludedObjectTypes];
//            System.out.println("nbIOT: " + nbIncludedObjectTypes);
//            for (int k = 0; k < includedObjectTypes.length; k++) {
//                String objectAcronym = request.getParameter("objectAcronym1");
//                String granularity = request.getParameter("granularity1");
//                System.out.println("GetInventoryServlet:objectAcronym1: " + objectAcronym);
//                System.out.println("GetInventoryServlet:granularity1: " + granularity);
//                Map includedObjectType = new HashMap();
//                includedObjectType.put("objectAcronym", objectAcronym);
//                includedObjectType.put("granularity", granularity);
//                includedObjectTypes[k] = includedObjectType;
//            }
//            boolean success = doCreateGetInventoryRequest(baseInstances, includedObjectTypes, lastBI);
//            if (!success)
//                 request.getRequestDispatcher("error.jsp").forward(request, response);
//        }
//
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.close();
//
//        return false;
//    }
//
    
    protected synchronized boolean  processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.request = request;
        this.response = response;
        
        session = request.getSession(true);
        String action = request.getServletPath();
        String lastBI = null;
        
        if (action.equals("/constructRequest.do")) {
            Integer nbBaseInstances  = (Integer)request.getSession().getAttribute("nbBaseInstances");
//            int nbBi = nbBaseInstances.intValue();
            Integer nbIncludedObjectTypes  = (Integer)request.getSession().getAttribute("nbIot");
//            int nbIot = nbIncludedObjectTypes.intValue();
//            System.out.println("nbBi " + nbBi + " nbBIot " + nbIot);
//            String parameterName = (String) request.getSession().getAttribute("paramName");
//            String parameterValue = (String) request.getSession().getAttribute("paramValue");
            
            Map baseInstances = (HashMap) request.getSession().getAttribute("BImap");
//            for (int i = 1; i <= nbBi; i++){
//                //System.out.println("bi1val " + values.get("bi1val1"));
//                System.out.println("bi"+i+"val"+i+ " " + baseInstances.get("bi"+i+"val"+i));
//            }
            Map includedObjectTypes = (HashMap) request.getSession().getAttribute("IOTmap");
//            for (int i = 1; i <= nbIot; i++){
//                System.out.println("objectAcronym"+i+ " "+ includedObjectTypes.get("objectAcronym"+i));
//                System.out.println("granularity"+i+ " "+ includedObjectTypes.get("granularity"+i));
//            }
            System.out.println("nbbbbaseInstances: " + nbBaseInstances.intValue());
            //int nbB = nbBaseInstances.intValue();
            /*for(int i = 0; i < 3; i++) {
                Map baseInstance = new HashMap();
                String baseInstanceType10 = (String) baseInstance.get("baseInstanceType10");
                baseInstance.put("baseInstanceType"+1+i, (String)baseInstances.get("baseInstanceType1"+1+i));
            }*/
            
            
            boolean success = true;// doCreateGetInventoryRequest(baseInstances, includedObjectTypes, lastBI);
            if (!success)
                request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.close();
        return false;
    }
    
    
    
    public boolean doCreateGetInventoryRequest(Map baseInstances, Map includedObjectTypes, String last) throws ServletException, IOException {
        System.out.println("GetInventoryServlet:docreateGetInventoryRequest ");
        String path = null;
        try {
            File resp = getInventoryBean.createGetInventoryRequest(baseInstances, includedObjectTypes);
            path = getServletContext().getRealPath("/") + "" + resp.getName();
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
        }catch (NullPointerException e) {
            System.err.println("Element not in the database !");
            return false;
            //e.printStackTrace();
        } catch (Exception e) {
            System.err.println("File access error !");
            e.printStackTrace();
        }
        
        String pathStyleSheet = getServletContext().getRealPath("/") + "" + "styleSheet3.xsl";
        //String pathStyleSheet = "styleSheet3.xsl";
        String pathTable = getServletContext().getRealPath("/") + "" + "table.html";
        File s = new File(pathStyleSheet);
        File r = new File(path);
        File table = new File(pathTable);
        Stylizer stylizer = new Stylizer();
        stylizer.transform(s, r, table);
        
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
