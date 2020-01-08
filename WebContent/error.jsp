<%@page import="com.util.UtilStruts"%>
<%@page import="java.util.*"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.wyl.suneyaee" prefix="Wyl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Map<String, Object> session_ = UtilStruts.getSession();
	//超时的提示
	String timeout_msg = (String) session_.get("timeout_msg");
	out.print("timeout_msg:"+timeout_msg);
	if (timeout_msg != null && !"您长时间未操作，已经超时...".equals(timeout_msg)) {
		timeout_msg = "没有超时，可以正常登录。^^^";
	} else if (timeout_msg == null) {
		timeout_msg = "您还未登录^^^";
	}
%>
<br/>
<br/>
--------分隔符---------
<br/>
<br/>
<Wyl:getIP />
错误信息： ${error_msg }
<br />
<%=request.getAttribute("error_msg")%>
<br />
是否超时：
<%=timeout_msg%>
<br />
<a href="login.jsp">登陆页面</a>

</body>
</html>