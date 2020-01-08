<%@page import="com.test.javaAPI.FrameTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/cur" prefix="WYL"%>
<%@ include file="/WEB-INF/head.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/MyTag.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的自定义标签</title>
</head>

<body>
<br>
------发送微信请求--------
<form action="wechat.do?name=890d" method="post">
	<input type="submit" value="发送微信请求"  id="txt_4" />
</form>
------------
<br>
导航页面：
<br>
<a href="/Mytag/beauty.jsp" target="_blank">看美女</a>
<br>
<a href="/Mytag/lzd.jsp" target="_blank">罗指导</a>
<br>
<a href="/Mytag/ball.html" target="_blank">摆动球</a>
<br>
<a href="/Mytag/JSON.html" target="_blank">JSON序列化</a>
<br>
<br>
<a href="/Mytag/myeasyui_datagrid.jsp" target="_blank">myeasyui_datagrid.jsp</a>
<br>
<a href="/Mytag/motaichuangkou.html" target="_blank">motaichuangkou.html</a>
<br>
<a href="/Mytag/getUser!getJsonData?id=90" target="_blank">getUser!getJsonData?id=90</a>
<br>
<a href="/Mytag/ajax03.jsp" target="_blank">ajax03.jsp</a>


有标题
<WYL:mm btnName="heihie" message="haoba" hasTitle="true" wClick="true"></WYL:mm>
<br>
无标题
<WYL:mm btnName="我是按钮名" message="呃呃呃" hasTitle="false" wClick="true"></WYL:mm>
<a style="cursor:help;" href="/Mytag/uploadResult.jsp">转到uploadResult.jsp页面</a>
<a style="cursor: default;" href="/Mytag/welcome.jsp">本机的ip地址</a>
<input type="text" id="id_text" class="buttonlink l-btn" value="hhhu" /> 
<form name="xxx" action="#" id="form1" onclick="myClick('xxx');">
	<input type="button" value="null1"  id="btn_1" />
	<br/>
	<input type="text"" value="abc2"  id="txt_2" />
	<br/>
	<input type="text" value="def3"  id="txt_3" />
	<br/>
	
</form>
<!-- 默认为不显示， -->
<div id="id_ydd" class="notdisplay" >
		<img alt="杨丹丹" src="/Mytag/myimg/ydd.jpg" height="480" width=640>
</div>
<br/>
<br/>
<input type="text" value="def4"  id="txt_4" />
<br/>

-----------------


<form name="xxx2" action="totest" id="form2" onclick="myClick('xxx');">
		uuuuuu
		<br/>
		<input type="submit" value="提交totest"  id="txt_3" />
		<input type="button" value="显示java基础图片"  id="txt_6" />
		<input type="button" value="启动swing"  id="txt_7" />
		<a href="login.jsp">到登录页面，login.jsp</a>
		<br/>
		<br/>
		<div id="id_easyui_window_father" style="width: 300px; height: 200px; border: solid 1px #ccc; position: relative;overflow: hidden;">
			我用来放置easyui-window
			<!-- 下面是easyui-window -->
			<div id="id_easyui_window" class="easyui-window"></div>
		</div>
		
			
			
		<br/>
		<br/>
		<div id="id_javabase" class="notdisplay">
			<img alt="java基础" src="/Mytag/myimg/javabase.PNG">
		</div>
		
		
		
		<div align="center">
			下面是透明效果
			<div class="video-overlay">
				<img alt="暂停无法正常显示" src="http://i5.pdim.gs/6271dc9f527061dc2bccd789a1d443c3.png">
				<img alt="wufaxianshi" src="http://i3.pdim.gs/t016cfb0e8d769c2270.png">
			</div>
			全透明
			<div align="center" class="touming">
				<img alt="全透明" src="http://i3.pdim.gs/t016cfb0e8d769c2270.png">
			</div>
			<br/>
			<br/>
			下面是普通效果
			<div >
				<img alt="暂停无法正常显示" src="http://i5.pdim.gs/6271dc9f527061dc2bccd789a1d443c3.png">
				<img alt="wufaxianshi" src="http://i3.pdim.gs/t016cfb0e8d769c2270.png">
				<img alt="没有正常获取到图片的时候你会看到我" src="http://i3.pdim.gs/t016cfb0e8d769c2270.png">
			</div>
		</div>
</form>





----------------
<br/>

 <a href="###" style="display:inline-block;width:100px;height:20px;line-height:20px;text-align:center;overflow:hidden;position:relative;">上传附件<input id="uploadFile1000000063" name="uploadFile" type="file" onchange="weiylFileChange(this);return false;" style="opacity:0;filter:alpha(opacity=0);font-size:100px;position:absolute;top:0px;right:0px;width:100px;height:20px;cursor:hand;" /></a>
</body>
<script type="text/javascript" >

	$(function(){
		var cnt = 0;
		var flag = -1;
		var obj = $('#id_text').get(0);
		if(obj.type=='text'){
			obj.readOnly = true;
		}
		//wylOnDbClick('txt_4',myFun1);
		
		$('#txt_6').toggle(function () {
			$('#id_javabase').removeClass().addClass('dodisplay');
		  },
		  function () {
			  $('#id_javabase').removeClass().addClass('notdisplay');
		  }
		);
		$('#txt_7').click(function () {
			/**
				FrameTest f = new FrameTest();
				f.launchFrame();
				System.out.println("---------------------");
				out.println("99999999999999999999");
			;
			*/
		  }
		);
		
		/*
		 在显示了java基础照片后，如果鼠标在这张图片上移动，那么显示美女照片
		*/
		$('#id_javabase').hover(function(){
			flag = cnt%2;
			cnt++;
			if(flag==1){
				$('#id_ydd').removeClass().addClass('dodisplay');
				console.log('----111111-----');
			}else{
				$('#id_ydd').removeClass().addClass('notdisplay');
				console.log('----2222-----');
			}
		});
		/**
		   easyui-window的用法
		*/
		$('#id_easyui_window').window({
			//closable:false,
			title:'卫永乐自定义窗口title',
			/* modal:false,
			width:300,
			height:200,
			//zIndex:400,
			draggable:true,
			shadow:false,
			//model:true
			modal:true, */
			width:300,
			height:200,
			//fit:true,
			inline:true,
			onClose:function(){
				alert('你要关闭窗口吗？');
			}
			
		});
		var cnt_dblclick = 0;
		var flag_dblclick = 0;
		$(document).dblclick(function(){
			cnt_dblclick++;
			flag_dblclick = cnt_dblclick%3;
			if(flag_dblclick==0){
				//alert('浮动窗口将移动到左上角'+flag_dblclick);
				$('#id_easyui_window').window('move',{
					left:0,
					top:0
				}); 
			}else if(flag_dblclick==1){
				$('#id_easyui_window').window('hcenter'); 
			}else{
				//alert('浮动窗口将移动到右侧');
				$('#id_easyui_window').window('move',{
					left:900,
					top:0
				}); 
			}
			
			/* $('#id_easyui_window').window('center'); */
		});
		console.log($('#id_easyui_window').window('options'));
	})
		function myFun1(){
			alert("myFun1:"+this.value);
		}
		
		function WylClick(obj) {
			alert('this:' + obj.value);
		}
		
		function WylBlur(obj){
			alert(this.value);
		}
		function myClick(para){
			console.log('myClick：'+typeof para);
		}
		
</script>
</html>