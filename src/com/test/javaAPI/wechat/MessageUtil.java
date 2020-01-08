package com.test.javaAPI.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

/**
 * 微信消息工具类
 * 
 * @author Wei
 * @time 2016年10月12日 下午10:45:44
 */
public class MessageUtil {
	/**
	 * xml转换为map
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
		Map<String, String> map = new HashMap<String, String>();

		SAXReader reader = new SAXReader();

		InputStream ins = request.getInputStream();

		Document doc = reader.read(ins);

		Element root = doc.getRootElement();

		List<Element> list = root.elements();
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		ins.close();

		return map;
	}

	/**
	 * text转换为 XML
	 * 
	 * @param msg
	 * @return
	 */
	public static String textMessageToXml(TextMessage msg) {
		XStream xstream = new XStream();
		return xstream.toXML(msg);
	}
}
