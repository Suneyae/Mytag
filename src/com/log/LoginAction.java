package com.log;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.log.entity.User;
import com.log.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.UtilTime;

/**
 * 普通的登陆
 * 
 * @author Wei
 * 
 */
public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService uService = new UserService();
	private String error;

	public String getEror() {
		return error;
	}

	public void setEror(String error) {
		this.error = error;
	}

	public UserService getuService() {
		return uService;
	}

	public void setuService(UserService uService) {
		this.uService = uService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		/**
		 * 账号密码：wyl,1234
		 */
		if (uService.login(user)) {
			ActionContext atx = ActionContext.getContext();
			Map<String, Object> session = atx.getSession();
			//对应于 WylInterceptor.java拦截器，这个拦截器里需要用到
			session.put("currentUser", user);
			//用来设置登录超时的参数
			session.put("lastTime", UtilTime.getCurTime());
			return SUCCESS;
		} else {
//			this.error = "error";
//			return this.error;
			HttpServletResponse  resp = ServletActionContext.getResponse();
			//不加 resp.setContentType("text/html;charset=UTF-8"); 会出现页面的中文为乱码的情况
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out  = resp.getWriter();
			out.println("账号："+user.getUserName()+",<br/>密码："+user.getPassWord()+"  的不正确，请确认");
//			out.println("<br/><input type=\"button\" value=\"点我\" />");
			out.println("<a href=\"login.jsp\" style=\"color:orange;\">点我重新登陆</a>");
			/**
			 * 测试Struts2中ActionContext.getContext().getSession()获取到session(这个实际上是Mapper)和Servlet中获取到的session(这个实际上是HttpSession)的差别
			 * 下面的Map<String, Object> session = atx.getSession();为了演示获取到的session(实际上是Mapper，Struts2框架做了封装)
			 */
			ActionContext atx = ActionContext.getContext();
			Map<String, Object> session = atx.getSession();
			Set<String> set = session.keySet();
			Iterator<String> it =  set.iterator();
			while(it.hasNext()){
				String key = it.next();
				String val = (String) session.get(key);
				System.out.println("key:"+key+",value:"+val);
			}
			//什么都不返回，直接用HttpServletResponse在网页上写提示
			return null;
		}
	}
}
