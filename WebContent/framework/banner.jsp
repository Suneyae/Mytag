<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%

	
%>

<%
  //字典获取方法
  /*
  
    final String DICT_MODE =  ConfUtil.getSysParam("app.dictMode","server");
  IOperator Operator = null;
  Object obj = request.getSession().getAttribute(ConVar.LOGIN_SESSION_ID);
  String CurDate = DateUtil.CurDate.YYYYMMDD_ZH.getDate();
//始终比设定的时间多1分钟，这样系统超时的话就会自动跳到登录界面

//例如系统有可能在SESSION 50分钟的时候，开始不用，那么需要等到1个小时以后，才会自动转到登录界面
  long timeout = 3700*1000;
  String LoginID ="";
  String SessionID ="";
  String OperName ="";
  String OperUnitName=""; 
  String LoginType = (String)request.getSession().getAttribute("LOGINTYPE");
  String OperId = "";
  String shortcutHtml = "";
  String OperType2 = "";
  if(obj != null){
       Operator = (IOperator)obj;
       LoginID  = Operator.getLoginID();
       OperName = Operator.getOperName();
       OperId = Operator.getOperID();
       OperUnitName = Operator.getOperUnitName(); 
       SessionID = (String)request.getSession().getId();
	   OperType2 = Operator.getOperType2();
       BlankService blankService = (BlankService)Util.getBean("blankService");
       shortcutHtml = blankService.getShortcutHtml(OperId,request.getContextPath());
  }
  
  if(LoginType==null){
	  LoginType="loginsb";
  }
  boolean isSheBaoUser = true;
  if(OperType2 != null && !"1".equals(OperType2)){
	  isSheBaoUser = false;
  }
  
  
  */
  
%>


<html>
    <head>
        <title>系统标题栏</title> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <!--[if IE 6]>
             <link href="${ctx}/themes/default/ie6.css" rel="stylesheet" type="text/css"> 
        <![endif]-->
        
    </head>
  
 
<body  leftmargin="0" topmargin="0">
<FORM name="frm"  method="post" action="<%=request.getContextPath()%>/framework/security/logout.do" >
     <input type="hidden" name="_rtnURL" value="<%=request.getContextPath()%>/framework/banner.do" />
   
<div id="_bannerbutton"  class="bannerbutton" > 
 <table width=100%> 
    <tr>
    <td></td>
      <td  width="500px" align="right">
        <table cellSpacing=3 cellPadding=3 border=0>
          <tr>     
            <td><a class="topover" href="${ctx}/jsp/framework/blank.jsp?RightID=blank"  target=workspace >首页</a></td>
            
            <td><a class="topover" href="javascript:void(0);" onclick="showShortcut();">常用菜单</a></td>
            <td><a class="topover" href="javascript:void(0);" onclick="mpass();" >修改密码</a></td>
            <td><a class="topover" href="javascript:void(0);" onclick="relogon();" >重新登录</a></td>            
            <td><a class="topover" href="javascript:void(0);" onclick="doclose();">退出系统</a></td>
            <td><a class="topover" href="javascript:doLink();" >帮助</a></td>
            </tr>
            </table>
          </td>
          <td width="420px" align="center" nowrap>
            <span class="topover">姓名：</span>
            <span class="topover">&nbsp;单位：</span> 
          </td> 
   </tr>
</table>

</div>
<table  width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="<%=request.getContextPath()%>/themes/default/images/banner3.gif">
 
 <!-- 
 	 <tr> 
    <td width="461"><img src="ctx/themes/default/images/banner1.gif" width="461" height="49"></td>
    <td width="32" background="ctx/themes/default/images/banner3.gif">&nbsp;</td>
    <td width="309" background="ctx/themes/default/images/banner2.gif">&nbsp;</td>
  </tr>
 
  -->
 
</table> 
 </FORM>
</body>

</html>

