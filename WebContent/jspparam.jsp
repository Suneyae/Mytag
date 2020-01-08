<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:fielderror></s:fielderror>
----------------------------------------------
<br>
your id is : <%=request.getRemoteHost() %>
<br>
jsp声明：
<%! int a = 23; %>
<%! int day = new Random().nextInt(7); %> 
<jsp:expression>
(new java.util.Date()).toLocaleString()
</jsp:expression>
<br>
<strong>jsp注释格式：</strong>
<%--you cannot find me here --%>
<%="<%--我是注释部分，网页上看不到我这部分" %><%="--%" %><%=">" %>
<%-- jsp include指令 --%>
<br>
<jsp:include page="/beauty.jsp">
	<jsp:param value="theKey" name="theValue我是"/>
</jsp:include>

<br>
<a href="http://www.panda.tv/413021" target="_blank">Luna月亮的房间</a>
控制流语句：详见：<a href="http://www.runoob.com/jsp/jsp-syntax.html" target="_blank">点我跳转到jsp教程</a>
<br>
<h3>IF...ELSE 实例</h3>
day:<%=day %>
<%
	if(day==6||day==7){
%>
	<p>今天是周末</p>
<%
	}else{
%>
	<p>今天不是周末</p> 
<%} %>
<br>
<h1><strong>JSP内置对象：</strong></h1>
<br>
<a href="http://www.runoob.com/jsp/jsp-syntax.html" target="_blank" ><img alt="jsp内置对象" src="myimg/jsp.png"></a>
<br>
<br>
<h3>For 循环实例</h3>
<%! int fontSize; %> 
<%for ( fontSize = 1; fontSize <=7 ; fontSize++){ %>
   <font color="green" size="<%= fontSize %>">
    你大爷
   </font><br />
<%}%>
</body>
</html>