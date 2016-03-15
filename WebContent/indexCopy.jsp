<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>   
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import=" org.struts.utils.*" %>
<%@ page import=" org.apache.tomcat.util.codec.binary.Base64"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay</title>
<style type="text/css">

.errorMessage {
  font-weight: light;
  color: red;
}
 
#owl-demo .owl-item {
  margin: 3px;
}

#owl-demo .owl-item img {
  display: block;
  width: 100%;
  height: 285px;
}

</style>

</head>
<body>
<div class="container text-center">
	<s:action name="test" executeResult="true" />
	<br><br>
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
	<br><br>
			  		
		<div class="row">
			<div class="col-sm-12">
			<div class="jumbotron text-center">
			<h2>Advertisement</h2>
			</div>
		  		
		  		<br><br>
	    		<!-- Indicators -->
	    		<!-- Wrapper for slides -->
	    		<!-- Wrapper for slides -->
			    <div id="owl-demo">
		<%
		  Class.forName("com.mysql.jdbc.Driver");
		  ConnectionPool.getConnection();
		  Statement stmt=ConnectionPool.con.createStatement();
		  ResultSet rs=stmt.executeQuery("select item_name,itemId,image,cost from item where advertisementItem='Y'");
		    while(rs.next() )
		    {
		    	String name = rs.getString("item_name");
		  		String itemId = rs.getString("itemId");
		  		Blob pic = rs.getBlob("image");
		  		int cost=rs.getInt("cost");
		  		if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				byte[] blobAsBytes=pic.getBytes(1, blobLength);
				String image64encode=new Base64().encodeToString(blobAsBytes);
	%>
	
	      			<div class="item">
	      			 <s:url id="cart" action="cart" var="myurl">
	<s:param name="user"> <%=itemId %></s:param>
</s:url>

	      				<a href="${myurl}" class="btn-btn-primary"> <img src="data:image/jpg;base64,<%=image64encode%>" height="300px" width="250px"  class="img-responsive" style="width:100%" alt="Image"></a>
		  			 	<div class="">
		  			 	<p><b>Item Id  :</b>  <%=itemId %></p>
	            		<p><b>Item Name:</b>  <%=name %> </p>
	            		<p><b>Cost      </b> <%=cost %> </p>
	            		<p><b><a href="construction.jsp" class="btn-btn-primary">BUY</a></b></p>       		
</div>
	        	</div>  
	      <%   } 	
	 	}
	  %>
		  	</div>
	  	</div>
	</div>
<br>
</div>
<div class="container">
 <a href="acknowledge.jsp"><strong>Acknowledge</strong></a><br>
 <a href="workaround.jsp"><strong>Work Around</strong></a>
 </div>
</body>
</html>