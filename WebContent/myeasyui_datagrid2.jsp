<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.wyl.suneyaee" prefix="Wyl"%>
<!-- 引入需要的jquery，easyui等，全都放在head.jsp里 -->
<%@ include file="/WEB-INF/head.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/myeasyui_datagrid2.js"></script>

<script type="text/javascript">

	/**
	 * Purpose: 判断输入是否含有为中文 Inputs: String Returns: True, False
	 */
	function hasChinese(str) {
		 var k = escape(str);
		if (escape(str).indexOf("%u") != -1) {
			return true;
		}
		return false;
	}
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我是标题</title>
<style type="text/css">
	.sB-comment a {
    height: 17px;
    padding-top: 34px;
    padding-bottom: 3px;
    background-position: 0 -59px;
}
</style>
</head>
<body>
	<a id="btn" href="#" class="easyui-linkbutton"
		data-options="iconCls:'icon-search'">我的</a>
	<a id="btn2" href="#" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit'">按钮2</a>
	<br /> 静态导航条：
	<br />
	<ul class="easyui-tree">
		<li><span>公共业务</span>
			<ul>
				<li>系统管理</li>
			</ul></li>
		<li><span>知识库</span>
			<ul>
				<li>知识库录入及维护</li>
				<li>知识库查询</li>
			</ul></li>
		<li><span>基金征集管理</span>
			<ul>
				<li><span>基金征集管理</span>
					<ul>
						<li>单位计划批量生成</li>
						<li>月社会保险费申报表打印</li>
					</ul></li>
				<li><span>征地农转非数据清理</span>
					<ul>
						<li>征地农转非数据清理统计汇总</li>
						<li>征集农转非数据清理结果查询</li>
						<li>征地农转非数据清理报盘</li>
					</ul></li>
			</ul></li>
	</ul>
	<br />
	<br />
	<br />
	
	<br />
	<br />
	<br />
	-----侧边栏 ，原文：http://www.cnblogs.com/liyunhua#top -----
	<div class="scrollBtn" id="scrollBtn">
    <ul class="clearfix">
        <li class="sB-home">
            <a href="http://www.cnblogs.com/liyunhua" class="ff-t" title="首页"></a>
        </li>
        <li class="sB-comment">
            <a href="#blog-comments-placeholder" onclick="$('#tbCommentBody').focus();" class="ff-t" title="添加评论"></a>
        </li>
        <li class="sB-share"><a onclick="if(cb_entryId !=undefined){AddToWz(cb_entryId)}" href="javascript:void(0);" title="收藏"></a></li>
        <li class="sB-goTop" id="goTop" style="display: list-item;">
            <a href="#top" title="回顶部"></a>
        </li>
    </ul>
</div>
	
	--------
	
	<script type="text/javascript">
		$(function(){
			if(hasChinese('卫永乐')){
				alert('包含中文字符');
			}else{
				alert('不包含中文字符');
			}
		})
	</script>
</html>