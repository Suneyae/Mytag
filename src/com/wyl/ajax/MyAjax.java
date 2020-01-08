package com.wyl.ajax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;


import com.sxt.test.TestAction;
import com.test.javaAPI.json.UtilJackson;
import com.test.json.JsonTest;
import com.util.Pub;
import com.util.Pub2;

public class MyAjax {
	private InputStream inputStream;

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public InputStream getInputStream() {
//		return new ByteArrayInputStream(inputStream.getBytes());
		return this.inputStream;
	}

	// 用于wylAJax.js中的传参，
	private String parameters;

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
	@SuppressWarnings("all")
	public String myAjax() throws Exception {
		System.out.println("MyAjax.myAjax()...,parameters:" + this.parameters);

		Map map = new HashMap<String, Object>();
		map = JsonObjTest.StringToMap(this.parameters);
		BeanService bean = JsonObjTest.StringToMapByJacksonall(parameters);
		System.out.println("myAjax():" + map);
		// 获取java类名
		String mservice = ((String) map.get("\"serviceId\"")).replace("\"", "");
		// 获取方法名
		String mmethod = ((String) map.get("\"method\"")).replace("\"", "");
		// 获取service实例，也就是获取javabean
		Object obj = Pub.getBeanCtx().getBean(mservice);
		Class cls = obj.getClass();
		// 获取具体的方法
		Method method = cls.getMethod(mmethod, new Class[] {});
		Object obj2 = method.invoke(obj, new Object[] {});
		Map<Object, Object> actionResult = new HashMap();
		actionResult.put("RTN", 2343);
		actionResult.put("FHZ", "1");
		System.out.println("obj2:" + obj2);
		System.out.println("====myAjax()....=======");
//		StringBuffer rstString = new JSONUtilities(1).parseObject(actionResult);
//		this.inputStream = new ByteArrayInputStream(rstString.toString().getBytes());
		System.out.println("MyAjax.java 的 myAjax()方法，UtilJackson.mapToJson(actionResult)："+UtilJackson.mapToJson(actionResult));
		StringBuffer rstString = new StringBuffer(UtilJackson.mapToJson(actionResult));
		this.inputStream = new ByteArrayInputStream(rstString.toString().getBytes());
		return "success";
	}

}
