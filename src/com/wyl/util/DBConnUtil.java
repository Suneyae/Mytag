package com.wyl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.util.Pub;

import oracle.jdbc.driver.OracleDriver;
/**
 * 数据库连接工具类
 * @author Wei
 * @time  2016年9月18日 下午9:07:12
 */
@Component(value = "dBConnUtil")
public class DBConnUtil {
	static Connection conn;
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl2";
	static String user = "hr";
	static String pwd = "hr";
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("DBConnUtil.getConn()....,获取到了链接conn");
		return conn;
	}

	public Connection getConnBySpring() {
		// 获取到数据源
		ComboPooledDataSource ds = (ComboPooledDataSource) Pub.getBeanCtx().getBean("dataSource");
		// 可以用批量操作sql
		@SuppressWarnings("unused")
		JdbcTemplate jdbcTemplate = (JdbcTemplate) Pub.getBeanCtx().getBean("jdbcTemplate");
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			System.out.println("com.wyl.util.DBConnUtil.getConnBySpring(),获取数据库连接失败...");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库资源
	 * 
	 * @param rst
	 * @param prep
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public static boolean closeConn(ResultSet rst, PreparedStatement prep, Connection conn) throws SQLException {
		boolean flag = false;
		if (rst != null) {
			rst.close();
		}
		if (prep != null) {
			prep.close();
		}
		if (conn != null) {
			conn.close();
			flag = true;
		}
		return flag;
	}

}
