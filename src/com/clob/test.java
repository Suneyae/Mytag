package com.clob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wyl.util.DBConnUtil;

public class test {
	public static void main(String[] args) throws SQLException {
		DBConnUtil util = new DBConnUtil();
		Connection conn= util.getConn();
		PreparedStatement prep;
//		prep = conn.prepareStatement("create table wyl(id number(2),name varchar2(20))");
		prep = conn.prepareStatement("insert into wyl values (EMPLOYEES_SEQ.nextval,'sdwe')");
		prep.execute();
		prep.close();
		conn.close();
	}
}
