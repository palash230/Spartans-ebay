<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item added Successfully | eBay</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
<div class="alert alert-success">
You have successfully added Item.<s:property value="itemName"/>
 
</div>
<s:form>
<s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
</s:form>
</body>
</html>