<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <SCRIPT LANGUAGE="JavaScript">
function submitForm(clickedButton){
if(clickedButton.name =="send"){
   document.multipleSubmitDemoForm.action="constructRequest.do";
 
 }
        </SCRIPT>
        
  
    <table>
        <tr>
            <td>You sent request: </td>
            <% 
          //  Map baseInstances = (HashMap) request.getSession().getAttribute("BImap");
            Map baseInstances = (HashMap) request.getSession().getAttribute("BImap");
               for (int i = 0; i < nbBaseInstances; i++) {
                     %><tr>
                            <td>
                                (<%=baseInstances.get("baseInstanceType1"+i)%>=<%=baseInstances.get("baseInstanceValue1"+i)%>,
                                <%=baseInstances.get("baseInstanceType2"+i)%>=<%=baseInstances.get("baseInstanceValue2"+i)%>,
                                <%=baseInstances.get("baseInstanceType3"+i)%>=<%=baseInstances.get("baseInstanceValue3"+i)%>)
                            </td>  
                        </tr>    
                <%}%>
                
            
            
            Set entries = baseInstances.entrySet();
            Iterator iter = entries.iterator();
            while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();%>
            <td>key <%=key%></td>
            <td>value= <%=value%></td>
        </tr>
        <tr>
            <td>
                <input type="button" name="send" value="send request" onClick=submitForm(this) />
            </td>
        </tr>
    </table>
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
