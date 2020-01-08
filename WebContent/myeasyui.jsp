<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.wyl.suneyaee" prefix="Wyl"%>
<!-- 引入需要的jquery，easyui等，全都放在head.jsp里 -->
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我是标题</title>

</head>
<body>
<a id="btn" href="#" class="easyui-linkbutton"
	data-options="iconCls:'icon-search'">我的</a>
<a id="btn2" href="#" class="easyui-linkbutton"
	data-options="iconCls:'icon-edit'">按钮2</a>
<br />
静态导航条：
<br />
<ul class="easyui-tree">
	<li><span>公共业务</span>
	<ul>
		<li>系统管理</li>
	</ul>
	</li>
	<li><span>知识库</span>
	<ul>
		<li>知识库录入及维护</li>
		<li>知识库查询</li>
	</ul>
	</li>
	<li><span>基金征集管理</span>
	<ul>
		<li><span>基金征集管理</span>
			<ul>
				<li>单位计划批量生成</li>
				<li>月社会保险费申报表打印</li>
			</ul>
		</li>
		<li><span>征地农转非数据清理</span>
			<ul>
				<li>征地农转非数据清理统计汇总</li>
				<li>征集农转非数据清理结果查询</li>
				<li>征地农转非数据清理报盘</li>
			</ul>
		</li>
	</ul>
	</li>
</ul>
<!-- 动态导航条 -->
动态导航条:
<br/>
<ul id="dynamicTree"></ul>
</body>
<script type="text/javascript">
	$(function() {
		$('#btn').linkbutton({
			//toggle:true,
			//selected:true,
			iconAlign : 'right',
			group : 'sex'
		});
		$('#btn2').linkbutton({
			//toggle:true,
			//selected:true,
			group : 'sex',
			iconAlign : 'top'
		});
		console.log('控制台打印输出：');
		console.log($('#btn').linkbutton('options'));
		$('#dynamicTree').tree({
			url:'mytree3.json'
		});
		console.log($('#dynamicTree').tree('options'));
	})
</script>
</html>