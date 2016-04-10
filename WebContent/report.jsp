<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
   
         <s:action name="test" executeResult="true" />
         
<table>
	<thead>
		<th>Image</th>
		<th>Item Id</th>
		<th>Item Name</th>
		<th>Item Cost</th>
	</thead>
			
			<tbody>
				<s:iterator value="itemList" status="rowStatus">
					<div class="item">
					<tr>
					
	      				<td><img src="data:image/jpg;base64,<s:property value="image64encode" />" height="250px" width="250px"  class="img-responsive" alt="Image"></td>	      				
		  			 	<td> <s:property value="itemId"/></td>
	            		<td> <s:property value="itemName"/> </td>
	            		<td> <s:property value="cost"/>
	            	    </td>
					</tr>
	        			
	    			</div>
				</s:iterator>
				</tbody>
</table>
</div>
</body>
</html>