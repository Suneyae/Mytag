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
<style>


#scrolltop {
   /*  visibility: collapse; */
    position: fixed;
    bottom: 100px;
    display: block;
    margin: -30px 0 0;
    width: 26px;
    height: 50px;
    background: url(../../static/image/common/scrolltop.png) no-repeat 50% 0;
    line-height: 999px;
    overflow: hidden;
    cursor: pointer;
}
</style>
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
	<!-- 手工写table，必须要加上<thead>以及在<th></th>的<th>中加上data-options="field:'xxx'" -->
	手工写table，即通过class方式，必须要加上thead标签以及在th标签中加上data-options="field:'xxx'"
	<table border="1" class="easyui-datagrid" data-options="width:250">
		<thead>
			<tr>
				<th data-options="field:'user'">姓名</th>
				<th data-options="field:'account'">邮箱账号</th>
				<th data-options="field:'date'">注册时间</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td>姓名</td>
				<td>邮箱账号</td>
				<td>注册时间</td>
			</tr>
			<tr>
				<td>姓名2</td>
				<td>邮箱账号2</td>
				<td>注册时间2</td>
			</tr>
		</tbody>
	</table>
	<br />
	<br />
	<br />
	图片区域：
	<img alt="我是图片"  id="id_pic" src="http://img.lanrentuku.com/img/allimg/1212/5-121204193Q9.gif" title="dd">
	<!-- 
		<img alt="我是图片" width="50%" id="id_pic" src="http://s.dgtle.com/forum/201509/25/192432xwkyrwfyk5l5amcs.jpg" title="dd">
	 -->
	<br />
	<br />
	<br />
	<br />
	<br />
	<br /> 上传文件-------
	 <form action="myupload" method="post" enctype="multipart/form-data">
		<!--  用户名：<input name="userName" type="text"/><br/> -->
		 选择文件：<input name="baobiao" type="file" /><br/>
		<input name="提交" type="submit" /><br/>
	</form>
	
	
	《《《《《《《《《《我可以使用了哈《《《《《《《《
	<form action="upload2" method="post" enctype="multipart/form-data">
	文件：<input type="file" name="java1234"/><br/>
	<input type="submit" value="提交"/>
</form>
	
	《《《《《《《《《《


	----------------ajaxupload.js文件上传-------------------

	<form action=upload2 method="post" enctype="multipart/form-data">
	文件：<input type="file" name="java1234"/><br/>
	<input type="submit" value="提交"/>
	</form>
	<br />
	<br />
	
	---------fckeditor---------
	
	<script type="text/javascript">
		var objFck = new FCKeditor('content2');
		objFck.BasePath = "fckeditor/";
		objFck.Height = "300px";
		objFck.Width = "700px";
		objFck.Create();
		
	</script>
	
	
	---------fckeditor---------
	<br />
	<br />
		
	<br />
	<br />
	
	---------jquery多事件绑定---------
	
	<div id="myDiv">
		<input type="button" id="id_btn" value="按钮"><br/><br/>
		<input type="button" id="id_reset" value="重置"><br/><br/>
		用于装盛事件的所有属性：<input type="text" id="theText" value="" /><br/><br/>
	</div>
	
	---------jquery多事件绑定---------
	<br />
	<br />
	
	<br /> 通过js方式生成table
	<table id="id_table_js"></table>
	<br />
	<br />
	<br /> 通过js,struts2方式从数据库获取数据传入table
	<table id="id_table_js_struts2"></table>

	<br />
	<br>
	
	<span id="scrolltop" style="left: 1145px; visibility: visible;" onclick="window.scrollTo('0','0')">回顶部</span>
	
	<br /> 通过ajax获取json数据
	<input type="button" onClick="getData()" value="获取json数据" />
	<div id="id_target"></div>
