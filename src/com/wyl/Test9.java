package com.wyl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;
/**
 * 测试 连接错误
 * @author Wei
 *
 */
public class Test9 {
	public static void main(String[] args) {
		
		String rightids = "('150105')";

		String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.162.128.2)(PORT=1521))(LOAD_BALANCE=yes))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=ybrssck)))";

		Connection con;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, "dgsbkf_ggyw","hniiybsb");
			// 准备语句执行对象
			stmt = con.createStatement();
			String sql = " SELECT COUNT(1) FROM FW_OPERATOR2RIGHT WHERE AAE100 = '1' AND RIGHTID IN "
				+ rightids + " and AUTHTYPE ='1' AND OPERID =" + 10027723;
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				long cnt = rs.getInt(1);
				System.out.println("记录数:cnt = " + cnt + "xxxxxxxxxxxxxxxxxxx");
				if (cnt != 0) {
					System.out.println("");
				}
				rs.close();
				stmt.close();
				con.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Test
	public void test01(){
		DateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
		
		
		Long a = (Long)null;
		System.out.println("a:"+a);
	}
	
	
}
