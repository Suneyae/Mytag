package huarong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class MMTag extends AbstractUITag {
	static {
		System.out.println("TAG:static{........}  ");
	}
	public MMTag() {
		System.out.println("huarong.MMTag.MMTag()构造器，实例化...");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * message属性,对应着jsp中自定义标签所属的tld文件中的属性，这里指向的是mm.tld文件中的属性
	 */
	private String message;
	private boolean flag;
	private String btnName;
	private boolean wClick;

	public void setwClick(boolean wClick) {
		this.wClick = wClick;
		System.out.println("TAG:......setwClick......,设置wClick属性");
	}

	private boolean hasTitle = false;

	// public void setHasTitile(boolean hasTitile) {
	// System.out.println("MMTag.setHasTitle(),设置是否有标题...." + hasTitile);
	// this.hasTitile = hasTitile;
	// }

	public boolean isHasTitle() {
		return hasTitle;
	}

	public void setHasTitle(boolean hasTitle) {
		this.hasTitle = hasTitle;
	}

	@Override
	/**
	 * 继承AbstractUIBean 覆盖的方法，实际上AbstractUIBean继承了ComponentTagSupport 这个
	 * 类，这个public Component getBean(ValueStack arg0, HttpServletRequest arg1,
	 * HttpServletResponse arg2)方法实际上是 ComponentTagSupport类里的抽象方法
	 * 
	 * 用于获取Bean
	 */
	public Component getBean(ValueStack arg0, HttpServletRequest arg1, HttpServletResponse arg2) {
		// 第二步，获取bean，
		System.out.println("TAG:.....11111.....,MMTag.getBean()方法，ValueStatck:" + arg0 + ",");
		return new MM(arg0, arg1, arg2);// 固定写法
	}

	@Override
	/**
	 * 组装参数，实际上就是给bean进行赋值，而这个值就是在MMTag(AbstractUITag实现类) 中的setter方法从jsp页面中获取到的。
	 */
	protected void populateParams() {
		super.populateParams();
		// 第三步，
		System.out.println("TAG:.......populateParams.......");

		MM mm = (MM) this.component;
		mm.setMessage(message);
		mm.setBtnName(btnName);
		mm.setwClick(wClick);

	}

	/**
	 * 第一步，根据标签里自定义的 message属性的属性值直接赋值
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		// 第一步 ，实例化MMTag，然后调用setMessage方法进行赋值
		this.message = message;

		System.out.println("MMTag.setMessage(),设置属性，TAG:......setMessage......");
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
		System.out.println("传入的参数btnName：" + btnName + " ,TAG:......setBtnName......,设置btnName属性");
	}

}