</body>
<script type="text/javascript">
	function ajaxFileUpload() {
		$.ajaxFileUpload({
			url : 'myupload', //用于文件上传的服务器端请求地址
			secureuri : false, //是否需要安全协议，一般设置为false
			fileElementId : 'file1', //文件上传域的ID
			dataType : 'json', //返回值类型 一般设置为json
			success : function(data, status) //服务器成功响应处理函数
			{
				$("#img1").attr("src", data.imgurl);
				if (typeof (data.error) != 'undefined') {
					if (data.error != '') {
						alert(data.error);
					} else {
						alert(data.msg);
					}
				}
			},
			error : function(data, status, e)//服务器响应失败处理函数
			{
				alert(e);
			}
		})
		return false;
	}

	/**
		对应的请求 http://localhost:8081/Mytag/getUser2!getJsonData2?id=90
		映射到外网命令： lt -s sune -p 8081 
		对应的映射：http://sune.localtunnel.me/Mytag/myeasyui_datagrid.jsp
	 */
	function getData() {
		$.ajax({
			type : "POST",
			url : "getUser2!getJsonData2",
			dataType : "json",
			data : "id=90",
			//data: "name=John&location=Boston",
			success : function(msg) {
				alert("GetUserAction.getJsonData()获取到的数据: "
						+ JSON.stringify(msg));
				var colhead_ = msg['colhead'];
				var jsonStr = {};
				var jsonStr2 = {};
				var jsonStr3 = {};

				jsonStr['field'] = 'username';
				jsonStr['title'] = msg[0]['colhead'];

				jsonStr2['field'] = 'email';
				jsonStr2['title'] = msg[0]['idglt'];

				jsonStr3['field'] = 'datetime';
				jsonStr3['title'] = msg[0]['title'];

				/* jsonStr['email'] = msg[0]['colhead'];
				jsonStr['datetime'] = "2016-09-20"; */
				var rtncolomn = "[[" + JSON.stringify(jsonStr) + "]]";
				rtncolomn = JSON.parse(rtncolomn);
				alert(rtncolomn);
				/* var column = "["+JSON.stringify(msg)+"]";
				$('#id_table_js_struts2').datagrid({
					//columns:column
					columns:rtncolomn
				}); */

				var arr1 = new Array();
				var arr2 = new Array();
				arr2.push(jsonStr);
				arr2.push(jsonStr2);
				arr2.push(jsonStr3);
				arr1.push(arr2);
				//alert(rtncolomn);
				var column = "[" + JSON.stringify(msg) + "]";
				$('#id_table_js_struts2').datagrid({
					//columns:column
					//columns:rtncolomn
					columns : arr1
				});
			}
		});
	}

	$(function() {
		//图片回调
		$('#id_pic').html($('#id_pic').attr('alt')+'<br/>'+$('#id_pic').attr('title')).attr('src','http://s.dgtle.com/forum/201509/25/192432xwkyrwfyk5l5amcs.jpg');
		if($('#id_pic').get(0).readyState=='complete'){
			alert('加载完成!');
			$('#id_pic').attr('width','50%');
		}
		var obj = $('#id_pic').get(0);
		var imgLength = obj.length;
		var tmp_length = 0;
		if(imgLength){
			obj.on('load',function(){
				tmp_length++;
				if(tmp_length==imgLength){
					alert('加载完成!');
					$('#id_pic').attr('width','50%');
				}
			});
		}else{
			tmp_length++;
			if(tmp_length==imgLength){
				alert('加载完成!');
				$('#id_pic').attr('width','50%');
			}
		}
		/* if($('#id_pic').get(0).complete==true){
			alert('加载完成!');
			$('#id_pic').attr('width','50%');
		} */
		
		//取出事件的所有属性
		$('#id_btn').bind("click dbclick mouseout",{crdx:'我是传的值'},function(e){
			var url = e.currentTarget.baseURI;
			var glo_filedValue ;
			//遍历event事件对象的所有属性
			for(var field_ in e){
				
				glo_filedValue += '属性'+field_+":"+e[''+field_]+'\n';
				console.log(glo_filedValue);
			}
			//把取出来的属性全都放在<input type="text" id="theText" />中
			$('#theText').attr('value',glo_filedValue);
			
			alert('event.data.属性:'+e.data.crdx);
			if(e['type']=='click'){
				if($(this).attr('disabled')!='disabled'){
				   $(this).attr('disabled','disabled');
				}
			}else if(e['type']=='mouseout'){
				console.log('---mouseout---');
			}
			
		});
		$('#id_reset').click(function(e){
			$('#id_btn').attr('disabled',false);
			$('#theText').attr('value',null);
			//即将遍历出jQuery对象的所有属性
			alert('即将遍历出jQuery对象的所有属性!');
			var glo_filedValue = "";
			for(var field_ in $){
				glo_filedValue += '属性'+field_+":"+$[''+field_]+'\n';
			}
			console.log(glo_filedValue);
			//把取出来的属性全都放在<input type="text" id="theText" />中
			$('#theText').attr('value',glo_filedValue);
		});
		/* $(":button").click(function() {
		ajaxFileUpload();
	}) */
		
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

		//动态生成table
		$('#id_table_js').datagrid({
			title : '我是js生成的table',
			width : 400,
			url : 'mydatagrid.json',
			/* iconCls:'icon-search', */
			iconCls : 'icon-edit',
			pagination : true,
			/* pagePosition:'top',
			pagePosition:'bottom', */
			//pagePosition:'both',
			pagePosition : 'bottom',
			pageSize : 11,
			pageNumber : 1,
			pageList : [ 11, 22, 33, 44 ],
			sortName : 'email',
			sortOrder : 'DESC',
			/* method:'post', */
			columns : [ [ {
				field : "user",
				title : "用户",
			}, {
				field : "email",
				title : "邮件账号",
			}, {
				field : "date",
				title : "注册时间",
			} ] ],
			onClickRow : function(index, obj) {
				//console.log('你点了数据行 index:'+index+',obj:'+obj);
				console.log(obj);
				//alert('你点了数据行 index:'+index+',obj:'+obj);
				/* if(obj.user){
					alert(obj.user);
				} */

				$.each(obj, function(ind, v) {
					/* alert('ind:'+ind+',v:'+v); */
					console.log('ind:' + ind + ',v:' + v);
				});
			},
			onDblClickRow : function() {
				alert('hhhh');
			}

		});
		console.log($('#id_table_js').datagrid('options'));

		$('#id_table_js_struts2').datagrid({
			title : '我是js生成的table',
			width : 400,
			/*
				对应的请求：http://localhost:8081/Mytag/getUser?page=1&rows=22&sort=email&order=DESC
						映射命令：lt -s sune -p 8081,这个命令的可以参考：http://blog.csdn.net/k605726828/article/details/49913459 
						映射后的地址：http://sune.localtunnel.me/Mytag/getUser?page=1&rows=22&sort=email&order=DESC 
			 */
			url : 'getUser',
			/* iconCls:'icon-search', */
			iconCls : 'icon-edit',
			pagination : true,
			/* pagePosition:'top',
			pagePosition:'bottom', */
			//pagePosition:'both',
			pagePosition : 'bottom',
			pageSize : 11,
			pageNumber : 1,
			pageList : [ 11, 22, 33, 44 ],
			sortName : 'email',
			sortOrder : 'DESC',
			/* method:'post', */
			columns : [ [ {
				field : "id",
				title : "用户id",
			}, {
				field : "username",
				title : "用户",
			}, {
				field : "email",
				title : "邮件账号",
			}, {
				field : "datetime",
				title : "注册时间",
			} ] ],
			onClickRow : function(index, obj) {
				//console.log('你点了数据行 index:'+index+',obj:'+obj);
				console.log(obj);
				//alert('你点了数据行 index:'+index+',obj:'+obj);
				/* if(obj.user){
					alert(obj.user);
				} */

				$.each(obj, function(ind, v) {
					/* alert('ind:'+ind+',v:'+v); */
					console.log('ind:' + ind + ',v:' + v);
				});
			},
			onDblClickRow : function() {
				alert('hhhh');
			}

		});

	})
</script>
</html>