<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@page import="java.sql.*"%>  
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Item | ebay </title>
<script>
function goBack() {
    window.history.back();
}
</script>
<style type="text/css">
.errorMessage {
  font-weight: light;
  color: red;
}
body {
    background-color: GhostWhite ;
}
h3{
    
    font-weight:bold;
    
    color:grey	;

    }
    .sell{
    color:black;
    }
      h4{
    
    font-weight:bold;
    
    color:grey;

    }
    h2{
    
    font-weight:bold;
    
    color:GhostWhite;;

    }
    
    .banner{
    width:100%;
    max-height:300px;
        }
        .jumbotron{
        background-color: DodgerBlue ;
        }
</style>

</head>

<body>
<s:action name="call" executeResult="true">
<div class="container text-center">
<br><br><br><br>
	<div class="jumbotron">
		<h2>Sell on Ebay Marketplace</h2>
		<p class="sell">Join thousands of merchants selling their items on India's largest
	<br>
	mobile commerce platform!</p>
	</div>
	<h5>Seller Id Logged in is <%=session.getAttribute("user") %></h5>
	<a href="logout.action">Logout</a>
</div>
</s:action>
</body>
</html>