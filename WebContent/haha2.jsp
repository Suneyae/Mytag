<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/cur" prefix="WYL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<WYL:mm btnName="heihie" message="haoba" wClick="true"></WYL:mm>
<a href="/Mytag/uploadResult.jsp">转到uploadResult.jsp页面</a>
<a href="/Mytag/welcome.jsp">本机的ip地址</a>
</body>
<script type="text/javascript">
	function WylClick(obj) {
		alert('this:' + obj.value);
	}
</script>
</html>