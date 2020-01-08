package actions.motai;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OpenAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
//		java.net.URLDecoder.decode(s, enc)
		HttpServletRequest reqeust = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String theParas  = (String) reqeust.getParameter("thePara");
		Map session = ActionContext.getContext().getSession();
		session.put("thePara", theParas);
		System.out.println("传入的参数为："+theParas);
		return SUCCESS;
	}
	
	
	public String totest() throws IOException{
		HttpServletResponse  resp = ServletActionContext.getResponse();
		PrintWriter out  = resp.getWriter();
		out.print("xxdfsdfa");
		return null;
	}
}
