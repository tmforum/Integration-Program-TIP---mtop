<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
        <title>jj</title>
        <script type="text/javascript" src="unobtrusiveDSBoxes.js"></script>
    </head>
    <SCRIPT LANGUAGE="JavaScript">
     function getHashTable(x)
{   
    document.write ("Un")
}   

allCount=1
allCountIot=1
function addLineBI()
{
var table = document.getElementById('tableBI');

var no=table.rows.length;
var row=table.insertRow(no);

var col1=row.insertCell(0);
col1.appendChild (document.createTextNode(""));
col1.innerHTML="<select name=bi1type"+allCount+"> <option>None</option> <option > MD </option><option > ME </option></select>";


var col2=row.insertCell(1);
col2.innerHTML="<Input Type='Text' name=bi1val"+allCount+">";



var col3=row.insertCell(2);
col3.innerHTML="<select name=bi2type"+allCount+"> <option>None</option> <option > ME </option> <option > MLSN </option></select>";


var col4=row.insertCell(3);
col4.innerHTML="<input type='text' name=bi2val"+allCount+" >";


var col5=row.insertCell(4);
col5.innerHTML="<select name=bi3type"+allCount+"> <option>None</option> <option>EH</option><option>PTP</option><option>FTP</option><option>EPGP</option><option>PGP</option><option>SNC</option><option>RT</option><option>TL</option><option>TMD</option><option>VO</option>  </select>";


var col6=row.insertCell(5);
col6.innerHTML="<input type='text' name=bi3val"+allCount+" >";


var col7=row.insertCell(6);
col7.innerHTML="<select name=bi4type"+allCount+"> <option>None</option> <option>EQ</option><option>CTP</option></select>";



var col8=row.insertCell(7);
col8.innerHTML="<input type='text' name=bi4val"+allCount+" >";


allCount++;

}

function removeLineBI()
{
var tbl = document.getElementById('tableBI');
var lastRow = tbl.rows.length;
if (lastRow > 1) tbl.deleteRow(lastRow - 1);
}

function removeLineIot()
{
var tbliot = document.getElementById('tableIOT');
var lastRowiot = tbliot.rows.length;
if (lastRowiot > 1) tbliot.deleteRow(lastRowiot - 1);
}

function addLineIot()
{
var table = document.getElementById('tableIOT');
var no=table.rows.length;
var row=table.insertRow(no);

var col1=row.insertCell(0);
col1.appendChild (document.createTextNode(""));
col1.innerHTML="<select name=iot1val"+allCountIot+" > <option>Select</option><option >MD</option><option>ME</option</select>";


var col2=row.insertCell(1);
col2.innerHTML="<select name=iot1val"+allCountIot+"> <option>Select</option> <option >NAME</option><option >ATTRS</option><option >FULL</option></select>";
 allCountIot++;
}



function alerter() {
alert("j'ai cliqu�");

}

function length()
{
var t = 5;
return t;
}

