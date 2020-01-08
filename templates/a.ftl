你好,${user},今天是清明节，今天的日期：${now}
<#-- 这里是注释不应该显示出来   -->
-------测试if指令，--------
<#if user=="Suneyae">
	账号正确1
<#else>
	登陆账号有误1
</#if>

<#if user=="哈哈哈">
	账号正确2
<#else>
	登陆账号有误2
</#if>

<#if 33 gt 18>
	33大于18
<#else>
	33小于18
</#if>
================
<#if 13 gte 48>
	13大于等于13
<#else>
	13小于48
</#if>

--------list指令：测试Freemarker的list遍历-==========
<#list addr as difang >
	城市：${difang.city},国家：${difang.country}
</#list>
---------include指令-----------
<#include "included.txt" />

--定义宏--
<#macro w1> 
	<#-- 注释,Haha  -->
	<b>aaaaaaa</b>
</#macro>
--定义带参数的宏---
<#macro w2 a b c>
	${c}--${b}--${a}
</#macro>

--调用宏-----
<@w1 />
<@w1 />
<@w2 "中国" "hhh" "love" />

<#macro showUrl url flag>
	<#if !flag>
		uri = ${url};
	<#else> 
		<table class="datatable" cellpadding="0" cellspacing="0"  border=0 align="center" >
		you have not input url,please confirm!
	</#if>
	
</#macro>

<@showUrl "www.weibo.com" true />
<@showUrl "www.weibo.com" false />

<#-- 定义变量的方法，使用assign指令 -->
<#assign x="12" />
x的值：${x}

<#-- import指令使用实例 -->
<#-- 引用b.ftl中定义的宏 -->
<#import "b.ftl" as bb />
<@bb.wei "参数one" false />
<@bb.wei "参数two" true />
<#-- 引用b.ftl中的变量  -->
${bb.v_global}
<#-- 覆盖b.ftl中定义的变量v_global的值 -->
<#assign v_global="Sune" in bb />
${bb.v_global}

<#-- 内建函数的使用，使用方法、FreeMarker提供了一些
内建函数来转换输出，可以在任何变量后紧跟?，?后紧跟内
建函数，就可以通过内建函数来转换输出变量 -->
${html2?html}
${html2?cap_first}
${html2?upper_case}