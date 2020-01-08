package com.log;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.log.impl.DTO;
import com.log.interf.IBaseAction;
import com.log.interf.IDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 模拟 项目中的 BaseActionSupport这个类
 * 
 * @author Wei 下午06:07:05 2016-8-28
 */
public class BaseActionSupportWyl extends ActionSupport implements IBaseAction,
		IDTO, ModelDriven, Preparable {

	public BaseActionSupportWyl() {
		this.dto = new DTO();
	}

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

	protected IDTO dto;
	protected String _rtnURL = "";
	protected String vals = "";
	protected final HttpServletRequest request = ServletActionContext
			.getRequest();
	protected final HttpServletResponse response = ServletActionContext
			.getResponse();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	@Override
	public Map<String, Object> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub

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

	/**
	 * 这个方法肯定在execute()方法之前执行
	 */
	@Override
	public Object getModel() {
		prepareDto();
		return this.dto;
	}

	/**
	 * 这个方法很重要，对IDTO进行封装
	 */
	private void prepareDto() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		HttpServletRequest rq = ServletActionContext.getRequest();
		String queryString = rq.getQueryString();
		/**
		 * 获取传入的参数键值对，通过HttpServletRequest.getAttributeNames()方法获取
		 * 
		 */
		Enumeration attrNames = rq.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String key = (String) attrNames.nextElement();
			data.put(key, rq.getAttribute(key));
		}
		/**
		 * 如果session不为空，那么吧session也放到data里，然后data放到dto中
		 */
		Map<String, Object> sessionAttr = ServletActionContext.getContext()
				.getSession();
		if (sessionAttr != null) {
			data.putAll(sessionAttr);
		}
		this.dto.setData(data);
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
}
