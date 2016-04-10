<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <jsp:include page="userLoginCheck.jsp" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Track My Order</title>
<style type="text/css">
<link rel="stylesheet" href="style.css" />

</style>
<script>
function goBack() {
    window.history.back();

}

window.onload = function()
{
	//Disable fields
	//document.frmMain.field1.disabled = true;
	//document.frmMain.field2.disabled = true;
	//document.frmMain.field3.disabled = true;
	
}
</script>

</head>
<body>
<div class="container text-center">
	<s:action name="test" executeResult="true" />
		<ul class="breadcrumb">
			<li>Home</li>
	  		<li>Track My Order</li>
		</ul>
		<div class="jumbotron">
		<div class="col-sm-4" >Item title</div>
		<div class="col-sm-1" >Total cost</div>
		<div class="col-sm-2" >Transaction Date</div>
		<div class="col-sm-1" >Ship Before</div>
		<div class="col-sm-1" >Deliver Before</div>
		<div class="col-sm-1" >PaisaPay Id</div>
		<div class="col-sm-1" >Order Status</div>
		<div class="col-sm-1" >Seller Rating</div>
		
		</div>
		<s:iterator value="orderList" status="rowStatus">
		<s:url action="displayItemById.action" var="urlTag" >
		<s:param name="itemId"><s:property value="itemId"/></s:param>
		</s:url>
		<div class="row">
			
		<div class="col-sm-4">
				<div class="col-sm-4 text-left"><a href="${urlTag}"><img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:80px;width:80px" class="img-thumbnail" width="120" alt="Image"></a></div>
				
				<div class="col-sm-8 "><a href="${urlTag}"><s:property value="itemDesc"/></a><br><br> (Seller Id : <s:property value="sellerId"/>)
				<br>Address <s:property value="address"/></div></div>
		<div class="col-sm-1" ><s:property value="price"/><br> Quantity : <s:textfield value="%{quantity}" size="2" disabled="true" /></div>
		<div class="col-sm-2" ><s:property value="orderDate"/></div>
		<div class="col-sm-1" >Ship Before</div>
		<div class="col-sm-1" >Deliver Before</div>
		<div class="col-sm-1" ><s:property value="orderId"/></div>
		<div class="col-sm-1" ><s:property value="status"/></div>
		
		<div class="col-sm-1">
		<link rel="stylesheet" href="style.css" />
				<s:if test ="%{sellerrating!=0}">
				Rated <s:property value="sellerrating"/>
				</s:if>
				<s:else>
		
		<form id="ratingsForm" action="rating">
		
		
		
		<div class="stars">
		<input type="radio" name="rating" value="1" class="star-1" id="star-1" >
		
		</input>
		<label class="star-1" for="star-1">1</label>
		<input type="radio" name="rating" value="2" class="star-2" id="star-2" />
		<label class="star-2" for="star-2">2</label>
		<input type="radio" name="rating" value="3" class="star-3" id="star-3" />
		<label class="star-3" for="star-3">3</label>
		<input type="radio" name="rating" value="4" class="star-4" id="star-4" />
		<label class="star-4" for="star-4">4</label>
		<input type="radio" name="rating" value="5" class="star-5" id="star-5" />
		<label class="star-5" for="star-5">5</label>
		<span></span>
	</div>
	
		
		<s:hidden name="sellerId" value="%{sellerId}"/>
		<s:submit name="submit"/>
		</div>
		</form>
</s:else>
		</div>
		</div>
		<hr/>
		<br>
		
		</s:iterator>
		<input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
		<s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit>
	</div>
		
</body>
</html>