<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
this is login success page,welcome
<br/>
userName:
<%=request.getAttribute("userName")%>
--转码后的数据
<%=URLDecoder.decode((String)request.getAttribute("userName")) %>
<br/>
<br>
passWord:
<%=request.getAttribute("passWord")%>
<br/>
通过$\{\}的形式来获取passWord:
<!-- ${passWord}就相当于 上面的  request.getAttribute("passWord") -->
${passWord}
<br/>
<s:debug></s:debug>
<br/>
ONGL表达式的形式获取userName
<!-- [0].userName表示从valuestack的栈顶开始寻找属性名为userName的值， -->
<!-- 
	
	* ObjectStack 里的栈顶对象可以用 [0] 来引用, 它下面的那个对象可以用 [1] 引用. 若希望返回栈顶对象的 message 属性值:  [0].message 或 [0][“message”] 或 [0][‘message’]
	* 若在指定的对象里没有找到指定的属性, 则到指定对象的下一个对象里继续搜索. 即 [n] 的含义是从第 n 个开始搜索, 而不是只搜索第 n 个对象
	* 若从栈顶对象开始搜索, 则可以省略下标部分

	
 -->
<s:property value="[0].userName" />
<br/>
或者写作：
<s:property value="userName" />
<br/>
ONGL获取passWord:
<s:property value="[0].passWord" />
<br>
回到
<a href="<%=request.getContextPath()%>/hahaAny.jsp">hahaAny.jsp</a>
<br/>
<a href="findBeauty">看美女</a>

</body>
</html>
