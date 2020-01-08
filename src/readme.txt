1 com.thread
这个包是关于线程的，使用ThreadLocal来测试

2 com.log
用来模拟登陆的,struts2的使用等，以及拦截器,访问地址是：http://localhost:443/Mytag/hahaAny.jsp


3 haha2.jsp自定义标签，结合struts2和freemarker来实现 
http://localhost:443/Mytag/haha2.jsp

4 struts2，ajax的官方实例，http://localhost:443/Mytag/ajax.jsp，用于接收text格式的返回值
4.2 发送ajax请求，这个例子模拟了社保项目中用js调用service,
http://localhost:8081/Mytag/ajax03.jsp

5 freemarker最简单的使用步骤的实例：com.test.freemarker.Test1.java

6 模态窗口  http://localhost:443/Mytag/motaichuangkou.html
这个页面有个按钮，点击之后可以打开模态窗口 ,
还用到了js自带的，encodeURIComponent()的方式

7 加载更多的效果,例子:http://coral.qq.com/1515695980
<div id="loadMore" class="np-load-more" style="display: block;">

                    <span style="display: block;">加载更多</span>
                    <em style="display: none;" class="np-load-more-loading">没有更多了</em>

</div>


8 <frame>和<frameset>标签 的使用 
  http://localhost:443/Mytag/frameset.html

9 TestClassgetResource.java 
关于Class.getResource和ClassLoader.getResource的路径问题

10 struts2 模型驱动  ，页面：http://localhost:443/Mytag/hahaAny.jsp
对应着 LoginAction2.java ,使用模型驱动的action，执行的步骤：
 a public User3 getModel() {
   		
   }
   这个方法，
 而且这个LoginAction2.java中使用的dto的封装
   
 b 执行 默认的
   public String execute() throws Exception {
		return SUCCESS;
	}
	方法。
在LoginAction2.java 中会记录登录时请求的参数，记录在表mylog中，mylog的建表语句在
oracle.sql中

11 easyui 的简单练习使用 
easyui中的table的使用，easyui-datagrid，详见：http://localhost:8081/Mytag/myeasyui_datagrid.jsp
里面包括了json字符串的循环使用，用的jQuery.each(jsonObj,function(index,value){});的方式

easyui-datagrid从数据获取数据，具体例子：http://localhost:8081/Mytag/myeasyui_datagrid.jsp 

获取json数据：
直接访问：http://localhost:8081/Mytag/getUser!getJsonData?id=90
或者 访问 http://localhost:8081/Mytag/myeasyui_datagrid.jsp ，点击"获取json数据"按钮

12 引入jquery，easyui以及一些样式什么的，大部分的都放在了head.jsp里了，
       可以参见head.jsp,所以在其他的jsp中直接通过include指令引入head.jsp就行了，
       如：http://localhost:443/Mytag/myeasyui.jsp中的
       <%@ include file="/WEB-INF/head.jsp"%>

13 内部类 com.test.javaAPI.InnerClassTest


14 关于 HttpServletResponse 在页面输出的时候可能出现的中文乱码情况的解决办法：
HttpServletResponse  resp = ServletActionContext.getResponse();
resp.setContentType("text/html;charset=UTF-8");
GetUserAction.java 里有
ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");

15 设计模式：主要是代理设计模式，动态代理
com.base.pattern.test.test

16 String的操作测试类
com.test.javaAPI.StringTest

17 我的String字符串操作工具类：
com.util.UtilString

18 servlet(详见：com.test.javaAPI.servlet.MyServlet )使用的小细节：
1 resp.getWriter()和resp.getOutputStream()方法不能同时使用，否则会包报异常
java.lang.IllegalStateException: getWriter() has already been called for this response
2 

19 Struts2中获取HttpServletRequest,HttpServletResponse,HttpSession等的4种方式
见：
com.log.LoginAction333.java


