package com.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
/**
 * Ajax的工具类AjaxUtils，使用struts返回Json类型
 * 地址：http://www.open-open.com/code/view/1426849108648 
 * @author Wei
 * 下午09:43:31 2016-9-1
 */
public class AjaxUtil {

	/**
	 * ajax response method<br/>
	 * 如果出现异常，则返回错误代码505
	 * 
	 * @param response
	 * @param text
	 *            ajax返回的内容
	 * 
	 */
	public static void ajaxResponse(HttpServletResponse response, String text) {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <pre>
	 * 注意：ajax请求必须携带：jsonnp请求callback 
	 *  
	 * eg: 
	 * $.getJSON(path + "ajax/news/comment.go?newsId=" + newsId + "&content=" +content+ "&callback=?", function(data) { 
	 *   alert(data['val']); 
	 * });
	 * 
	 * </pre>
	 * 
	 * @param response
	 * @param msg
	 */
	public static void jsonnpResponse(HttpServletResponse response,
			String callback, String msg) {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(callback + "(" + msg + ")");
		} catch (IOException e) {

		}
	}

	/**
	 * 异常操作，需要浏览器地址返回上一步
	 * 
	 * @param response
	 * @param alertMsg
	 *            弹出提示信息
	 */
	public static void ajaxResponseRollBack(HttpServletResponse response,
			String msg) {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(
					"<script type='text/javascript'>alert('" + msg
							+ "');window.history.back();</script>");
		} catch (IOException e) {
			// LogConsoleUtil.write(Common.class, "ajaxResponseRollBack()",
			// e.getMessage());
		}
	}

	// ajaxJSON返回
	public static void ajaxJSONResponse(HttpServletResponse response,
			String str, Object object) {
		response.setContentType("text/json;charset=utf-8");
		JSONObject json = new JSONObject();
		json.put(str, object);
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ajaxResponseAlert(HttpServletResponse response,
			String msg) {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(
					"<script type='text/javascript'>alert('" + msg
							+ "');</script>");
		} catch (IOException e) {
			// LogConsoleUtil.write(Common.class, "ajaxResponseRollBack()",
			// e.getMessage());
		}
	}

	public static Integer StringToInteger(HttpServletRequest request,
			String name) {
		String obj = request.getParameter(name);
		Integer result = -1;
		if (obj != null) {
			result = Integer.parseInt(obj);
		}
		return result;
	}

}