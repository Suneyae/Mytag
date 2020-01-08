<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp声明</title>
</head>
参见<a href="http://www.imooc.com/article/10439" target="_blank">imooc慕课网</a><br>
<%--我是页面看不到注释 --%>
<!-- jsp声明，我是看得到的注释 -->
<%!
	private int doAdd(int a,int b){
		return a+b;
	}
%>
<!-- jsp声明，我是看得到的注释 -->
<%
	out.println("1 我是通过内置对象out进行输出的");
	String[] sessions = session.getValueNames();
	out.print("2 内置对象session的长度"+sessions.length+"\n");
	
	String sessionStr = pageContext.SESSION;
	out.print("3 pageContext.SESSION:"+sessionStr+"\n");
	
%>


<%
	//获取从jspparam.jsp页面中传过来的值
	String value = request.getParameter("theKey");
	out.println("jspparam传过来的值:"+value);
%>
<body>
	<br>
	234+2342 = <%=doAdd(234, 2342) %>
	<br>
	
	<form name="regForm" action="request.jsp" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>
				爱好：
			</td>
			<td>
				<input type="checkbox" name="favorite" value="read">读书
				<input type="checkbox" name="favorite" value="music">音乐
				<input type="checkbox" name="favorite" value="movie">电影
				<input type="checkbox" name="favorite" value="internet">上网
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
<a href="request.jsp?username=李四">测试URL传参数</a>
	
</body>
</html>