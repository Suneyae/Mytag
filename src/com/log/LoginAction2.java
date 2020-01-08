package com.log;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.log.entity.User;
import com.log.entity.User3;
import com.log.impl.DTO;
import com.log.interf.IDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;
import com.util.LoggerRequest;

/**
 * 普通的登陆,模型驱动
 * 
 * @author Wei
 * 
 */
public class LoginAction2 extends ActionSupport implements ModelDriven<User3>,
		IDTO, Preparable {

	protected IDTO dto;
	protected String _rtnURL = "";
	protected String vals = "";
	protected final HttpServletRequest request = ServletActionContext
			.getRequest();
	protected final HttpServletResponse response = ServletActionContext
			.getResponse();

	public IDTO getDto() {
		return dto;
	}

	public void setDto(IDTO dto) {
		this.dto = dto;
	}

	public String get_rtnURL() {
		return _rtnURL;
	}

	public void set_rtnURL(String _rtnURL) {
		this._rtnURL = _rtnURL;
	}

	public String getVals() {
		return vals;
	}

	public void setVals(String vals) {
		this.vals = vals;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * 模型驱动的第一步，在Action中new一个实例
	 */
	// private User user = new User();

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}

	/**
	 * 复写ModelDriven这个接口
	 */
	@Override
	public User3 getModel() {
		/**
		 * 获取登录请求的相关信息，并且放到dto中
		 */
		prepareDto();

		// ValueStack vs = ActionContext.getContext().getValueStack();
		User3 u2 = new User3();
		// //更改值栈里的数据值
		// u2.setAccount("wode");
		// u2.setPassWord("234");
		// u2.setUserName("wei");
		// vs.push(u2);
		System.out.println("LoginAction2.getModel()...");
		return u2;
	}

	private void prepareDto() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		HttpServletRequest rq = ServletActionContext.getRequest();
		try {
			//不加这行下面获取 String queryString = rq.getQueryString(); 会出现乱码，实际上加了也没什么用
			rq.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String queryString = rq.getQueryString();
		try {
			//这里把字符用utf-8进行编码，否则会出现乱码，导致插入到数据库日记表中的时候看不懂
			queryString = java.net.URLDecoder.decode(queryString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//记录数据库日记
		LoggerRequest.log(queryString);
		Enumeration attrNames = rq.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String key = (String) attrNames.nextElement();
			data.put(key, rq.getAttribute(key));
		}
		Map<String, Object> sessionAttr = ServletActionContext.getContext()
				.getSession();

		if (sessionAttr != null) {
			// data里会村放进valueStack;
			data.putAll(sessionAttr);
		}

		/**
		 * 
		 */
		if (null == dto) {
			this.dto = new DTO();
		}
		/**
		 * 从data取出存放进入的valueStack
		 */
		ValueStack stack = (ValueStack) data.get("struts.valueStack");
		String name = (String) stack.findValue("userName");
		String password = (String) stack.findValue("passWord");
		this.dto.setData(data);
		
	}

	@Override
	public Map<String, Object> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		this.dto.setData(paramMap);
	}

	@Override
	public StringBuffer getJSONData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reflectEntity(Object paramObject) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValue(String paramString, Object paramObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getValues(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		
	}
	
	
	
}
