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
    <!--    Number of Base Instances : 
        <select name="nbBI">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>   <br/>-->
      
        
        <hr>
          Choose a Base Instance number :
         <select name="biNumber">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
             <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
        </select>   <br/> <br/> <br/>
        BaseInstances ME : <br>
        <table border=0>
            <tr> 
                <td width=20> <b> 1</b>  </td>
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi1Field1" value="md1"> </td> 
            <td width=50> ME: </td> <td><input type="text" size="20" name="bi1Field2" value="me1"> </td> 
            <td width=65> EH: </td> <td><input type="text" size="30" name="bi1Field3" value=""> </td>
            </tr>
        </table>
         <table border=0>
            <tr> 
            <td width=20> <b> 2</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi2Field1"> </td> 
            <td width=50> ME: </td> <td><input type="text" size="20" name="bi2Field2"> </td> 
            <td width=65> PTP: </td> <td><input type="text" size="30" name="bi2Field3"> </td>
            </tr>
        </table>
         <table border=0>
            <tr> 
            <td width=20> <b> 3</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi3Field1"> </td> 
            <td width=50> ME: </td> <td><input type="text" size="20" name="bi3Field2"> </td> 
            <td width=65> FTP: </td> <td><input type="text" size="30" name="bi3Field3"> </td>
            </tr>
        </table>
         <table border=0>
            <tr> 
            <td width=20> <b> 4</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi4Field1"> </td> 
            <td width=50> ME: </td> <td><input type="text" size="20" name="bi4Field2"> </td> 
            <td width=65> PGP: </td> <td><input type="text" size="30" name="bi4Field3"> </td>
            </tr>
        </table>
         <table border=0>
            <tr> 
            <td width=20> <b> 5</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi5Field1"> </td> 
            <td width=50> ME: </td> <td><input type="text" size="20" name="bi5Field2"> </td> 
            <td width=65> EPGP: </td> <td><input type="text" size="30" name="bi5Field3"> </td>
            </tr>
        </table>
         <table border=0>
            <tr> 
            <td width=20> <b> 6</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi6Field1"> </td> 
            <td width=50> ME: </td> <td><input type="text" size="20" name="bi6Field2"> </td> 
            <td width=65> CC: </td> <td><input type="text" size="30" name="bi6Field3" value="not yet"> </td>
            </tr>
        </table>
        
        <!-- MSLN -->
        
        <!--<hr>--><br>
        BaseInstances MLSN : <br> 
        <table border=0>
            <tr> 
            <td width=20> <b> 7</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi7Field1"> </td> 
             <td width=50>MLSN: </td><td> <input type="text" size="20" name="bi7Field2"> </td> 
             <td width=65>SNC: </td> <td><input type="text" size="30" name="bi7Field3"> </td> 
           </tr>
        </table>
        
        <table border=0>
            <tr> 
            <td width=20> <b> 8</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi8Field11"> </td> 
            <td width=50> MLSN: </td><td> <input type="text" size="20" name="bi8Field12"> </td> 
            <td width=65> TPPOOL: </td> <td><input type="text" size="30" name="bi8Field13"> </td> 
           </tr>
        </table>
         <table border=0>
            <tr> 
            <td width=20> <b> 9</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi9Field11"> </td> 
            <td width=50> MLSN: </td><td> <input type="text" size="20" name="bi9Field12"> </td> 
            <td width=65> TL: </td> <td><input type="text" size="30" name="bi9Field13"> </td> 
           </tr>
        </table>
        
        <!--    MD: <input type="text" name="MD2" value="Networks/XdrEMS/Server10" />
        ME: <input type="text" name="ME2" value="19968" />
        EH: <input type="text" name="EH2" value="" /><br/>-->
        
         <!-- TL -->
        
        <!--<hr>--><br>
        BaseInstances TL : <br> 
        <table border=0>
            <tr> 
            <td width=20> <b> 7</b>  </td>    
            <td width=10> MD: </td><td> <input type="text" size="30" name="bi10Field1"> </td> 
             <td width=50>TL: </td><td> <input type="text" size="20" name="bi10Field2"> </td> 
           </tr>
        </table>
    </p>
   <!-- <hr>
    <p>
        Number of IncludedObjectTypes :
        <select name="nbIOT">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>   <br/>-->
        <hr>   
        IncludedObjectTypes : <br/><br/>
        ObjectAcronym : 
        <select name="objectAcronym1">
            <option>MD</option>
            <option>ME</option>
            <option>EH</option>
            <option>EQ</option>
            <option>PTP</option>
            <option>FTP</option>
            <option>CTP</option>
            <option>EPGP</option>
            <option>PGP</option>
            <option>SNC</option>
            <option>RT</option>
            <option>CC</option>
            <option>MLSN</option>
            <option>TL</option>
            <option>OS</option>
            <option>TMD</option>
            <option>VO</option>  
        </select>
        Granularity : 
        <select name="granularity1">
            <option>NAME</option>
            <option>ATTRS</option>
            <option>FULL</option>
        </select>
        <br/>
        <!--  ObjectAcronym : 
     <select name="objectAcronym2">
        <option>MD</option>
        <option>ME</option>
        <option>EH</option>
        <option>EQ</option>
        <option>PTP</option>
        <option>FTP</option>
        <option>CTP</option>
        <option>EPGP</option>
        <option>PGP</option>
        <option>SNC</option>
        <option>RT</option>
        <option>CC</option>
        <option>MLSN</option>
        <option>TL</option>
        <option>OS</option>
        <option>TMD</option>
        <option>VO</option>  
    </select>
    
    Granularity : 
    <select name="granularity2">
        <option>NAME</option>
        <option>ATTRS</option>
        <option>FULL</option>
        </select><br/>-->
    </p>  
    <br>
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
