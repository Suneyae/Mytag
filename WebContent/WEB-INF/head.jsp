<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>${param.title}</title>

<%	
	//获取路径，这个path实际上就是"/"加上项目名，这个实例为： /Mytag
	String path = request.getContextPath();
	pageContext.setAttribute("ctx",path);
	// 在页面上写路径
	out.print("path:"+path);
%>

<script type="text/javascript">
	
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/wylUtil.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/upload/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/fckeditor/fckeditor.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/easyui_theme/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/easyui_theme/themes/wylown.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/easyui_theme/themes/icon.css">
<!-- 下面的${ctx}这种形式是el表达式，详见：http://zhidao.baidu.com/link?url=3Y1mcXIw6wGsStFzAJKpMKwjSClGMcYlNbOsjgAeyt667DhyVEGK_p7ybQ9Vqo7n3_UPn-ll0N2ihWP8WuvqPa -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/easyui_theme/locale/easyui-lang-zh_CN.js">
</head>