function submitForm(clickedButton){
if(clickedButton.name =="send"){
   document.request.action="constructRequest.do";
 }
 else if (clickedButton.name =="previous"){
  document.request.action="filter2.jsp";
 }
document.request.submit();
}
                                                                                              </SCRIPT>
    
    <body>
        <form name="request" method="POST" action="">
            
            <!-- Enum********************************* -->
            <%  
            
            Enumeration parameters = request.getParameterNames();
            System.out.println("enumeration parameters...............");
            int i = -1;
            int a = 0;
            int k = 0;
            int nbIot = 1;
            int nbBaseInstances = 0;
            String parameterName =null;
            String parameterValue =null;
            HashMap BImap = new HashMap();
            HashMap BImapType = new HashMap();
            HashMap IOTmap = new HashMap();
            String objectType = null;
            String granularity = null;
           //String requestedBatchSize = null; 
            
            while(parameters.hasMoreElements()){
                System.out.println("parameters has more elements...............");
                while (i < 0 ) {
                    parameterName = (String)parameters.nextElement();
                    i++;
                }
                i++;
                if (!(parameterName.equals("objectAcronym") || parameterName.equals("granularity"))) {
                    System.out.println("i superieur � 1 " + i +"et parameterName " +  parameterName);
                    do{
                        System.out.println("**do*****************");
                        for(int j = 1; j <= 4; j++) {
                            System.out.println(" jj: " + j);
                            parameterName = (String)parameters.nextElement();
                            parameterValue = (String)request.getParameter(parameterName);
                             System.out.println("parameterName " + parameterName);
                            System.out.println("parameterValue " + parameterValue);
                            System.out.println("parameterName00 " + parameterName.substring(0,1)+"E");
                                
                             if (!(parameterName.substring(0,1).equals("b"))){
                                parameterName = (String)parameters.nextElement();
                                nbBaseInstances--;
                                System.out.println("breakkkkkkkkkkkk1");
                                break;
                            }
                            else {
                                System.out.println("trueeeeeeeeeeeeeeeeeee "); 
                            }
                           
                            BImap.put("baseInstanceType"+j+nbBaseInstances, parameterValue);
                            parameterName = (String)parameters.nextElement();
                            parameterValue = (String)request.getParameter(parameterName);
                             if (!(parameterName.substring(0,1).equals("b"))){
                                parameterName = (String)parameters.nextElement();
                                nbBaseInstances--;
                                System.out.println("break9999999999 " + parameterName);
                                break;
                               
                            }
                            System.out.println("parameterName " + parameterName);
                            System.out.println("parameterValue " + parameterValue);
                            BImap.put("baseInstanceValue"+j+nbBaseInstances, parameterValue);
                        }//for
                        nbBaseInstances++;
                        if(!(parameterName.substring(0,1).equals("b"))){System.out.println("trueeeeeeeeeeeeeeeee");}
                    }
                    while(!(parameterName.substring(0,1).equals("b")));
                }
                System.out.println("BIMAP_SIZE " + BImap.size());
                System.out.println("nbBaseInstances " + nbBaseInstances);
                System.out.println("**********************iotttttttttttttttttt " + nbIot);
                
                // for(int j = 1; j <= 2; j++) {
                System.out.println("aaaaaaaaa11 " + "objectAcronym"+nbIot);
                IOTmap.put("objectAcronym"+nbIot, parameterValue);
                parameterName = (String)parameters.nextElement();
                parameterValue = (String)request.getParameter(parameterName);
                System.out.println("parameterNameA " + parameterName);
                System.out.println("parameterValueA " + parameterValue);
                
                
                //  if (!parameters.hasMoreElements())
                //    break;
                parameterName = (String)parameters.nextElement();
                parameterValue = (String)request.getParameter(parameterName);
                IOTmap.put("granularity"+nbIot, parameterValue);
                System.out.println("aaaaaaaaa22 " + "granularity"+nbIot);
                System.out.println("parameterNameB " + parameterName);
                System.out.println("parameterValueB " + parameterValue);
                
                //}
                nbIot++;
                System.out.println("nbIot " + nbIot);
                
                
            /*  Set entries = BImap.entrySet();
            Iterator iter = entries.iterator();
            while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value );
             */
            /*System.out.println("affiche iotMap...........;");
            entries = IOTmap.entrySet();
            iter = entries.iterator();
            while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value );
            }*/
                System.out.println("nbBaseInstancesseinonn " + nbBaseInstances);
                session.setAttribute("nbBaseInstances", new Integer(nbBaseInstances)) ;
                session.setAttribute("nbIot", new Integer(nbIot));
                session.setAttribute("BImap", BImap);
                session.setAttribute("IOTmap", IOTmap);
                session.setAttribute("objectType", objectType);
                session.setAttribute("granularity", granularity);
                a++;
            }//fin while
            //requestedBatchSize = (String)request.getParameter("requestedBatchSize"); 
            //System.out.println("reqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq " + requestedBatchSize);
            %>
            <!-- Fin Enum********************************* -->
            
            <!--<FORM name="filter2" ACTION="filter.jsp" METHOD=POST>-->
            <!-- <TABLE BORDER=0 CELLSPACING=BaseInstance CELLPADDING=0>
                <TR><td><input type="button" onClick="addline()"  value="add"></td></TR>
            </TABLE>
            -->
           
            <%System.out.println("aaaaaaaa " + a);
            if (a == 0) {%>
            <!-- *********************base Instance************************ --> 
            <p>
                <table align="center"> 
                    <td><font color="blue">Specify the Base Instance</font></td>
                </table>
            </p>
          <!--  <p>
                Base Instance Name: <input type='text' name='BaseInstanceName' size="50">
            </p>-->
            <p>
                <table border="1" id="tableBI">
                    <tr>
                        <th style="font-size: 10pt">BI Type 1</th>
                        <th style="font-size: 10pt">BI Value 1 </th>
                        <th style="font-size: 10pt">BI Type 2</th>
                        <th style="font-size: 10pt">BI Value 2 </th>
                        <th style="font-size: 10pt">BI Type 3</th>
                        <th style="font-size: 10pt">BI Value 3</th>
                        <th style="font-size: 10pt">BI Type 4</th>
                        <th style="font-size: 10pt">BI Value 4</th>
                    </tr>
                </table>
            </p>
            
            
            <p>
                <input type="button" value="Add" onclick="addLineBI();" />
                
                <input type="button" onclick="removeLineBI();" value="Remove last" />
            </p>
            <!-- *********************end base Instance************************ --> 
            
            <!-- *********************included Object Type************************ --> 
            
            <p>
                <table align="center"> 
                    <td><font color="blue">Specify the Included Object Type</font></td>
                </table>
            </p>
           <!-- <p>
                Included Object Type: <input type='text' name='iotname' size="50">
            </p>-->
            <p>
                <table border="1" id="tableIOT">
                    <tr>
                        <th style="font-size: 10pt" width="50">ObjectAcronym</th>
                        <th style="font-size: 10pt">Granularity</th>
                    </tr>
                </table>
            </p>
            <p>
                <input type="button" value="Add" onclick="addLineIot();" />
                <input type="button" onclick="removeLineIot();" value="Remove last" />
            </p>
            
            <!-- *********************end included Object Type************************ --> 
            
            <!-- *********************requested Batch Size************************ --> 
            <!-- <p>
                Requested Batch Size: <input type='text' name=requestedBatchSize size="5">
             </p>-->
            <hr>
            <input type=submit value=submit> 
            <%}
            else { %>
            <!-- *********************print request************************ --> 
             Base Instances:
             <table>
                 <% 
                 //  Map baseInstances = (HashMap) request.getSession().getAttribute("BImap");
                 Map baseInstances = (HashMap) request.getSession().getAttribute("BImap");
                 for (k = 0; k < nbBaseInstances; k++) {
                 %><tr>
                     <td>
                          (
                        <% if(!(baseInstances.get("baseInstanceType1"+k).equals("None")))%>
                        <%=baseInstances.get("baseInstanceType1"+k)%>=<%=baseInstances.get("baseInstanceValue1"+k)%>,
                        <% if  (!(baseInstances.get("baseInstanceType2"+k).equals("None"))){%>
                          <%=baseInstances.get("baseInstanceType2"+k)%>=<%=baseInstances.get("baseInstanceValue2"+k)%>,
                           <%}%>
                        <% if(!(baseInstances.get("baseInstanceType3"+k).equals("None"))){%>
                        <%=baseInstances.get("baseInstanceType3"+k)%>=<%=baseInstances.get("baseInstanceValue3"+k)%>,
                         <%}%>
                        <% if(!(baseInstances.get("baseInstanceType4"+k).equals("None"))){%>
                        <%=baseInstances.get("baseInstanceType4"+k)%>=<%=baseInstances.get("baseInstanceValue4"+k)%>)
                         <%}%>
                     </td>  
                 </tr>    
                 <%}%>
                <tr>
                    <td>
                        <input type="button" name="send" value="send request" onClick=submitForm(this) />
                    </td>
                    <td>
                        <input type="button" name="previous" value="previous" onClick=submitForm(this) />
                    </td>
                </tr>
            </table>
            <%}%>
        </form>
    </body>
</html>

