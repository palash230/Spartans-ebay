<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acknowledge </title>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<div class="container">
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
<div class="alert alert-danger">
<center>Page is under Construction!!!!</center>
<s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
</div>
</div>
</body>
</html>