<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  		$(document).ready(function() {
    	$("#owl-demo").owlCarousel({
           	autoPlay: 3000,
   	       	loop:true,
      	   	items : 3,
      	   	itemsDesktop : [1199,3],
        	itemsDesktopMedium : [979,3],
        	navigation :true,
        	stopOnHover:true
    	});   
  });
</script>
</head>
<body>
			<div class="jumbotron text-center">
			<h2>Advertisement</h2>
			</div>
			<div id="owl-demo">
				<s:iterator value="itemList" status="rowStatus">
					<div class="item">
	      				<img src="data:image/jpg;base64,<s:property value="image64encode" />" height="300px" width="250px"  class="img-responsive" style="width:100%" alt="Image"></a>
		  			 	<div class="">
		  			 	<p><b>Item Id  :</b>  <s:property value="itemId"/></p>
	            		<p><b>Item Name:</b> <s:property value="itemName"/> </p>
	            		<p><b>Cost      </b> <s:property value="cost"/></p>
	            	    <a href="construction.jsp" class="btn-btn-primary">BUY</a>
	        			</div>
	    			</div>
				</s:iterator>
			</div>
	
</body>
</html>