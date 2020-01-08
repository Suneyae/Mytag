package com.test.mybatis.dao.interf;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
/**
 * 通过实现接口 org.apache.ibatis.mapping.DatabaseIdProvider 
 * 并在 mybatis-config.xml 中注册来构建自己的 DatabaseIdProvider
 * 参见官方教程：
 * http://www.mybatis.org/mybatis-3/zh/configuration.html#databaseIdProvider
 * 
 * @author Wei
 * @time  2017年4月5日 上午9:47:42
 */
public class DBinit implements DatabaseIdProvider {

	public DBinit() {
		
	}

	@Override
	public void setProperties(Properties p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDatabaseId(DataSource dataSource) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
