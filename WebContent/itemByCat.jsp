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
	<div class="container">
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
	<s:form>
		<s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
		<s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" />
	</s:form>
</body>
</html>