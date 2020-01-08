<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	//获取从jspparam.jsp页面中传过来的值
	String value = request.getParameter("theKey");
	out.println("jspparam传过来的值:"+value);
%>
<body>

<a href="http://www.panda.tv/413021" target="_blank"><img alt="美女图片1" src="myimg/luna.png" style="height: 40%;width: 40%;" align="center"></a>
<br>

<a href="sun.mp4">Play a video file</a>
<br>
<a href="http://www.runoob.com/jsp/jsp-syntax.html" target="_blank" ><img alt="美女图片2" src="myimg/ydd.jpg" style="height: 40%;width: 40%;" align="center"></a>
<a href="http://www.baidu.com">跳转到百度</a>
<br/>
<a href="haha2.jsp">跳转到自定义标签</a>
</body>
</html>