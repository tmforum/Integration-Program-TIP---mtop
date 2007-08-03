<%
String msg = (String)request.getAttribute("msg");
if(msg != null)
out.println("<font size=+1>" + msg + "</font><br/>");
%>
Click <a href="testupload.html">here</a> to go to the upload page.