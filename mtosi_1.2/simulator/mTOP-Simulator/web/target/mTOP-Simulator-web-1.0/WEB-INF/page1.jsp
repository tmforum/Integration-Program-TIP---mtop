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
        <title>Page 1</title>
    </head>
    <body>

    <h1>Page 1</h1>
    
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
    
    
    <select name="baseInstanceList" multiple="multiple">
        <option>MD;ME;EH</option>
        <option>MD;ME;PTP</option>
        <option>MD;ME;FTP</option>
        <option>MD;ME;PGP</option>
        <option>MD;ME;EPGP</option>
        <option>MD;ME;CC</option>
        <option>MD;MLSN;SNC</option>
        <option>MD;MLSN;TPPOOL</option>
        <option>MD;MLSN;TL</option>
    </select>
    
    </body>
</html>
