<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.opensymphony.xwork2.ActionContext" %>
<%@ page language="java" import="java.util.Map" %>
<%@ page language="java" import="java.text.SimpleDateFormat,java.text.DateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ui/fwwindow.js"></script>
<script type="text/javascript">
	function initWindow(){
		document.getElementById('bulletinWindow').style= "display:block";
	}
	$(function(){
		initBulletinWindow();
		//设置窗口为显示
		//initWindow();
		
		//初始化弹出窗口

		$('#bulletinWindow').fwwindow({
		   	title: '公告',
			width: 900,
			modal: true,
			closed: true,
			height: 450
		});
		//打开弹出窗口
		$('#bulletinWindow').fwwindow('open');
		
	})
</script>
</head>
<%
	Map sessions = ActionContext.getContext().getSession();
	String theParas = (String)sessions.get("thePara");
	theParas = java.net.URLDecoder.decode(theParas,"UTF-8");
	out.print("传过来的参数theParas:"+theParas);
	String xxx = "%5B%7B%22parameters%22%3A%7B%22PI_CAE574%22%3A%2220160908%22%2C%22PI_JSRQ%22%3A%2220160908%22%2C%22Pi_CAE920%22%3A%22301%22%2C%22Pi_YAE601%22%3A%221%22%2C%22PI_BAE001%22%3A%22511502%22%2C%22Pi_JFDX%22%3A%221%22%2C%22%22%3A%22pkg_weiyl.getMatchResult%22%7D%2C%22serviceId%22%3A%22directJdbcService%22%2C%22method%22%3A%22savePointProcedure%22%7D%5D";
	String yyy = "%7B%7D";
	out.print("解析后的数据1："+java.net.URLDecoder.decode(xxx,"UTF-8"));
	
	out.print("解析后的数据2："+java.net.URLDecoder.decode(yyy,"UTF-8"));
	
%>
<body>

<img alt="美女图片" src="http://s.cimg.163.com/i/dingyue.nosdn.127.net/7N0mXX9DSwI5ov5NIN56jx5KOhyJisbHRPZKyculHXvyl1471756033621.jpg.640x10000.75.auto.jpg">
<a href="http://www.baidu.com">跳转到百度</a>
<br/>
<a href="haha2.jsp">跳转到自定义标签</a>
</body>

<%-- 公告弹出窗口 --%>
<div id="bulletinWindow" style="display:none;background-color: threedface;" class="window">
	<form name="bulletinForm">
		<div id="bulletinWindowMsgs">
		</div>
		<p align="center">
		<hnisi:btn  onclick="setPopupCookie()" value="今日内停止弹出公告"></hnisi:btn>
		</p>
	</form>
	
</div>

<script type="text/javascript">

/**
 * 初始化弹出窗口的数据
 */
function initBulletinWindow(){
	  <%
	  StringBuffer bulletinHtml =new StringBuffer();
	  
	 // String title = (String)Util.nvl(bulletin.get("TITLE"));
	  //String content = ((String)Util.nvl(bulletin.get("CONTENT"))).replace("\"","'");
	 // String duetime = ((Number)bulletin.get("DUETIME")).toString();
	  String title = "我是标题";
	  String content = "我是内容啊喂，";
	  String duetime = "20121224113338";
	  DateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
	  DateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	  duetime = format2.format(format1.parse(duetime));
	  bulletinHtml.append("<p align='center' style='font-family:黑体;font-size:250%;'>").append(title).append("</p>")
	  			  .append("<p align='center' style='font-family:微软雅黑,宋体;font-size:100%;'>").append(duetime).append("</p>")
	  			  .append("<div style='background-color:white;'>").append(content).append("</div>")
	  			  .append("<br/><hr size='2' color='blue' style='filter:alpha(opacity=15,finishopacity=50,style=1,startX=100,startY=100,finishX=0,finishY=0)'/></br>");
	  
	 %>
   
   $('#bulletinWindowMsgs').html("<%=bulletinHtml.toString()%>");
}
</script>

</html>