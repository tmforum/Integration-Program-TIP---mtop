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
<title> mTOP-Simulator - GetInventory </title>
<head>
    <SCRIPT LANGUAGE="JavaScript">
nbBIs = 1;
nbIOTs = 1;


function addBI(id){
var tbody1 = document.getElementById(id).getElementsByTagName("TBODY")
[0];

var row1 = document.createElement("TR");
var td1 = document.createElement("TD");
td1.appendChild(document.createTextNode(""));
var td2 = document.createElement("TD");
td2.appendChild (document.createTextNode(""));
var td3 = document.createElement("TD");
td3.appendChild (document.createTextNode(""));
var td4 = document.createElement("TD");
td4.appendChild (document.createTextNode(""));
var td5 = document.createElement("TD");
td5.appendChild(document.createTextNode(""));
var td6 = document.createElement("TD");
td6.appendChild (document.createTextNode(""));
var td7 = document.createElement("TD");
td7.appendChild (document.createTextNode(""));
var td8 = document.createElement("TD");
td8.appendChild (document.createTextNode(""));
var td9 = document.createElement("TD");
td9.appendChild (document.createTextNode(""));

var sel1 = document.createElement("select");
sel1.setAttribute("name","bi"+nbBIs+"type1");
var opt0Type1 = document.createElement("option");
var opt1Type1 = document.createElement("option");
opt0Type1.setAttribute("value"," ");
opt1Type1.setAttribute("value","MD");
opt0Type1.appendChild(document.createTextNode(' '));
opt1Type1.appendChild(document.createTextNode('MD'));
sel1.appendChild(opt0Type1);
sel1.appendChild(opt1Type1);
td1.appendChild(sel1);
var bival1 = document.createElement("input");
bival1.setAttribute("type","text");
bival1.setAttribute("name","bi"+nbBIs+"val1");
td2.appendChild(bival1);

var sel2 = document.createElement("select");
sel2.setAttribute("name","bi"+nbBIs+"type2");
var opt0Type2 = document.createElement("option");
var opt1Type2 = document.createElement("option");
var opt2Type2 = document.createElement("option");
var opt3Type2 = document.createElement("option");
opt0Type2.setAttribute("value"," ");
opt1Type2.setAttribute("value","ME");
opt2Type2.setAttribute("value","MLSN");
opt3Type2.setAttribute("value","TL");
opt0Type2.appendChild(document.createTextNode(' '));
opt1Type2.appendChild(document.createTextNode('ME'));
opt2Type2.appendChild(document.createTextNode('MLSN'));
opt3Type2.appendChild(document.createTextNode('TL'));
sel2.appendChild(opt0Type2);
sel2.appendChild(opt1Type2);
sel2.appendChild(opt2Type2);
sel2.appendChild(opt3Type2);
td3.appendChild(sel2);
var bival2 = document.createElement("input");
bival2.setAttribute("type","text");
bival2.setAttribute("name","bi"+nbBIs+"val2");
td4.appendChild(bival2);

var sel3 = document.createElement("select");
sel3.setAttribute("name","bi"+nbBIs+"type3");
var opt0Type3 = document.createElement("option");
var opt1Type3 = document.createElement("option");
var opt2Type3 = document.createElement("option");
var opt3Type3 = document.createElement("option");
var opt4Type3 = document.createElement("option");
var opt5Type3 = document.createElement("option");
var opt6Type3 = document.createElement("option");
var opt7Type3 = document.createElement("option");
opt0Type3.setAttribute("value"," ");
opt1Type3.setAttribute("value","EH");
opt2Type3.setAttribute("value","PTP");
opt3Type3.setAttribute("value","FTP");
opt4Type3.setAttribute("value","PGP");
opt5Type3.setAttribute("value","EPGP");
opt6Type3.setAttribute("value","SNC");
opt7Type3.setAttribute("value","TPPool");
opt0Type3.appendChild(document.createTextNode(' '));
opt1Type3.appendChild(document.createTextNode('EH'));
opt2Type3.appendChild(document.createTextNode('PTP'));
opt3Type3.appendChild(document.createTextNode('FTP'));
opt4Type3.appendChild(document.createTextNode('PGP'));
opt5Type3.appendChild(document.createTextNode('EPGP'));
opt6Type3.appendChild(document.createTextNode('SNC'));
opt7Type3.appendChild(document.createTextNode('TPPool'));
sel3.appendChild(opt0Type3);
sel3.appendChild(opt1Type3);
sel3.appendChild(opt2Type3);
sel3.appendChild(opt3Type3);
sel3.appendChild(opt4Type3);
sel3.appendChild(opt5Type3);
sel3.appendChild(opt6Type3);
sel3.appendChild(opt7Type3);
td5.appendChild(sel3);
var bival3 = document.createElement("input");
bival3.setAttribute("type","text");
bival3.setAttribute("name","bi"+nbBIs+"val3");
td6.appendChild(bival3);

var sel4 = document.createElement("select");
sel4.setAttribute("name","bi"+nbBIs+"type4");
var opt0Type4 = document.createElement("option");
var opt1Type4 = document.createElement("option");
var opt2Type4 = document.createElement("option");
opt0Type4.setAttribute("value"," ");
opt1Type4.setAttribute("value","EQ");
opt2Type4.setAttribute("value","CTP");
opt0Type4.appendChild(document.createTextNode(' '));
opt1Type4.appendChild(document.createTextNode('EQ'));
opt2Type4.appendChild(document.createTextNode('CTP'));
sel4.appendChild(opt0Type4);
sel4.appendChild(opt1Type4);
sel4.appendChild(opt2Type4);
td7.appendChild(sel4);
var bival4 = document.createElement("input");
bival4.setAttribute("type","text");
bival4.setAttribute("name","bi"+nbBIs+"val4");
td8.appendChild(bival4);


row1.appendChild(td1);
row1.appendChild(td2);
row1.appendChild(td3);
row1.appendChild(td4);
row1.appendChild(td5);
row1.appendChild(td6);
row1.appendChild(td7);
row1.appendChild(td8);
row1.appendChild(td9);

tbody1.appendChild(row1);
nbBIs++;
}