20
测试页面：
http://localhost:8080/Mytag/sessionBinding.jsp 
给HttpSession对象session绑定一个attribute，绑定值是一个是实现了HttpSessionBindingListener接口的实体类(具体见User6.java)。实现了这个接口会要复写 
@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("测试session的属性的绑定,com.log.entity.User6.valueBound(HttpSessionBindingEvent event)...." + event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("测试session的属性的绑定,com.log.entity.User6.valueUnbound(HttpSessionBindingEvent event) ...." + event.getName());
	}
这两个方法

21 json对象与map的互转，
 com.test.javaAPI.json.JacksonTest
使用了jackson

22 模拟struts2的拦截器，参见 76_尚学堂(中国最专业JAVA培训机构)_Struts2_拦截器原理模拟，百度网盘里有
ActionInvocation.java


23 在页面显示一个图片，通过struts2 type=stream的形式,响应的页面：to_img_success.jsp,
发送请求的页面写在ajax03.jsp

24 简单的递归

25 hashtable与hashmap的区别，
前者线程安全，同步，效率低
后者非线程安全，异步，效率高
Properties实际上是Hashtable的子类
详见 com.test.javaAPI.collections.ProprtiesTest

26 文件上传 可以正常使用
注意事项：
<!-- 上传过程中临时文件存放目录，这个开关可能会影响文件上传，具体影响是：上传页面不报错，只是直接返回到原来页面，具体原因还不知道 -->
	<!-- <constant name="struts.multipart.saveDir" value="c:\"></constant> -->

http://localhost:8081/Mytag/myeasyui_datagrid.jsp 的
 1 上传文件------- 
以及
 2 《《《《《《《《《《我可以使用了哈《《《《《《《《 
 

 
这两个表单

链接：http://localhost:8081/Mytag/login.jsp，登陆的时候填写账号不为 wyl,123的进行提交就会出现error.jsp页面，
该页面提交对应的Action为 com.log.LoginAction

27 jsp标签的使用：

<jsp:param>的使用


28 页面的输入框或者控件的隐藏或者显示的方法，详见 wylUtil.js的 css("visibility","hidden");部分


29 Redis的简单实用，结合java使用Redis,详见 com.redis.RedisJava，要在java中使用Redis,首先需要
先启动Redis服务，如何启动Redis服务，可以看我自己的博客园


30 jsp中的声明 ，参考：http://www.imooc.com/article/10439
格式：<%!
	  	可以声明一个函数
	  %>
	 例子：http://localhost:8080/Mytag/declaration.jsp 
	 
	 
31 http://localhost:8082/Mytag/locationtest.html
 测试：window.location的用法
 //贷款企业导入
function dkqydr(){
	var url = basePath + "work/sygl/yhimport/singleImport.jsp";
	window.location=url;
}
//跳转到另一个页面，就有点和点超链接类似
window.location = 'http://localhost:8082/Mytag/declaration.jsp';

32 mybatis相关 在 MyBatisDemo01.java 中


33 StringBufferTest.java这个类里测试了StringBuilder,StringBuffer,String的差异，
具体可以参考：http://www.cnblogs.com/xudong-bupt/p/3961159.html以及
http://www.cnblogs.com/fancydeepin/archive/2013/04/23/min-snail-speak_String-StringBuffer-StringBuilder.html

34 MD5加密解密：详见：/com/test/javaAPI/encryption/MD5Util.java


35 添加MyBatis接口式编程，详见：com.test.mybatis.dao.interf.IMyUserTest，


36 spirng,mybatis整合

37 com.test.javaAPI.hashtest.HashCodeTest,用于练习HashCode的，
参见：http://www.cnblogs.com/absfree/p/5508570.html


38 生产者与消费者
com.thread.Test.java
参见：http://www.cnblogs.com/absfree/p/5327678.html


39 ThreadLocal 线程局部变量的使用
com.thread.ThreadLocalTest.java


40 异或的练习
com.test.javaAPI.bitoperation.Xor.java


41 自定义注解：
com.test.javaAPI.annotation.test.Test，
参考：http://www.cnblogs.com/liangweiping/p/3837332.html
	  http://www.cnblogs.com/absfree/p/5295861.html

42 volatile关键字的使用,并发编程
com.test.javaAPI.VolatileTest.java
参考:http://www.cnblogs.com/dolphin0520/p/3920373.html
