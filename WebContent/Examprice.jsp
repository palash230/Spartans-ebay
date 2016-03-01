<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@page import="java.sql.*"%>  
<%-- <jsp:include page="loginCheck.jsp" /> --%>
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
				<h3>Exam-01 OOAD Name: Palash Vijayvergiya RollNo. MT2015069</h3>

			</div>
			<hr>
			<h4>Price</h4>
			<div class="well">
			<s:form action="addPrice" align="center" method="post"  enctype="multipart/form-data" style="text-align:right">
			<table>
			<tr>
			<td>From: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield name="FromId" disable="true" placeholder="From"/>
			</div>
			</td>
			</tr>
			<tr>
			<td>To: </td>
			<td>
			<div class="col-sm-10">
			<s:textfield name="ToId" placeholder="To"/>
			</div>
			
			</td>
			</tr>
			</table>
			<s:submit value="submit" action="addPrice" class="btn btn-primary"></s:submit>
			</s:form>
			</div>
		</div>

	</div>

</body>
</html>