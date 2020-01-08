<#macro wei para flag>
	<#if flag>
		${para}*1，正确
	<#else>
		${para}*2,错误
	</#if>
</#macro>

<#assign v_global = "卫永乐" >