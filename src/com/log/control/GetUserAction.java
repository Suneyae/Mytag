package com.log.control;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.log.entity.MyGlt;
import com.log.entity.User4;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.LoggerRequest;

/**
 * 用于从数据库获取数据
 * 
 * @author Wei
 * @time 2016年9月19日 上午12:45:39
 */
public class GetUserAction extends ActionSupport {
	protected Map<String,Object> dto;
	public GetUserAction(){
		dto = new HashMap<String, Object>();
		System.out.println("-----实例化GetUserAction对象------");
	}
	
	
	
	private User4 user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取json格式字符串
	 * 
	 * @param obj
	 * @return
	 */
	public String getJsonString(Object obj) {
		ObjectMapper om = new ObjectMapper();
		StringWriter sw = new StringWriter();
		try {
			JsonGenerator jg = new JsonFactory().createJsonGenerator(sw);
			om.writeValue(jg, obj);
			jg.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sw.toString();
	}

	/**
	 * 把从数据库获取到的数据 List<User4> list 写到页面上
	 * 
	 * @param obj
	 */
	public void writeJson(Object obj) {
		String json = getJsonString(obj);
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public String execute() throws Exception {
		// easyui-datagrid表格 点击下一页的时候 的参数 page=2&rows=11&sort=email&order=DESC
		HttpServletRequest req = ServletActionContext.getRequest();
		ActionContext ctx = ServletActionContext.getContext();
		//记录登陆日记
		LoggerRequest.log(req.getQueryString());
		Map session = ctx.getSession();
		this.dto.putAll(session);
		session.put("xx", "www");
		// System.out.println("---11111---page:"+req.getParameter("page"));
		// System.out.println("GetUserAction.java----------"+req.getQueryString());
		Enumeration e = req.getAttributeNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			this.dto.put(key,req.getAttribute(key));
		}
		
		UserDao dao = new UserDao();
		// 开启hibernate的transaction等
		dao.init();
		List<User4> list = new ArrayList<User4>();
		// 暂时这里只能根据rows来进行table页面的数据量的限定
		int rows = Integer.valueOf(req.getParameter("rows"));
		// int rows = 33;
		
		for (int i = 1; i < rows; i++) {
			// 通过hibernate从数据库获取数据，放到list中
			/**
			 * added by weiyongle 20160919 如果获取到的User4对象是null，那么就不放到list里，
			 * 否则转换后的json字符串里含有null，会导致easyui-datagrid无法解析
			 */
			if (null != dao.session.get(User4.class, i)) {
				list.add((User4) dao.session.get(User4.class, i));
			}
		}
		// 销毁hibernate相关的资源
		dao.destroy();
		// 写到页面上
		writeJson(list);
		return null;
	}

	public String getJsonData() {
		HttpServletRequest req = ServletActionContext.getRequest();
		// System.out.println("---11111---page:"+req.getParameter("page"));
		// System.out.println("GetUserAction.java----------"+req.getQueryString());
		UserDao dao = new UserDao();
		// 开启hibernate的transaction等
		dao.init();
		List<User4> list = new ArrayList<User4>();
		// 暂时这里只能根据rows来进行table页面的数据量的限定
		String int_ = req.getParameter("rows");
		int rows = 0;
		if(int_!=null){
			rows = Integer.valueOf(req.getParameter("rows"));
		}
		
		// int rows = 33;

		for (int i = 1; i < rows; i++) {
			// 通过hibernate从数据库获取数据，放到list中
			/**
			 * added by weiyongle 20160919 如果获取到的User4对象是null，那么就不放到list里，
			 * 否则转换后的json字符串里含有null，会导致easyui-datagrid无法解析
			 */
			if (null != dao.session.get(User4.class, i)) {
				list.add((User4) dao.session.get(User4.class, i));
			}
		}
		if(list.size()==0){
			list.add((User4) dao.session.get(User4.class, 3));
		}
		// 销毁hibernate相关的资源
		dao.destroy();
		// 写到页面上
		writeJson(list);
		return null;
	}
	/**
	 * 用于 http://localhost:8081/Mytag/getUser!getJsonData?id=90获取数据，也就是页面
	 * http://localhost:8081/Mytag/myeasyui_datagrid.jsp 的按钮 "获取json数据"发送的ajax请求
	 * @return
	 */
	public String getJsonData2() {
		HttpServletRequest req = ServletActionContext.getRequest();
		int id = Integer.valueOf(req.getParameter("id"));
		UserDao dao = new UserDao();
		dao.init();
		List<MyGlt> list = new ArrayList<MyGlt>();
		list.add((MyGlt) dao.session.get(MyGlt.class, id));
		dao.destroy();
		writeJson(list);
		return null;
	}
}
