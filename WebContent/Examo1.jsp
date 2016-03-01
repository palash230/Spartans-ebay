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
<script>
function goBack() {
    window.history.back();
}
</script>
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
		<%-- <s:action name="myprice" executeResult="true" />	 --%>  		
		<div class="row">
			<div class="col-sm-12">
			<div class="jumbotron text-center">
			<h2>Exam-01 OOAD Name: Palash Vijayvergiya RollNo. MT2015069</h2>
			
			</div>
			<h2>Result items with Price Range</h2>
			From:<s:property value="FromId"/> To:<s:property value="ToId"/>
		  		
		  		<br><br>
	    		<!-- Indicators -->
	    		<!-- Wrapper for slides -->
	    		<!-- Wrapper for slides -->
			    <div id="owl-demo">
			    
		<%
		  Class.forName("com.mysql.jdbc.Driver");
		  ConnectionPool.getConnection();
		 Statement stmt=ConnectionPool.con.createStatement();
		  ResultSet rs1=stmt.executeQuery("select price,priceto from pricefinal where idpricefinal=(select max(idpricefinal) from pricefinal)");
		 String from=rs1.getString("price");
		String to=rs1.getString("priceto");%>
		  <%-- <p><b>From  :</b>  <%=from %></p>
		  <p><b>To :</b>  <%=to %></p>  --%>
		  <% 
		  Statement stmt1=ConnectionPool.con.createStatement();
		  ResultSet rs=stmt1.executeQuery("select seller_id,itemId,image,advertisementItem from item069");
		    while(rs.next() )
		    {
		    	String seller_id = rs.getString("seller_id");
		  		String itemId = rs.getString("itemId");
		  		Blob pic = rs.getBlob("image");
		  		String advertisementItem=rs.getString("advertisementItem");
		  		if(pic!=null)
				{
				int blobLength = (int) pic.length();	
				byte[] blobAsBytes=pic.getBytes(1, blobLength);
				String image64encode=new Base64().encodeToString(blobAsBytes);
	
	%>
	      			<div class="item">
	      				<a href="construction.jsp" class="btn-btn-primary"> <img src="data:image/jpg;base64,<%=image64encode%>" height="300px" width="250px"  class="img-responsive" style="width:100%" alt="Image"></a>
		  			 	<div class="">
		  			 	<p><b>Id  :</b>  <%=itemId %></p>
	            		<p><b>SellerId:</b>  <%=seller_id %> </p>
	            		<p><b>Advertisement Item      </b> <%=advertisementItem %> </p>
	            		
	        		</div>
	        	</div>  
	      <%   } 	
	 	}
	  %>
		  	</div>
	  	</div>
	  	<s:submit value="Previous" class="btn btn-primary" onCLick="goBack()"/>
						<a href="indexCopy.jsp"><s:submit value="Home" action="homePageAction" name="home" class="btn btn-primary" /></a>
	</div>
<br>
</div>

</body>
</html>