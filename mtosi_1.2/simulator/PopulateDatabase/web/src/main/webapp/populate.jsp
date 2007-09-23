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
        <title>PopulateDatabase</title>
    </head>
    <body>
        <h1 style="color:blue"><center> PopulateDatabase Application </center></h1>
        <hr>
          <center style="color:red"><c:out value="${requestScope.error}" /></center>
          <center style="color:green"><c:out value="${requestScope.validMsg}" /></center>
        <br>
        <form enctype="multipart/form-data" method=post action="populate.do">
            <p>
                <b>Specify the file you want to populate the database with:</b>
            </p>
            <input type="file" name="xmlFile" size="30">
            <p>
                <input type="submit" name="Submit" value="Populate"/>
            </p>
            
        </form>
    </body>
</html> 


