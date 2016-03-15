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
<div class="well">
<s:form action="selectedAddress">
<s:radio list="addressList" name="yourAddress"></s:radio>
<br>

<s:submit value="deliver here"></s:submit>
</s:form>
<br>
<a href="addAddress.jsp"><s:submit value="Add new delivery address" class="btn btn-primary"></s:submit>
</a>


</div>
</body>
</html>