package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;
/**
 * 封装Properties类的相关操作
 * @author Wei
 * @time  2016年9月28日 下午4:45:40
 */
public class UtilProprerties {
	/**
	 * 默认的配置文件地址
	 */
	public static String PATH_DB_PROPERTIES = "src/db.properties";
	/**
	 * 私有化构造器，不让外界实例化
	 */
	private UtilProprerties(){
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, WylException {
		InputStream ips = getResourceAsInputStream(PATH_DB_PROPERTIES);
	}
	
	
//	public static 
	public static final Properties glo_prop = new Properties();
	
	/**
	 * 读取配置文件(如：properties格式的)，然后返回输入流
	 * @param resoucePath
	 * @return 返回InputStream
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws WylException
	 */
	@SuppressWarnings("unused")
	public static InputStream getResourceAsInputStream(String resoucePath) throws IOException, FileNotFoundException, WylException {
//		InputStream ips = new FileInputStream("src/db.properties");
		InputStream ips = new FileInputStream(resoucePath);
		if(null==ips){
			throw new WylException("读取文件："+resoucePath+"失败!");
		}
		return ips;
	}
	@Test
	public void getResource(){
		URL url = UtilProprerties.class.getResource("/db.properties");
		System.out.println("-----"+url);
	}
	/**
	 * 测试用
	 * @param resoucePath
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws WylException
	 */
	public static void getResourceAsInputStream2(String resoucePath) throws IOException, FileNotFoundException, WylException {
		String path = "/db.properties";
		Properties prop = new Properties();
		prop.getProperty("");
		prop.load(new FileInputStream("src/db.properties"));
		String userName = (String) prop.get("jdbc.username");
		System.out.println(userName+"---------");
		//1 通过getResourceAsStream读取配置文件,可以正确读取
		InputStream ips = UtilProprerties.class.getResourceAsStream("/db.properties");
		ips = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		if(ips==null){
			ips = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		}
		if(ips==null){
			throw new WylException("读取配置文件失败了...");
		}
		
		
		glo_prop.load(ips);
		String username = glo_prop.getProperty("jdbc.username");
		System.out.println("userName:"+username);
	}
}
