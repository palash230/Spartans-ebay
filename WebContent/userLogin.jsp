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
<title>Login|Registration Page</title>
</head>
<body>
<div class="container text-center">
<s:action name="test" executeResult="true" />
<br><br><br><br><br>

<br>

<div id="userlogin" style="margin-left:250px;float:left;">
<div class="panel panel-default">
	<div class="panel-heading"> <strong class="">User Login</strong>
	</div>
</div>
    <s:form action="UserLogin" name="userLogin">
        Email Id <s:textfield name="emailId"  property="emailId" />
        <br><br>
        Password   <s:password name="passwd"  property="passwd" />
        <br><br>
         <a href="reset.jsp">Forgot your password?</a>
        <s:submit value="Login"  class="btn btn-primary"/> 
      
        
        	</s:form>
  	</div>
  	<div id="userlogin" style="margin-right:250px;float:right;">
  	<div class="panel panel-default">
	<div class="panel-heading"> <strong class="">Registration</strong>
	</div>
</div>
    <s:form action="UserRegister" name="userRegister">
        Email  <s:textfield name="email"  property="email" />
        <br><br>
        Reenter Email   <s:textfield name="reemail"  property="reemail" />
        <br><br>
        Password   <s:password name="password"  property="password" />
          <br><br>
        First Name   <s:textfield name="fname"  property="fname" />
          <br><br>
        Last Name   <s:textfield name="lname"  property="lname" />
             <br><br>
             User Id   <s:textfield name="userId"  property="userId" />
         <br><br>
          Phone no  <s:textfield name="phone_no"  property="phone_no" />
          <br><br>
          Date of Birth  <s:textfield name="dob" value="YYYY/MM/DD"  property="dob" />

             
        <s:submit value="Register"  class="btn btn-primary"/>
        	</s:form>
  	</div>

  <div style="margin-top:400px;">
    <s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
	
	<s:submit action="homePageAction" value="Home" class="btn btn-primary" />
</div>
	</div>

</body>
</html>