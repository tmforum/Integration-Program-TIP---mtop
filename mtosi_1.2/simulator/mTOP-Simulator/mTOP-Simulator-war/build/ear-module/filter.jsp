<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
        <title></title>
    </head>
    <body>
      <h3>Specify the filter parameters:</h3> 
     Example values are: Base Instance: Networks/XdrEMS/Server10, ObjecType: ME Granularity: ATTRS 
  <form method="POST" action="constructRequest.do" method="POST">         
    <p>
    Base Instance :   
    <input name="baseInstance" type="text" value="Networks/XdrEMS/Server10"/>
    ObjectType : 
    <input name="includedObjectType" type="text" value="ME"/>
    Granularity : 
    <input name="granularity" type="text" value="ATTRS"/>
    <input name="ok" type="submit" value="submit"/>
    <input name="annuler" type="reset" value="cancel"/>
    </p>
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
