package com.test.javaAPI.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

/**
 * 微信公众号的访问地址
 * 
 * @author Wei
 * @time 2016年10月13日 下午9:17:02
 */
public class WechatServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter out = resp.getWriter();
		try {
			Map<String, String> map = MessageUtil.xmlToMap(req);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");

			String message = null;
			if ("text".equals(msgType)) { // 对文本消息进行处理
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName); // 发送和回复是反向的
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime() + "");
				text.setContent("你发送的消息是：" + content);
				message = MessageUtil.textMessageToXml(text);
				System.out.println(message);
			}
			out.print(message); // 将回应发送给微信服务器
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 微信公众号的入口地址，在这里 千万注意不能调用父类的 的doGet(req,resp)方法， 否则会报错，400的错误 HTTP
		 * Status 400 - HTTP method GET is not supported by this URL
		 */

		// super.doGet(req, resp);
		String query = req.getQueryString();
		System.out.println("query:" + query);

		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		System.out.println(
				"signature:" + signature + ",timestamp:" + timestamp + ",nonce:" + nonce + ",echostr:" + echostr);
		PrintWriter out = resp.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			System.out.println("echostr:" + echostr);
			// out.print(echostr); // 校验通过，原样返回echostr参数内容
			out.write(echostr);
		}
	}

}