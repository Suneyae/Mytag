package huarong;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * refer:	http://blog.csdn.net/zxq1406spys/article/details/5704548
 */

/**
 * 看完uitag这部份，发现一个问题，就是如果我要一个pagebar这样的UITag怎么办？
 * 总不能每一页我都在JSP上写吧？就算是复制都很不聪明。于是开始研究怎么去写一个Tag，
 * 在网站找了N多文章，大都是用out.println(...)这样的方式，而没有使用template的方式，
 * 自己总觉得这样的方式不灵活而且麻烦，容易出错，于是查看struts2的源码，终于找出怎
 * 么去写Struts2 Tag的方法。

 Struts2 的UITag原理：
 Struts2 UITag分三部份组成，一部份用于定义Tag的内容与逻辑的UIBean，一部份用于定
 义JSP Tag，也就是平时我们定义的那种，最后就是Template，它存放在你的theme目录之下，
 是一个FreeMarker模板文件。

 我现在辑写一份MMTag，它主要是用于输出带链接的文字，比如像这样：
 <cur:mm message="'I am a boy.'" />
 就会输出：
 <a href="http://www.blogjava.net/natlive">I am boy.</a>

 我们先写UIBean部份：我们把它定义为MM，它继承于org.apache.struts2.components.UIBean：
 */

/**
 * strutsTag注解指明了该UIBean的名字和Tag类的类名。
 * getDefaultTemplate()方法用于返回模板的名字，Struts2会自动在后面加入.ftl扩展名以找到特定的模板文件。
 * setXXX，设置UIBean的属性 ，一般Tag中有几个这样的属性，这里就有几个。@StrutsTagAttribute(description=
 * "set message", type="String")注解，说明该属性是字符串（也可以是其它），这一步很重要。
 * 覆写evaluateExtraParams（）方法，在UIBean初始化后会调用这个方法来初始化设定参数
 * ，如addParameter方法，会在freemarker里的parameters里加入一个key
 * value。这里要注意findString，还有相关的findxxxx方法
 * ，它们是已经封装好了的解释ognl语法的工具，具体是怎么样的，大家可以查看一下UIBean的api doc。
 * 
 * @author Wei
 * 
 */
public class MM extends UIBean {
	static {
		System.out.println("Bean:static{........}  ");
	}

	private String message;

	private boolean flag;

	private String btnName;

	private boolean wClick;

	private boolean hasTitle;

	public boolean isHasTitle() {
		return hasTitle;
	}

	public void setHasTitle(boolean hasTitle) {
		this.hasTitle = hasTitle;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public MM(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
		// TODO Auto-generated constructor stub
	}

	/**
	 * setXXX，设置UIBean的属性，一般Tag中有几个这样的属性，这里就有几个。@StrutsTagAttribute(description=
	 * "set message", type="String")注解，说明该属性是字符串（也可以是其它），这一步很重要。
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
		System.out.println("Bean:...setMessage.....");
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
		System.out.println("Bean:...setBtnName.....,设置btnname:" + btnName);
	}

	public void setwClick(boolean wClick) {
		this.wClick = wClick;
		System.out.println("Bean:......setwClick......,设置Wcli属性:" + wClick);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * getDefaultTemplate()方法用于返回模板的名字，Struts2会自动在后面加入.ftl扩展名以找到特定的模板文件。
	 * 实际上可以通过调试模块在这里打断点进行调试，会发现框架自动在位置 /template/xhtml这个文件夹下寻找wyl.ftl这个文件
	 * 但不知道为什么，实际上我这里放在template/simple这个文件夹下，也同样可行，没有报错。如果放在/template/xhtml下也可以，
	 * 但是其他名称的路径下就会报错找不到wyl.ftl
	 * 注意：template/xhtml这个文件夹要放在WebContent下，因为在tomcat部署的时候这个目录才是真正的根目录
	 */
	
	protected String getDefaultTemplate() {
		System.out.println("getDefaultTemplate()开始 parameters:"+parameters.toString());
		/**
		 * 这个parameters实际上是org.apache.struts2.components.Component
		 * 这类的一个成员变量， protected Map parameters;
		 * 因为UIBean继承了这个类，所以可以访问到这个类
		 */
		Map<String, Object> map = this.parameters;
		parameters.put("theme", "xxx");
		System.out.println("getDefaultTemplate()结束 parameters:"+parameters.toString());
		// 第四步 组装参数后就是通过Bean实例的getDefaultTemplate()方法获取freemarker模板
		System.out
				.println("MM.getDefaultTemplate(),获取模板，即获取ftl模板，Bean:...22222.....");
		return "wyl6";
	}

	@Override
	/**
	 * 覆写evaluateExtraParams（）方法，在UIBean初始化后会调用这个方法来初始化设定参数，
	 * 如addParameter方法，
	 * 会在freemarker里的parameters里加入一个key
	 * value。这里要注意findString，还有相关的findxxxx方法，
	 * 它们是已经封装好了的解释ognl语法的工具，具体是怎么样的，
	 * 大家可以查看一下UIBean的api doc。
	 */
	protected void evaluateExtraParams() {
		super.evaluateExtraParams();
		System.out
				.println("MM.evaluateExtraParams()，评估额外参数，Bean:...33333.....");
		/**
		 * 如果自定义标签的message属性不是必填的， 那么就可能为null，所以这里就做一个为null的判断处理
		 */
		if (message == null) {
			message = "message值为空,";
		}
		message += "卫永乐";
		System.out.println("btnName:" + btnName);
		if (message != null) {
			/*
			 * addParameter("message")中的参数message就是指的tld文件
			 * 中的自定义的message属性，所以名字一定要一样;
			 */
			System.out.println("Bean:...44444,findString(message):"
					+ findString(message));
			addParameter("message", findString(message));

		}
		if (btnName != null) {
			addParameter("btnName", btnName);
			System.out.println("Bean:...44444,findString(btnName):"
					+ findString(btnName));
		}
		if (hasTitle) {
			addParameter("hasTitle", hasTitle);

		} else {
			addParameter("hasTitle", hasTitle);
		}
		System.out.println("hasTitle:...44444,findString(hasTitile):"
				+ hasTitle);
		if (wClick) {
			// 在ftl中做判断，如果是1，那么就加上onclick事件，否则不加
			addParameter("wClick", true);
		} else {
			addParameter("wClick", false);
		}
		System.out.println("Bean:...44444,findString(wClick):" + wClick);

	}
}
