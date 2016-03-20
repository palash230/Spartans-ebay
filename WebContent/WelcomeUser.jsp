<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%> 
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:action name="test" executeResult="true" />
</br></br></br></br>
<h1 style="margin-left:50px;">Welcome <s:property value="emailId" /></h1>

     		<div class="form-group">
     		<div class="col-lg-10">
     		<br><br>
			<s:submit onCLick="goBack()" value="Previous" class="btn btn-primary" />
			<s:submit action="userLogout" value="Logout" class="btn btn-primary"  />
			<s:submit value="Home" action="homePageAction" class="btn btn-primary" />
			</div></div>     
</body>
</html>