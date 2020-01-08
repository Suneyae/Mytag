<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.wyl.suneyaee" prefix="Wyl"%>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<Wyl:getIP />
<br>
账号：wyl,密码：123
<br>
<br>
<form action="toLogin">
用户名:<input type="text" name="user.userName">
<br>
密  码:<input type="password" name="user.passWord"> 
<br>
<br>
<input id="submit" type="submit">
</form>
</body>
<script type="text/javascript">
	$(function() {
		x = 5;
		y = 15;
		$('#submit,input').hover(function(e) {

			otitle = this.title;
			this.title = "账号：wyl,密码：123";
			var ndiv = "<div id='leo'>" + otitle + "</div>";
			$("body").append(ndiv);
			$("#leo").css({
				"top" : (e.pageY + y) + "px",
				"left" : (e.pageX + x) + "px"
			}).show(2000);
			$(this).mousemove(function(e) {
				$("#leo").css({
					"top" : (e.pageY + y) + "px",
					"left" : (e.pageX + x) + "px"
				}).show(1000);
			});
		}, function() {
			this.title = otitle;
			$("#leo").remove();
		});
	})
</script>
<style type="text/css">
#leo {
	position: absolute;
	border: 1px solid grey;
	opacity: 0.8;
	background: grey;
}
</style>
</html>