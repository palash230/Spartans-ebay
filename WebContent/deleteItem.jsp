<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="loginCheck.jsp" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete item | ebay </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
<style> 
.jumbotron{ 
background-color: DodgerBlue ; 
color:GhostWhite 
} 
.dropdown { 
-webkit-appearance: none; 
-moz-appearance: none; 
text-indent: 1px; 
text-overflow: '';
width:150px; 
} 
</style>
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<div class="container text-center"  >
<s:action name="test" executeResult="true" />
<br><br><br><br><br>
<div class="jumbotron">
  <h2> Delete the item </h2>
</div>
<h5>Seller Id Logged in is <%=session.getAttribute("user") %></h5>
	<a href="logout.action">Logout</a>
<br><br><br><br><br>
<s:form method="post" action="deleteItemAction" label="A sample horizontal Form" >
  <div class="form-group">Item key :
  <s:doubleselect value="itemKey" 
  	name="itemId" headerValue="Select Item Name" 
  	headerKey="0" list="itemIdList1" listValue="itemId" 
  	listKey="itemId" doubleName="test" doubleList="itemName" 
  	doubleCssClass="dropdown" ></s:doubleselect>
  <s:fielderror>
  	<s:param>itemId</s:param>
  </s:fielderror>
  <br>
  <br>  
  <s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
  <s:submit action="deleteItem" value="Delete Item" class="btn btn-primary"/>
  <s:submit action="homePageAction" value="Home" class="btn btn-primary"/>
</div>
</s:form>
</div>
</body>
</html>