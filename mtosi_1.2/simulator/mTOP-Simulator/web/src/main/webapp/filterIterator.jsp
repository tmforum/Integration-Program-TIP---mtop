<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> mTOP-Simulator - GetInventoryIterator </title>
    </head>
    
    <body>
        <div align="center" id=image>
            <img src="mtosi1.jpg"/>
        </div>
        <h1 style="color: mediumslateblue; text-align:center">
            GetInventoryIterator 
        </h1>
        <form name="request" method="POST" action="iterator.do">
            
            <p>
                <font color="blue">Specify RequestedBatchSize for next request: </font>
                <input type="text" name="rqbs" value="0" size="5"/> 
            </p>
            <input type=submit value="Send a GetInventoryIterator request"> 
            
            <hr>
            <font size="4" style="color:Teal">Last GetInventory Request was:</font>            
            <% 
            Map baseInstances = (HashMap) request.getSession().getAttribute("BImap");
            Map includedObjectTypes = (HashMap) request.getSession().getAttribute("IOTmap");
            System.out.println("baseInstanceType10 " + baseInstances.get("baseInstanceType10"));
            System.out.println("granularity0 " + includedObjectTypes.get("granularity0"));
            System.out.println("objT0 " + includedObjectTypes.get("objectAcronym0"));
            System.out.println("granularity1 " + includedObjectTypes.get("granularity1"));
            System.out.println("objT1 " + includedObjectTypes.get("objectAcronym1"));
            %>
            <div style="position:relative; left:10px">
                <p>
                    BaseInstance
                    <table border="1">
                        <tr>
                            <th style="font-size: 10pt">Type 1</th>
                            <th style="font-size: 10pt">Value 1</th>
                            <th style="font-size: 10pt">Type 2</th>
                            <th style="font-size: 10pt">Value 2</th>
                            <th style="font-size: 10pt">Type 3</th>
                            <th style="font-size: 10pt">Value 3</th>
                            <th style="font-size: 10pt">Type 4</th>
                            <th style="font-size: 10pt">Value 4</th>
                        </tr>
                        <% 
                        Integer nbBaseInstances = (Integer) session.getAttribute("nbBaseInstances");
                        for (int k = 0; k < nbBaseInstances.intValue(); k++) {
                        %><tr>
                            <td>
                                <%=baseInstances.get("baseInstanceType1"+k)%>
                            </td>
                            <td>
                                <%=baseInstances.get("baseInstanceValue1"+k)%>
                            </td>
                            <td>
                                <%=baseInstances.get("baseInstanceType2"+k)%>
                            </td>
                            <td>
                                <%=baseInstances.get("baseInstanceValue2"+k)%>
                            </td>
                            <td>
                                <%=baseInstances.get("baseInstanceType3"+k)%>
                            </td>
                            <td>
                                <%=baseInstances.get("baseInstanceValue3"+k)%>
                            </td>
                            <td>
                                <%=baseInstances.get("baseInstanceType4"+k)%>
                            </td>
                            <td>
                                <%=baseInstances.get("baseInstanceValue4"+k)%>
                            </td>  
                        </tr>    
                        <%}%>
                    </table>
                </p>
            </div>
            <div style="position:relative; left:10px">
                <p>
                    IncludedObjectType 
                    <table border="1">
                        <tr>
                            <th style="font-size: 10pt">ObjectAcronym</th>
                            <th style="font-size: 10pt">Granularity</th>
                        </tr>
                        <% 
                        Integer nbIOTs = (Integer) session.getAttribute("nbIOTs");
                        for (int k = 0; k < nbIOTs; k++) {
                        %><tr>
                            <td>
                                <%=includedObjectTypes.get("objectAcronym"+k)%>
                            </td>
                            <td>
                                <%=includedObjectTypes.get("granularity"+k)%>
                            </td>
                        </tr>    
                        <%}%>
                    </table>
                </p>
            </div>
            
            <div style="position:relative; left:10px">
                <p>
                    <table align="center">
                        <td style="color:green"> <c:out value="${requestScope.iteratorRequest}" /> <td>
                    </table>
                    
                    <table>
                        <tr>
                            <td width="50">Result</td>
                            <td width="70"><a href="response.xml">Xml file</a></td>
                            <td><a href="table.html">Html table</a></td>
                        </tr>
                    </table>
                </p>
            </div>
            <hr>
            
        </form>
        
        
        <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
        --%>
        <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
        
    </body>
</html>
