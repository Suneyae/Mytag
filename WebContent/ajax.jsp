<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.hover {
	background: #cdf4d7;
}

.trhover {
	background: #e6e6e6;
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ajax/ajax.js"></script>
<!--<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/myinit.js"></script>
--><script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ajax/wylAjax.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tishi {
	color: red;
}

INPUT.readonly {
	background-color: #F0F0F0;
}
</style>
<script type="text/javascript"><!--
	//用于wylAjax.js中的$.ajax方法
	var contextPath = "<%=request.getContextPath()%>";
	$(function(){
		$('.hover').mouseover(function(){
			$(this).addClass('trhover');
		});
		
		$('.hover').mouseout(function(){
			$(this).removeClass('trhover');
		});
		
	})
	function getAjax() {
		var xhr;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		}

		xhr.open("get", "getAjax03", true);
		xhr.onreadystatechange = function() {
			var jsonObj;
			if (xhr.readyState == 4) {
				jsonObj = JSON.parse(xhr.responseText);//可以将json字符串转换成json对象，用在前台js中。
				alert("json对象：" + jsonObj);
				alert("json字符串" + xhr.responseText);
				alert("json字符串，使用stringify(jsonObj)" + JSON.stringify(jsonObj));//可以将json对象转换成json对符串 ，用在action中(java代码中)。
				alert("姓名：" + jsonObj.name);
				alert("性别：" + jsonObj.sex);
			}
		}
		xhr.send(null);
	}
	function checkName() {
		var xhr;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		}
		xhr.open("get", "getAjax03?userName="
				+ document.getElementById('userName').value + "", true);
		var jsonObj;
		var jsonStr;
		var jiaoyan = document.getElementById("userName").value;
		var jiaodian = document.getElementById("a");
		alert("jiaoyan:" + jiaoyan);
		if (jiaoyan === "" || jiaoyan === undefined) {
			alert("用户名不能为空");
			jiaodian.focus();
		}
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				jsonStr = xhr.responseText;
				alert("jsonStr:" + jsonStr);
				jsonObj = JSON.parse(jsonStr);
				var userName = jsonObj.userName;
				//console.log("console控制台输出："+userName);
				console.log("wyl_zhyl");
				document.getElementById("span").innerHTML = userName;

			}
		}
		xhr.send(null);
	}
	function getXhr() {
		var xhr;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		} else {
			//ie浏览器
			xhr = new ActiveXObject("Microsoft.XMLHttp");
		}
		return xhr;
	}
	/*
		1.录入搜索内容
		2.js中得到值，然后ajax中发送，service中进行查询，然后返回jsonStr,
		3.ajax中转换为jsonObj,得到jsonObj的值。
	 */
	function doSearch() {
		var xhr = getXhr();

		var sousuo = document.getElementById("sousuo").value;//获取输入框的值
		xhr.open("post", "getSearch?sousuoValue=" + sousuo + "", true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				var jsonStr = xhr.responseText;
				//var jsonObj = JSON.parse(jsonStr);
				var jsonObj = eval('(' + jsonStr + ')');
				//eval('(' + jsonstr + ')');
				var keyValue = jsonObj.keyValue;//获取json对象的keyValue,属性。
				//alert("keyValue:"+keyValue);
				document.getElementById("sousuoFhz").value = keyValue;
				document.getElementById("sousuo").focus();//使搜索框获得焦点
			}
		}
		xhr.send(null);

	}

	function doAjax() {
		var _wyl = new wyl().appendServices({
			serviceId : 'GetAjaxInfoServlet',
			method : 'getJsonObject',
			parameters : {
				CRXX : 234
			}
		});
		_wyl.sendAjax('正在请求数据....', function() {

		}, function() {

		}, false);
		var tmp = _wyl;

	}
	
	function checkUser(obj){
		//alert('this:'+this);
		var _val = obj.value;
		$("#theDiv").load('text-result',{userName:_val});
	}
	
	
	function checkUser2(obj){
		//alert('this:'+this);
		var _val = obj.value;
		$.ajax({
			url:contextPath+'/wdAjax',
			data:{parameters:"333"},
			dataType:'html',
			cache:false,
			async:true,
			type:'post',
			error:function(request,textStatus,errorThrown){
				alert('失败!'+'request:'+request+',textStatus:'+textStatus+',errorThrown:'+errorThrown);
			},
			success:function(data,textStatus){
				alert('成功!');
			}
			
		});
	}
	
	
	function chgReadOnly(obj){
		obj.value = '变为可编辑';
	//	$('.readonly').removeClass();
	//	$('.readonly').addClass('notReadOnly');
		$('.readonly').attr('readonly',false);
	}

	/**
	  
	 */
	function doSearch2() {

		var _wyl = new wyl().appendServices({
			serviceId : 'dBConnUtil',
			method : 'getConn',
			parameters : {
				CRXX : 234
			}
		});

		var method = _wyl.services[0].method;
		var parameters = _wyl.services[0].parameters;
		var serviceId = _wyl.services[0].serviceId;
		var para = [];
		para.push(method);
		para.push(parameters);
		para.push(serviceId);
		if ($.isArray(para)) {
			para = para.join("-");
		}
		_wyl.sendAjax('正在请求服务中...',function(request, textStatus, errorThrown){
			alert('请求成功');
		},function(request, textStatus, errorThrown){
			alert('请求失败了...,request:'+request+',textStatus:'+textStatus+',errorThrown:'+errorThrown);
		},true);//这里也不能是false，否则在chrome浏览器中会报错：
	}
--></script>
</head>
<body>
	
	
	</br> 第二种ajax访问action方式，该方式可以正常使用,对应于MyAjax2.java :
	<input type="text" onblur="checkUser(this)" id="userName2" /><div id="theDiv"></div>
	

</body>
</html>