<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay </title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<style>
	.body{
	padding-top: 40px;
	}
		.dropdown-menu.multi-column {
	        width: 700px;
	  	}
	    .navbar {
	      margin-bottom: 0;
	      border-radius: 0;  
	    }
		.dropdown-menu.multi-column .dropdown-menu {
	        display: block !important;
	        position: static !important;
	        margin: 0 !important;
	        border: none !important;
	        box-shadow: none !important;
	        min-width:100px;
	  	}
		.carousel-inner img {
	    	width: 100%; /* Set width to 100% */
	      	margin: auto;
	      	min-height:200px;
		  	max-height:400px;
	  	}  
	</style>	
	<script src="bootstrap/js/jquery-2.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="bootstrap/css/owl.theme.css" rel="stylesheet" media="screen">
	<link href="bootstrap/css/owl.carousel.css" rel="stylesheet" media="screen">
	<script src="bootstrap/js/owl.carousel.js"></script>
	<script src="bootstrap/js/owl.carousel.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</head>
<body>
	
	
	    <nav class="navbar navbar-default navbar-fixed-top" >
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        			<span class="icon-bar"></span>
	        			<span class="icon-bar"></span>
	        			<span class="icon-bar"></span>                        
      				</button>
      				<!-- THIS IS ADDED FOR APP TYPE.. IF SMALL SCREENS SIZE -->
					<a class="navbar-brand" href="indexCopy.jsp" class="pull-left">
					<img src="bootstrap/Images/test.png"/>
					</a>																											
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
					<li><a href="itemManagement.jsp">Item Management</a></li> 
					<li><a href="register.jsp">Register(Seller)</a></li>
					<li class="dropdown">
						<a href="#" data-toggle="dropdown" class="dropdown-toggle" aria-expanded="true">
    					Shop by<br />Category <span class="caret"></span></a>
					<div class="dropdown-menu multi-column">
                     <%int count =0; %> 
				          <s:iterator value="subCatList" status="rowStatus">
			              <% if(count%3==0) {%>
			            	<div class="row">
           						 <%} %>
           						 <div class="col-md-4">
				                    <ul class="dropdown-menu">
				                    <s:url action="itemByCat.action" var="urlTag" >
	    								<s:param name="itemCatId"><s:property value="catId"/></s:param>
	    								<s:param name="itemSubCatId"></s:param>
	    								<s:param name="catName"><s:property value="catName"/></s:param>
	    								<s:param name="subCatName"></s:param>
									</s:url>
					                <li><a href="${urlTag}"><strong><s:property value="catName"/></strong></a></li>
						  				<s:iterator value="subCat" var="studentElement">
										<s:iterator value="studentElement">
										<s:url action="itemByCat.action" var="urlTag" >
    										<s:param name="itemCatId"><s:property value="catId"/></s:param>
    										<s:param name="itemSubCatId"><s:property value="key"/></s:param>
    										<s:param name="catName"><s:property value="catName"/></s:param>
    										<s:param name="subCatName"><s:property value="value"/></s:param>
										</s:url>
										<li><a href="${urlTag}"><s:property value="value"/><br></a></li>	
										</s:iterator>
										</s:iterator>
					  				   </ul>
	  								</div>
			  			   <%count++;
			  				   if(count%3==0){
			  				   %>
	  							</div>
	  						<%} %>
	  					</s:iterator>		       
				        </div>
						</li>
					</ul>
					<ul>
					<s:form action="report">
				 <s:select name="reportcat" list="subCatList" listValue="catName" listKey="catId">
                      <s:submit action="myreport" value="GenerateReport">
                    </s:submit>                 
                  </s:select>
                  </s:form>
					</ul>
					<ul class="nav navbar-nav navbar-right">
	    				<li><a href="adminLogin.jsp"> ADMIN | </a></li>
	    				<li><a href="Sellerid.jsp"> LabExam-02| </a></li>
	     				<li><a href="sellerLogin.jsp"> SELLER | </a></li>
	      				<li><a href="userLogin.jsp"> CUSTOMER | </a></li>
					</ul>
				</div>
			</div>
		</nav>
		<br><br><br><br>
		
	<div class="row">
		<div class="col-md-2">	
		<a href="sign.jsp">Sign-in/Register</a>
		</div>
		
		<div class="col-md-1">
		<a href="dealsAction">Deal</a>
		</div>
	  	
	  	
	  	<div class="col-md-1">
		<a href="construction.jsp">Sell</a>
		</div>
	  	<div class="col-md-2">
		<a href="trackOrder.action">Track My Order</a>
		</div>
		<div class="col-md-2">
		<a href="changeMyTrack.action">Change My Order Change</a>
		</div>
		<div class="col-md-1">
		<a href="construction.jsp">My eBay</a>
		</div>
		<div class="col-md-1">
		<a href="construction.jsp">My PaisaPay</a>
		</div>
		<div class="col-md-1">
		<a href=""><span class="glyphicon glyphicon-bell"></span></a>
		</div>
		<div class="col-md-1">
		<a href="addtocart.action"><span class="glyphicon glyphicon-shopping-cart"></span></a>
		</div>
	</div>
</body>
</html>