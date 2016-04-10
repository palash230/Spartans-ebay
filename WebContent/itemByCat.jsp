<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>
<script>
function goBack() {
    window.history.back();
}
function filterprice()
{
	document.filter.submit();
	}
</script>
</head>
<body>
	<div class="container text-center">
		<s:action name="test" executeResult="true" />
		<br><br><br><br><br>
		<ul class="breadcrumb">
			<li><s:property value="catName"/></li> 
	  		<s:if test="%{subCatName!=null}">
	  			<li><s:property value="subCatName"/></li>
	  		</s:if>
		</ul>
	</div>
	<div class="row">
	
	<div class="col-sm-3 col-md-6 col-lg-2">
	<div class="leftnav bottom-padding40" id ="leftnav">
	<label>Filter by:</label>
	<div class="lftnav-lbl">
	<label>Price Range</label>
	</div>
	<div>
	<s:form action="filter">
	<s:hidden name="catId" value="%{itemCatId}"/>
	<s:hidden name="subcatId" value="%{itemSubCatId}"/>
	<s:hidden name="catName" value="%{catName}"/>
	<s:hidden name="subCatName" value="%{subCatName}"/>
	&nbspBelow 500  <s:checkbox name="checkMe" fieldValue="option1" label="Below 500" onclick="filterprice()"/><br>
	&nbsp500-1000   <s:checkbox name="checkMe1" fieldValue="option2" label="500-1000" onclick="filterprice()"/><br> 
	&nbspAbove 1000 <s:checkbox name="checkMe2" fieldValue="option3" label="Above 1000" onclick="filterprice()"/><br>
	<label>Color</label>
	<s:textfield id="color" name="color"></s:textfield>
	<s:submit action="filter" value="Choosecolor"></s:submit>
	</s:form>
	</div>
	
	</div>
	</div>
	<div class="container">
	<div class="col-sm-9 col-md-6 col-lg-8">
 	<%int count=0; %>
		<s:iterator value="itemList" status="rowStatus">
		<% if((count++)%2==0) {
		%>
		<div class="row">
		<%} %>      
        	<div class="col-sm-5">
	          <div class="well">
	  			<div class="well1">
	  			 <s:url id="cart" action="addtocart" var="myurl">
	<s:param name="itemId"><s:property value="itemId"/></s:param>
		<s:param name="SellerId"><s:property value="seller_id"/></s:param>
		<s:param name="cost"><s:property value="cost"/></s:param>
</s:url>
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:250px;width:450px" class="img-thumbnail" width="100" alt="Image">
	  			</div>	 
	  			 <b>Item Id :</b>			
					<s:property value="itemId"/>
					<br> 
					<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
					<b>Cost </b><s:property value="cost"/> <br>
					<b> Seller Id </b><s:property value="seller_id"/><br>
					<b>Discount</b><s:property value="discount"/><br>
	             	<a href="construction.jsp"><button type="button" class="btn btn-default btn-sm"><span class="glyphicon"></span>Buy Now</button></a>
	         	    <a href="${myurl}"><button type="button" class="btn btn-default btn-sm"><span class="glyphicon"></span>Add to cart</button></a>
	         
	          </div>
	        </div>
		<%if(count%2==0) {%>
		</div>	
		<%} %>
	</s:iterator>
	<% if(count%2!=0) {%>
	</div>
	<%} %>
	
	<div class="row">
	<div class="col-sm-3 col-md-6 col-lg-2"> </div>
	<div class ="col-sm-9 col-md-6 col-lg-8">
	<s:form>
		<s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
		<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
	</s:form>
	</div>
	</div>
	</div>
</body>
</html>