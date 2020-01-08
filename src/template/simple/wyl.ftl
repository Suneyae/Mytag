<#-- 生成多记录表对应js脚本的区域-->
<#-- 这里是注释不应该显示出来   -->
<script language="javascript">
 $(function(){
 	<#-- 用  var flag = ${parameters.wClick?string("true","false")}
 		的形式可以获取到值，如果 ${parameters.wClick?string("true","false")} 是"true"，
 		那么用来接收的 flag 就是 boolean 的true,否则就是false,
 	 -->
 	var flag = ${parameters.wClick?string("true","false")};
 	//alert('flag'+flag);
 	if(flag){
 		<#--
 			我这个注释会在客户端显示出来，如果自定义标签设置的是true，
 		那么就在全局加上WylClick这个function，
 		-->
 		window.WylClick = function(obj){
 			var val_obj = obj.value;
 			alert(val_obj);
 		}
 	}
 	<#-- 这里的imgId，是图片id,tableId暂时不用 -->
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

<div align="center">
<a href="http://weibo.com/daxixis/home?wvr=5&sudaref=www.bing.com">${parameters.message?html} </a> 
<br/>
------
<#-- ${request.contextPath}这个的值为 /Mytag，就是获取项目名 20160823 -->

<span onclick="FWshowTable('img_${parameters.btnName}_grid','${parameters.btnName}')" >
			<img id="img_${parameters.btnName}_grid" src="${request.contextPath}/themes/default/images/query_icon_right.gif">
</span>

<span onclick="TT('img_${parameters.btnName}_grid','${parameters.btnName}')" >
			<img id="img_${parameters.btnName}_grid" src="${request.contextPath}/themes/default/images/query_icon_right.gif">
</span>
----
<br/>
<#if parameters.btnName != ""&& parameters.wClick ==true &&parameters.hasTitle==true>
		

       <input align="center" type= "button" name="${parameters.btnName}" value="${parameters.btnName}" onClick="WylClick(this)" title= "I AM BIAOTI"/>
<#elseif parameters.btnName !=""&& parameters.wClick ==true &&parameters.hasTitle==false >
       <input align="center" type= "button" name="${parameters.btnName}" value="${parameters.btnName}" onClick="WylClick(this)"  message="${parameters.message}"/>
<#elseif parameters.btnName !=""&& parameters.wClick ==true >
       <input type="button" name= "${parameters.btnName}" value="${parameters.btnName}" />
<#elseif parameters.btnName !=""&& parameters.wClick ==true >
       <input type="button" name= "${parameters.btnName}" value="${parameters.btnName}" />
<#elseif parameters.message !="">
       <input type="button" onblur="WylBlur(this)" message="${parameters.message}" name= "${parameters.btnName}" value="${parameters.btnName}" />
<#else>
       you have not input btnName property
</#if>
</div>
<#import "wyl3.ftl" as bb />
<title>Welcome wyl</title><br>
<#-- 这里是注释不应该显示出来,由于freemarker不支持boolean，
所以需要以${parameters.wClick?string("true","false")}进行折中的转换   -->
${parameters.wClick?string("true","false")}

