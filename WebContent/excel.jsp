<%@page import="java.io.FileInputStream"%>
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
	/* com.wyl.excel.Excel e = new com.wyl.excel.Excel();
	FileInputStream fis = e.exportExcelToWeb();
	out.clear();
	out = pageContext.pushBody();
	javax.servlet.ServletOutputStream o = response.getOutputStream();
	int b = 0;
	byte[] buffer = new byte[1024];
	while((b=fis.read(buffer))!=-1){
		//out.write(buffer, 0, buffer.length);
		o.write(buffer, 0, buffer.length);
	} */
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
<br />
<a href="login.jsp">登陆页面</a>
</body>
</html>