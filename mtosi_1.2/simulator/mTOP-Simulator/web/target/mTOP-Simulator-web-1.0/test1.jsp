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
	<head></head>
 
	<script>
 
		function submitForm(clickedButton){
			if(clickedButton.name =="button1"){
				alert("button1");
				document.multipleSubmitDemoForm.action="filter.jsp";
			}else if(clickedButton.name =="button2"){
				alert("button2");
				document.multipleSubmitDemoForm.action="linkToJSPWhenSecondButtonClicked.jsp";
			}else if(clickedButton.name =="button3"){
				alert("button3");
				document.multipleSubmitDemoForm.action="linkToJSPWhenThirdButtonClicked.jsp";
			}
			document.multipleSubmitDemoForm.submit();
		}
	
	</script>
 
	<body>
		<form name="multipleSubmitDemoForm" method="POST" action="" >
 
			<input type="button" name="button1" onClick=submitForm(this) />
 
			<input type="button" name="button2" onClick=submitForm(this) />
 
			<input type="button" name="button3" onClick=submitForm(this) />
 
		</form>
	</body>
</html>