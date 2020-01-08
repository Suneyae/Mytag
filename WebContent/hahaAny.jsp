<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.wyl.suneyaee" prefix="Wyl"%>
<!-- 引入jquery等 -->
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
<!--
	$(function() {
		$('input').keydown(function(e) {
			var curKey = e.which;
			//46 是 Delete键
			if (curKey == 46) {
				clear(this);
				$(this).focus();
			}
		});

		$('#idUserName').keydown(function(event) {
			var curKey = event.which;
			//13 是回车键
			if (curKey == 13) {
				console.log('你按的是：回车' + '键');
			}

		});
		/**
			清除value值，主要是针对于input
		 */
		function clear(obj) {
			$(obj).attr('value', null);
		}
	})
</script>

<title>Insert title here</title>
</head>
<body>
<Wyl:getIP />

<form action="doAjax"><input value="aaa" type="text"> <br>
<input value="doAJax" type="submit"></form>

<br>
<form action="wdAjax"><input value="MyAjax.myAjax()..."
	type="text"> <br>
<input value="wdAjax" type="submit"></form>

<br>
用户名
<form action="toLogin"><input type="text" name="user.userName">
<br>
<%
	request.getSession().setAttribute("hahaAnyKey", "我是hahaAnyKey.jsp页面传入session的值");
%>
<input type="text" name="user.passWord"> <input type="submit">
</form>


<br>
用户名2 ，模型驱动，而且这个表单对应的LoginAction2.java中封装了dto,而且可以使用Delete键清空输入框
<form action="toLogin2"><input type="text" name="userName"
	id="idUserName"> <br>
<input type="text" name="passWord"> <input type="submit">
</form>

-----------
<span xmlns="http://www.w3.org/1999/xhtml"
	class="button collapse-button"></span>

</body>
</html>