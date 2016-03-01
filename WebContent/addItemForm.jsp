<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@page import="java.sql.*"%>  
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Item | ebay </title>
<script>
function goBack() {
    window.history.back();
}
</script>
<style type="text/css">
.errorMessage {
  font-weight: light;
  color: red;
}
body {
    background-color: GhostWhite ;
}
h3{
    
    font-weight:bold;
    
    color:grey	;

    }
    .sell{
    color:GhostWhite;
    }
      h4{
    font-weight:bold;
    color:grey;
    }
    h2{
    font-weight:bold;
    color:GhostWhite;
    }   
    .banner{
    width:100%;
    max-height:300px;
        }
        .jumbotron{
        background-color: DodgerBlue ;
        }
</style>

</head>

<body>
<div class="container">
<s:action name="test" executeResult="true" />
<br><br><br><br>
	
	 	<div class="col-sm-10">
	 		<div class="jumbotron">
				<h3>Add your item here</h3>

			</div>
			<hr>
			
			<div class="well">
			<s:form action="addItem" align="center" method="post"  enctype="multipart/form-data" style="text-align:right">
			<table>
			<tr>
			<td>Item Id: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield name="itemId" disable="true" placeholder="Enter Item Id"/>
			</div>
			<s:fielderror>
    			<s:param>itemId</s:param>
    		</s:fielderror>
			</td>
			</tr>
			<tr>
			<td>Item Name: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield name="itemName" placeholder="Enter Item Name"/>
			</div>
			<s:fielderror>
    			<s:param>itemName</s:param>
    		</s:fielderror>
			</td>
			</tr>
			<tr>
			<td>Item Description: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield name="itemDesc" label="Item Description " placeholder="Enter Item Description"/>
			</div>
			<s:fielderror>
    			<s:param>itemDesc</s:param>
    		</s:fielderror>
			</td>
			</tr>
			<tr>
			<td>Picture: </td>
			<td><s:file label ="pic" name="pic"/></td>
			</tr>
			<tr>
			<td>Seller Id: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield label ="Seller Id" name="sellerId" placeholder="Enter Seller Id"/>
			</div>
			<s:fielderror>
    			<s:param>sellerId</s:param>
    		</s:fielderror>
			</td>
			</tr>
			<tr>
			<td>Price: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield label ="Price" name="price" placeholder="Enter price"/>
			</div>
			<s:fielderror>
    			<s:param>price</s:param>
    		</s:fielderror>
			</td>
			</tr>
			<tr>
			<td>Advertising Item : </td>
			<td>
			<div class="col-sm-10">
			<s:select name="advCheck"  label="Advertisement Item?" 
					headerKey="0" headerValue="Select Advertisement"
					list="#{'Y':'Yes', 'N':'No'}" />
			</div>
			</td>
			</tr>
			<tr>
			<td> Category</td>
			<td>
			<div class="col-sm-10">
			   <s:doubleselect value="defaultCat" 
			   headerKey="0" headerValue="Select..." 
			   name="item"  list="itemIdList1" listValue="itemId" 
			   doubleName="test" doubleList="itemName" >
			   </s:doubleselect>
			 </div>
				<s:fielderror>
    			<s:param>item</s:param>
    		</s:fielderror>
		
			</td>
			</tr>
			<tr>
					<td>Additional Field 1: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield name="addField1" placeholder="Additional Field 1"/>
			</div>
			</td>
			</tr>
			<tr>
			<td>Additional Field 2: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield name="addField2" placeholder="Additional Field 2"/>
			</div>
			</td>
			</tr>
			</table>
			<div align="center">
			<br>
			<input type="button" value="Previous" class="btn btn-primary" onclick="goBack()"/>
			<s:submit value="submit" action="addItem" class="btn btn-primary"></s:submit>
			<s:submit value="Home" action="homePageAction" class="btn btn-primary"></s:submit></div>
			</s:form>
			</div>
		</div>

	</div>

</body>
</html>