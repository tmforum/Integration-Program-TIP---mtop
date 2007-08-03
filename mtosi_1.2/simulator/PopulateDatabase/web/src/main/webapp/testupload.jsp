<%@ page import="org.apache.commons.fileupload.*, java.util.List, java.io.File, java.util.Iterator" %>
<%
boolean isMultipart = FileUpload.isMultipartContent(request);
if(!isMultipart){
request.setAttribute("msg", "Request was not multipart!");
request.getRequestDispatcher("msg.jsp").forward(request, response);
return;
}
String s = "";
DiskFileUpload upload = new DiskFileUpload();
List items = upload.parseRequest(request);
Iterator itr = items.iterator();

while(itr.hasNext()){
FileItem item = (FileItem) itr.next();
if(item.isFormField()) {
String fieldName = item.getFieldName();
if(fieldName.equals("name"))
request.setAttribute("msg", "Thank You: " + item.getString());
} else {
File fullFile = new File(item.getName());
System.out.println("fullFile.getName(): " + fullFile.getName());
File savedFile = new File(getServletContext().getRealPath("/"), fullFile.getName());
item.write(savedFile);
request.setAttribute("fileUpload", fullFile.getName());
s = fullFile.getName();
}
}
String file = (String)request.getAttribute("fileUpload");
file = getServletContext().getRealPath("/") + "" + s;
 System.out.println("file: " + file);
request.getRequestDispatcher("populate.do").forward(request, response);
%>