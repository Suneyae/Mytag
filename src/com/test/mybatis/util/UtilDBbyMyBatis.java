package com.test.mybatis.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 数据库连接工具类(MyBatis框架相关)
 * 
 * @author Wei
 * @time 2016年11月6日 下午5:08:33
 */
public class UtilDBbyMyBatis {
	public static SqlSession sqlsssion;
	public static String PATH_CONFIG = "com/test/mybatis/config/Configuration.xml";
	/**
	 * 获取SqlSession
	 * 
	 * @return
	 * @throws IOException
	 */
	public static SqlSession GetSqlSession() throws IOException {
		if (null != sqlsssion) {
			return sqlsssion;
		} else {
			//Resources.getResourcesAsStream("xxx");这个是以src为根目录的
			InputStream ips = Resources.getResourceAsStream("com/test/mybatis/config/Configuration.xml");
			// 获取SqlSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ips);
			sqlsssion = factory.openSession();
			return sqlsssion;
		}

	}
	
	
	public static SqlSession getSqlSession() throws IOException{
		InputStream ips = Resources.getResourceAsStream(PATH_CONFIG);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ips);
		return factory.openSession();
	}
	
	public static void main(String[] args) throws IOException {
		InputStream ips = Resources.getResourceAsStream(PATH_CONFIG);
		new SqlSessionFactoryBuilder().build(ips, "");
		
		
	}
	
	
}