function addIOT(id) {
var tbody1 = document.getElementById(id).getElementsByTagName("TBODY")
[0];
var row1 = document.createElement("TR");
var td1 = document.createElement("TD");
td1.appendChild(document.createTextNode(""));
var td2 = document.createElement("TD");
td2.appendChild (document.createTextNode(""));

var seloa = document.createElement("select");
seloa.setAttribute("name","iot"+nbIOTs+"oa");
var oa1 = document.createElement("option");
var oa2 = document.createElement("option");
var oa3 = document.createElement("option");
var oa4 = document.createElement("option");
var oa5 = document.createElement("option");
var oa6 = document.createElement("option");
var oa7 = document.createElement("option");
var oa8 = document.createElement("option");
var oa9 = document.createElement("option");
var oa10 = document.createElement("option");
var oa11 = document.createElement("option");
var oa12 = document.createElement("option");
var oa13 = document.createElement("option");
oa1.setAttribute("value","MD");
oa2.setAttribute("value","ME");
oa3.setAttribute("value","MLSN");
oa4.setAttribute("value","TL");
oa5.setAttribute("value","EH");
oa6.setAttribute("value","PTP");
oa7.setAttribute("value","FTP");
oa8.setAttribute("value","PGP");
oa9.setAttribute("value","EPGP");
oa10.setAttribute("value","SNC");
oa11.setAttribute("value","TPPool");
oa12.setAttribute("value","EQ");
oa13.setAttribute("value","CTP");
oa1.appendChild(document.createTextNode('MD'));
oa2.appendChild(document.createTextNode('ME'));
oa3.appendChild(document.createTextNode('MLSN'));
oa4.appendChild(document.createTextNode('TL'));
oa5.appendChild(document.createTextNode('EH'));
oa6.appendChild(document.createTextNode('PTP'));
oa7.appendChild(document.createTextNode('FTP'));
oa8.appendChild(document.createTextNode('PGP'));
oa9.appendChild(document.createTextNode('EPGP'));
oa10.appendChild(document.createTextNode('SNC'));
oa11.appendChild(document.createTextNode('TPPool'));
oa12.appendChild(document.createTextNode('EQ'));
oa13.appendChild(document.createTextNode('CTP'));
seloa.appendChild(oa1);
seloa.appendChild(oa2);
seloa.appendChild(oa3);
seloa.appendChild(oa4);
seloa.appendChild(oa5);
seloa.appendChild(oa6);
seloa.appendChild(oa7);
seloa.appendChild(oa8);
seloa.appendChild(oa9);
seloa.appendChild(oa10);
seloa.appendChild(oa11);
seloa.appendChild(oa12);
seloa.appendChild(oa13);

var selgran = document.createElement("select");
selgran.setAttribute("name","iot"+nbIOTs+"gran");
var gran1 = document.createElement("option");
var gran2 = document.createElement("option");
var gran3 = document.createElement("option");
gran1.setAttribute("value","NAME");
gran2.setAttribute("value","ATTRS");
gran3.setAttribute("value","FULL");
gran1.appendChild(document.createTextNode('NAME'));
gran2.appendChild(document.createTextNode('ATTRS'));
gran3.appendChild(document.createTextNode('FULL'));
selgran.appendChild(gran1);
selgran.appendChild(gran2);
selgran.appendChild(gran3);

td1.appendChild(seloa);
td2.appendChild(selgran);
row1.appendChild(td1);
row1.appendChild(td2);
tbody1.appendChild(row1);

nbIOTs++;
}

