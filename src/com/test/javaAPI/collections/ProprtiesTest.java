package com.test.javaAPI.collections;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import org.junit.Test;
import org.springframework.core.io.support.PropertiesLoaderSupport;

import sun.util.spi.XmlPropertiesProvider;

/**
 * 见：尚学堂131课， Hashtable,和HashMap的使用类似，区别 一 Hashtable与HashMap的区别(面试题) 1
 * Hashtable线程安全，同步，效率相对低下 HashMap线程不安全，非同步，效率相对高 2
 * 父类不同，Hashtable的父类是Dictionary，HashMap的父类是Abstractmap 3
 * null:Hashtable的键和值不能为null HashMap键最多一个是null，值可以多个null
 * 这里着重使用Properties，主要用于读取资源配置文件
 * 
 * @author Wei
 * @time 2016年10月1日 下午6:48:34
 */
public class ProprtiesTest {
	/*
	 * public static void main(String[] args) throws FileNotFoundException,
	 * IOException { Properties prop = new Properties();
	 * prop.setProperty("name", "weiyongle22"); prop.setProperty("sex", "male");
	 * System.out.println(prop.getProperty("name")); int r = new
	 * Random().nextInt(100); String fileName = "wyl" + r + ".properties";
	 * String xmlName = "wyl" + r + ".xml"; // 把properties写入到指定的文件中
	 * prop.store(new FileOutputStream(new File("C:/Users/Wei/Desktop/" +
	 * fileName)), "i am pinglun"); // 把properties读取到xml中 绝对路径 //
	 * prop.storeToXML(new FileOutputStream(new File("C:/Users/Wei/Desktop/" //
	 * + xmlName)), "我是注释啊", "UTF-8"); // 相对路径 以当前工程为根路径 prop.storeToXML(new
	 * FileOutputStream(new File("src/yonle.xml")), "我是注释啊,哈哈哈UUUU说是", "UTF-8");
	 * // prop.storeToXML(new FileOutputStream(new File("src/yonle.xml")),
	 * "我是注释啊,哈哈哈", "GBK"); // XmlPropertiesProvider p = loadProvider(); //
	 * p.store(prop, new FileOutputStream(new //
	 * File("C:/Users/Wei/Desktop"+"wyl.xxx")), "", "UTF-8"); // prop.store(new
	 * FileOutputStream(new File("src/wyl.properties")), "我是注释，不知道你能不能看到我");
	 * prop.store(new FileOutputStream(new File("src/wyl.properties")),
	 * "WO SHI ZHUSHI ,WEIYONGLE 20161204");
	 * 
	 * // test();
	 * 
	 * }
	 */

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		ProprtiesTest xx = new ProprtiesTest();
//		xx.testLoad();
		testProperites();
	}

	/**
	 * 测试从new File(String path)相对路径读取文件
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testLoad() throws FileNotFoundException, IOException {
		Properties p = new Properties();
		// 也是相对路径，不过这个相对路径是以项目名为相对路径的，即代表都是在MyTag这个工程下
		p.load(new FileInputStream(new File("src/yonle.xml")));
		p.load(new FileInputStream(new File("src/wyl.properties")));
		System.out.println("" + p.getProperty("name"));

	}

	/**
	 * 重要 .class.getResourceAsStream("类相对路径"),例子：
	 * ProprtiesTest.class.getResourceAsStream(
	 * "/com/test/javaAPI/collections/wyl.properties") 使用类相对路径读取配置文件
	 * 
	 * @throws IOException
	 */
	@Test
	public void testFromClass() throws IOException {
		Properties p = new Properties();
		// 这种情况用的比较多，以类相对路径获取配置文件,以 "/"为bin
		p.load(ProprtiesTest.class.getResourceAsStream("/com/test/javaAPI/collections/wyl.properties"));
		// 以 "" 为bin
		p.load(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/test/javaAPI/collections/wyl.properties"));
		String sex = p.getProperty("sex");
		System.out.println("sex:" + sex);
		System.out.println("abc:" + p.getProperty("abc"));
	}

	private static XmlPropertiesProvider loadProvider() {
		return AccessController.doPrivileged(new PrivilegedAction<XmlPropertiesProvider>() {
			public XmlPropertiesProvider run() {
				ClassLoader cl = ClassLoader.getSystemClassLoader();
				XmlPropertiesProvider provider = loadProviderFromProperty(cl);
				if (provider != null)
					return provider;
				provider = loadProviderAsService(cl);
				if (provider != null)
					return provider;
				return new jdk.internal.util.xml.BasicXmlPropertiesProvider();
			}
		});
	}

	private static XmlPropertiesProvider loadProviderAsService(ClassLoader cl) {
		Iterator<XmlPropertiesProvider> iterator = ServiceLoader.load(XmlPropertiesProvider.class, cl).iterator();
		return iterator.hasNext() ? iterator.next() : null;
	}

	private static XmlPropertiesProvider loadProviderFromProperty(ClassLoader cl) {
		String cn = System.getProperty("sun.util.spi.XmlPropertiesProvider");
		if (cn == null)
			return null;
		try {
			Class<?> c = Class.forName(cn, true, cl);
			return (XmlPropertiesProvider) c.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException x) {
			throw new ServiceConfigurationError(null, x);
		}
	}

	@Test
	public static void test() {
		char[] a = new char[6];
		a[0] = '\u00ff';
		System.out.println(a.toString());
	}

	/**
	 * 测试Propreteis
	 */
	public static Map testProperites() {
		InputStream ips = PropertiesLoaderSupport.class
				.getResourceAsStream("/com/test/javaAPI/collections/hh.properties");
		Properties props = new Properties();
		Map<String, Object> map = new HashMap<>();
		try {
			props.load(ips);
			Enumeration<Object> e = (Enumeration<Object>) props.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				map.put(key, props.getProperty(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(" com.test.javaAPI.collections.ProprtiesTest.testProperites()出现异常" + e.getMessage());
		}
		System.out.println("map:" + map);
		return map;
	}

}
