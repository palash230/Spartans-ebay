<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>

<script>
function goBack(){
	window.history.back();
}

</script>

</head>
<body>

<div class="container ">
 <s:action name="test" executeResult="true" />

   <br><br><br><br>
 
 <h3><s:property value="itemId"/> >    
  <s:if test="%{dealsflag!=null}"> 
     <s:property value="itemId"/> ><br>
  </s:if>
  </h3>
   <br>
 
 
 
 </div>

<br><br><br><br><br>
<div class ="container">
 	 <div class="row">
 	 		<div class ="well">
 	 			<p>m for category</p>
 	 				
 	 				<s:iterator value="itemList2" status="rowStatus">
 	 			
    		 				<%--  <a href="itemBySubCat">
    		 				  <s:property value="subCatName"/></a>
    	 --%>
					<s:url action ="itemBySubCatAction" var="urlTag"> 
						<s:param name="itemSubCatId"><s:property value="key"/></s:param>
						<s:param name="subCatName"><s:property value="value"/></s:param>
						</s:url>
						<a href ="itemBySubCatAction"><s:property value="subCatName"/></a>
    							 
  					</s:iterator>	
 	 		</div>
	
</div>
</div>

<div class="container text-center"> 

 <s:iterator value="itemList" status="rowStatus">
 			<b>in deals.jsp iterator</b>
 		
  <s:if test="%{dealflag==true}">
	   
 		<b>in deals.jsp</b>
 	 
 	 
 	 <div class="row">
 
 	 
 	  
          <div class="col-sm-5">
	        	<div class="well">
	        
	         
					<b>Item Id :</b>			
					<s:property value="itemId"/>
					<br> 
					<b>Item Name </b><s:property value="itemName"/> <br>
					<b>Item Description </b><s:property value="itemDesc"/><br>
					<b>Cost </b><s:property value="cost"/> <br>
					<b>Discount </b><s:property value="discount"/> <br>
					<b>Deal flag </b><s:property value="dealflag"/> <br>
					<b> Seller Id </b><s:property value="seller_id"/><br>
					
					
	    		</div>
			</div>
        	<div class="col-sm-3">
	          <div class="well">
	          
	           		<img src="data:image/jpg;base64,<s:property value="image64encode" />" height="300px" width="250px"  class="img-responsive" style="width:100%" alt="Image">
	  			 <a href="construction.jsp"><button type="button" class="btn btn-default btn-sm">
	                <span class="glyphicon"></span>Buy Now
	             </button></a>
	             
	              </div>
	          
	        </div>
	        </div>
      
         </s:if>
	   </s:iterator>
				
	<br>
	
</div>


<div class="container ">

<s:submit value="Previous" class="btn-btn-primary" onclick="goBack()"/>
<a href="indexCopy.jsp"><button class="btn btn-default btn-sm"> HOME </button></a>
</div>

</body>

</html>
