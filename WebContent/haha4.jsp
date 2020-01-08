


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title></title>

path:/Mytag

<script type="text/javascript">
	
</script>
<script type="text/javascript"
	src="/Mytag/js/jquery.js"></script>
<script type="text/javascript"
	src="/Mytag/js/wylUtil.js"></script>
<script type="text/javascript"
	src="/Mytag/js/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/Mytag/easyui_theme/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/Mytag/easyui_theme/themes/icon.css">
<!-- 下面的/Mytag这种形式是el表达式，详见：http://zhidao.baidu.com/link?url=3Y1mcXIw6wGsStFzAJKpMKwjSClGMcYlNbOsjgAeyt667DhyVEGK_p7ybQ9Vqo7n3_UPn-ll0N2ihWP8WuvqPa -->
<link rel="stylesheet" type="text/css"
	href="/Mytag/easyui_theme/locale/easyui-lang-zh_CN.js">
</head>
<body>
</body>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
0:0:0:0:0:0:0:1,端口号63870
<div align="center">
<a href="http://weibo.com/daxixis/home?wvr=5&sudaref=www.bing.com">自定义的卫永乐 </a> 
<br/>
------

<span onclick="FWshowTable('img_hahojfojjoi_grid','hahojfojjoi')" >
			<img id="img_hahojfojjoi_grid" src="/Mytag/themes/default/images/query_icon_right.gif">
</span>
----
<br/>
       <input align="center" type= "button" name="hahojfojjoi" value="hahojfojjoi" onClick="WylClick(this)"  message="自定义的卫永乐"/>
</div>
<title>Welcome wyl</title><br>
true

<script language="javascript">
 $(function(){
 	var flag = true;
 	//alert('flag'+flag);
 	if(flag){
 		window.WylClick = function(obj){
 			var val_obj = obj.value;
 			alert(val_obj);
 		}
 	}
 	function FWshowTable(imgId,tableId){
 		alert('imgId:'+imgId);
 		var img = $('#'+imgId).child().get(0);
 		var srcPath = img.src;
 		var index = srcPath.indexOf('right');
 		if(index>0){
 			img.src = srcPaht.replace(/right/g,'down');
 		}
 		var index2 = srcPath.indexOf('down');
 		if(index2>0){
 			img.src = srcPaht.replace(/down/g,'right');
 		}
 	}
});
</script> 

<script type="text/javascript">
	//测试wylUtil.js的linkbutton方法
	//linkbutton({disabled:false});
	var _wyl_obj = wyl('btnn');
	var opts = {
		disabled : true
	};
	_wyl_obj.linkbutton(opts);
	
</script>
</body>
</html>