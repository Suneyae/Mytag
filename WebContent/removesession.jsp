<%@page import="com.log.entity.User6"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.hover {
	background: #cdf4d7;
}

.trhover {
	background: #e6e6e6;
}
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tishi {
	color: red;
}

INPUT.readonly {
	background-color: #F0F0F0;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
这是session绑定的监听器的页面，也就是测试实现HttpSessionBindingListener接口的实体类,对应User6.java
	<input type="text" onblur="checkUser(this)" id="userName2" />
		<%
			session.invalidate();
		%>
	<div id="theDiv"></div>
</body>
</html>