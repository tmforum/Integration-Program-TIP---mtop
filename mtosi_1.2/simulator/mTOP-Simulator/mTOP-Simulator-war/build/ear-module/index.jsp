<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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

    <h1>JSP Page</h1>
    <FORM ENCTYPE="multipart/form-data" method=post action="NewServlet">
    <p>
    <INPUT TYPE="file" NAME="example">
    <input type="submit" value="upload" name="populate" />
    <input name="annuler" type="reset" value="Annuler"/>
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
    
<form method="POST" action="constructRequest" method="POST">
   <input type="hidden" name="fichier" value="<%= request.getAttribute("namefichier") %>"/>
    <p>
       <center style="color:green"><%=(request.getAttribute("namefichier") != null ? request.getAttribute("namefichier") : "")%></center>
    </p>
    <p>
    Base Instance :   
    <input name="baseInstance" type="text"/><br/>
    IncludedObjectType : 
    <input name="includedObjectType" type="text"/><br/>
    Granularity : 
    <input name="granularity" type="text"/><br/>
    <input name="ok" type="submit" value="Valider"/>
    <input name="annuler" type="reset" value="Annuler"/>
    </p>
</form>
    
    
    
    
    </body>
</html>
