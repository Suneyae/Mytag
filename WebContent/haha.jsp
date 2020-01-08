<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.wyl.suneyaee" prefix="Wyl"%>
<%@taglib uri="/cur" prefix="WYL"%>
<%@ include file="/WEB-INF/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<Wyl:getIP />
<WYL:mm btnName="hahojfojjoi" message="自定义的" wClick="true"></WYL:mm>
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