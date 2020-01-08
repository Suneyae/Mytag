package com.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日记类
 * @author Wei
 * @time  2016年9月28日 下午5:05:45
 */
public class LoggerRequest {
	public static boolean log(String diary) {
//		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Long time= Long.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String sql = "insert into mylog(req,aae036) values('" + diary + "','"+time+"')";
		System.out.println("sql:"+sql);
//		Connection conn = DBConnUtil.getConnBySpring();
		Connection conn = null;
		try {
			conn = DBConnUtil.getConn();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Boolean flag = false;
		try {
			Statement stat = conn.createStatement();
			flag = stat.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static void main(String[] args) {
		LoggerRequest.log("sdfsd");
	}
}
