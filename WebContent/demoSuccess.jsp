<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script >


function enable_text(status)
{
	status=!status;	
	document.f1.other_text.disabled = status;
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Its successful
<s:form name="f1" method="post">
<s:checkbox name="others"  onclick="enable_text(this.checked);" >Personalize your message</s:checkbox><br>
<s:textfield name="other_text"></s:textfield>
</s:form>
</body>
</html>