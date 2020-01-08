<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<frameset name="topFrame" rwos="49,*" cols="*" border="1" frameBorder="NO" frameSpacing="0">
	<!-- 这是顶部的 2016年08月26日 首页 公告查阅 常用菜单 修改密码 重新登录 退出系统 帮助 
	等 -->
	<frame name="banner" src="<%=request.getContextPath()%>/framework/banner.jsp"></frame>
	
	<frameset name="MenuFrameset" rows="*" cols="200,*" border="0" frameBorder="yes" frameSpacing="0">
		<FRAME src="/web/jsp/framework/left.jsp" name="TreeMenu" frameBorder="1" scrolling="auto">
		<frameset name="MenuFrameset" rows="*" cols="200,*" border="0" frameBorder="yes" frameSpacing="0">
			<frame name="banner" src="<%=request.getContextPath()%>/framework/banner.jsp"></frame>
		</frameset>
	</frameset>
</frameset>
</html>