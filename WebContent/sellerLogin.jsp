<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<title>Login Page</title>
</head>
<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
<div class="panel panel-default">
	<div class="panel-heading"> <strong class="">Seller Login</strong>
	</div>
</div>
<br>
    <s:form action="sellerLogin" name="sellerLogin">
        User Name  <s:textfield name="userId"  property="userId" />
        <br><br>
        Password   <s:password name="passwd"  property="passwd" />
        <br><br>
    <s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
	<s:submit value="Login"  class="btn btn-primary"/>
	<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
	</s:form>
	</div>
</body>
</html>