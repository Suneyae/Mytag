<#-- 引入struts2标签库， #assign s=JspTaglibs["/WEB-INF/struts-tags.tld"]  -->
<#--这一句是为了让Freemarker识别struts2的标签 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
	<h1>${companyName}</h1>
	<form>
		<input type="text" />
		<input type="submit" />
	</form>
  </body>
</html>

