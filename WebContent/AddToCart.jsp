<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.t2 {
    -moz-tab-size: 16; /* Code for Firefox */
    -o-tab-size: 16; /* Code for Opera 10.6-12.1 */
    tab-size: 16;
}
</style>
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
		<br><br><br><br><br>
			<s:action name="test" executeResult="true" />
	</div>
<div class="panel panel-default">
	<div class="panel-heading"> <strong class="">Items in Cart!!!!</strong>
	 <div align="right">
	 		<b>Total cost =  </b><s:property value="total_cost"/> <br>
	 
	          </div>
	</div>
</div>
<br>
	<div class="container">
		<s:iterator value="itemList" status="rowStatus">
		<div class="row">     
        	<div class="col-sm-12">
	          <div class="well">
	  			<div class="well1">
	  				 <s:url id="cart" action="remove" var="myurl">
	<s:param name="itemId"><s:property value="itemId"/></s:param>
</s:url>
 				 <div align="right">
	         	    <a href="${myurl}">remove</a>
	          </div>
	          
	          
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:100px;width:250px" class="img-thumbnail" width="100" alt="Image">
	  			<div class="t2">
	  			
	  			 <b>Item Id :</b>			
					<s:property value="itemId"/>
					
					<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
					<b>Cost </b><s:property value="cost"/> <br>
					<b> Seller Id </b><s:property value="seller_id"/><br>
					<b> Quantity </b><s:textfield name="quantity"  property="quantity" value="1" size="2"/><br>
					
					</div>
	             </div>
	         </div>
	         
	        </div>
		</div>	
	</s:iterator>
	</div>
	<s:form>
		<s:submit value="Continue Shopping" class="btn btn-primary" action="homePageAction"/>
		<s:submit value="Previous" class="btn btn-primary" onClick="goBack()"/>
		<s:submit value="Proceed" class="btn btn-primary" action="showAddress"/>
	</s:form>
</body>
</html>