function removeBI()
{
var tbl = document.getElementById('tableBI');
var lastRow = tbl.rows.length;
if (lastRow > 1) tbl.deleteRow(lastRow - 1);
}

function removeIOT()
{
var tbliot = document.getElementById('tableIOT');
var lastRowiot = tbliot.rows.length;
if (lastRowiot > 1) tbliot.deleteRow(lastRowiot - 1);
}
    </script>
</head>

<body>
<div align="center" id=image>
    <img src="mtosi1.jpg"/>
</div>
<h1 style="color: mediumslateblue; text-align:center">
    GetInventory 
</h1>
<form name="request" method="POST" action="constructRequest.do">
    <p>
        <font color="blue">Specify the requestedBatchSize: </font><input type="text" size="5" name="rqbs" value="0" /> 
    </p>
    <!-- *********************base Instance************************ --> 
    <div align="left"> 
        <font color="blue">Specify the Base Instance</font>
    </div>
    <br>
    <table border="1" id="tableBI">
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
        <script>addBI("tableBI");</script>
    </table>
    
    <p>
        <input type="button" value="Add" onclick="addBI('tableBI');" />
        <input type="button" onclick="removeBI();" value="Remove last" />
    </p>
    
    <!-- *********************end base Instance************************ --> 
    
    <!-- *********************included Object Type************************ --> 

    
    <div align="left"> 
        <font color="blue">Specify the Included Object Type</font>
    </div>
    <br>
    <table border="1" id="tableIOT">
        <tr>
            <th>ObjectAcronym</th>
            <th>Granularity</th>
        </tr>
        <script>addIOT("tableIOT");</script>
    </table>
    </p>
    <p>
        <input type="button" value="Add" onclick="addIOT('tableIOT');" />
        <input type="button" onclick="removeIOT();" value="Remove last" />
    </p>
    <br>
    <input type=submit value="send getInventory request"> 
    
    <table align="center">
        <td style="color:red"><c:out value="${requestScope.error}" /><td>
    </table>
    <c:if test="${requestScope.ok == true}">
        <c:if test="${requestScope.allRetrieved == true}">
            <div align="center">
                <c:choose>
                    <c:when test="${requestScope.lastRequestWasIterator == true}">
                     <font style="color:green"> All managed entities were retrieved on <c:out value="${requestScope.iteratorRequest}" /> </font>
                    </c:when>
                    <c:otherwise>
                        <font style="color:green"> All managed entities were retrieved.</font>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:if>
        
        <hr>
        <font size="4" style="color:Teal">Last GetInventory Request was:</font>
        <% 
        Map baseInstances = (HashMap) request.getSession().getAttribute("BImap");
        Map includedObjectTypes = (HashMap) request.getSession().getAttribute("IOTmap");
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
        
    </c:if>
    
    
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
