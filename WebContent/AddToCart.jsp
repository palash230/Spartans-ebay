<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<jsp:include page="userLoginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.row{
  margin-top: 30px;
  margin-bottom: 30px;
          padding:20px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>
 <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
function goBack() {
    window.history.back();
}

function check(j)
{
	var t = j;
	var name = $("#q"+t).val();
	var price = $("#cost"+j).text();
	alert("updated!!!");
$.ajax({
    type : "POST",
    url : "quantity",
    data : {
 	   quantity: name,
 	   itemId : $("#itd"+j).text(),
    },
    dataType: 'jsonp',
    success : function(result) {
        },
    error: function(e){
 	   alert(e);
    }
});
}
	
</script>
</head>
<body>
	<div class="container text-center">
	
			<s:action name="test" executeResult="true" />
	</div>
<div class="panel panel-default">
	<div class="panel-heading"> <strong class="">Items in your Cart!!!!</strong>
	 <div align="right">
	 		<b>Total cost =  </b><s:property value="total_cost"/> <br>
	 
	          </div>
	</div>
</div>
<br>
	<div class="container">
	<%int i=1; %>
		<s:iterator value="itemList" status="rowStatus">
		<% int index = i;
			i++;
		%>
		<div class="row" style="background-color:white; border: 1px solid #ccc;">     
        	<div class="col-sm-4">
	  				 <s:url id="cart" action="remove" var="myurl">
	<s:param name="itemId"><s:property value="itemId"/></s:param>
</s:url>
  				
	          
	  			<img src="data:image/jpg;base64,<s:property value="image64encode" />"  style="height:150px;width:300px" class="img-thumbnail" width="100" alt="Image" align="middle">
	  			</div>
	  			<div class="col-sm-4">
	  				<span id="cost<%=index%>" style="display:none;"><s:property value="cost"/></span>
	  			
					<b>Item id </b><span id="itd<%=index%>" style="display:none;"><s:property value="itemId"/></span> <br>
										<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
					<b> Quantity </b><s:textfield id="q%{#rowStatus.count}"  name="quantity" size="2"/><br>
<a href="" id="update<%=index%>" class="" onclick="check(<%=index%>);">Update</a>				
	         </div>
	          <div class="col-sm-4" align="right">
	         	    <a href="${myurl}">remove</a>
	         	    <br>
	         	    <b>Cost </b><s:property value="cost"/> <br>
	         	    
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