package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wyl.util.DBConnUtil;

import oracle.sql.CLOB;

/**
 * 数据库字符对象工具类，包括clob的转换等
 * 
 * @author Wei
 * @time 2016年9月18日 上午10:56:49
 */
public class DataBaseCharUtil {
	/**
	 * 私有化构造方法，以阻止外部进行实例化
	 */
	private DataBaseCharUtil() {

	}

	/**
	 * 静态工具方法，将字CLOB转成STRING类型 关键在于把传入的CLOB对象转换成 java.io.Reader , 通过
	 * oracle.sql.CLOB.getCharacterStream()方法可以实现
	 * 
	 * @param clob
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static String ClobToString(CLOB clob) throws SQLException, IOException {

		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		System.out.println("clob:" + reString);
		return reString;
	}

	public static String ClobToString2(CLOB clob) throws SQLException, IOException {

		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		System.out.println("clob:" + reString);
		return reString;
	}

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		Clob clob = null;
		Reader reader = null;
		StringBuffer sb = new StringBuffer();

		try {
			conn = DBConnUtil.getConn();
			String sql = getSql("clob_test", 3, true, null);
			sql = getSql("clob_test", 0, false, " id=5 ");
			System.out.println("sql-------:" + sql);
			prep = conn.prepareStatement(sql);
			rst = prep.executeQuery();
			if (rst.next()) {
				clob = rst.getClob("str");
				reader = clob.getCharacterStream();
				BufferedReader br = new BufferedReader(reader);
				String s = br.readLine();
				if (s != null) {
					sb.append(s);
					s = br.readLine();
				}
				// 关闭数据库资源
				boolean flag = DBConnUtil.closeConn(rst, prep, conn);
				System.out.println("获取到的clob对象为：" + sb.toString() + "是否成功关闭数据库资源：" + flag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 返回一个sql语句
	 * 
	 * @param tableName
	 *            表名
	 * @param idValue
	 *            id的字段值,
	 * @param flag
	 *            是否用id条件，如果为true，那么whereCls无效,但是的必须有字段id;如果为false,那么idValue无效,
	 *            就会使用whereCls作为条件,
	 * @param whereCls
	 * @return
	 */
	private static String getSql(String tableName, int idValue, boolean flag, String whereCls) {
		String sql = "select * from " + tableName;
		if (flag) {
			sql += " where id=" + idValue;
		} else {
			sql += " where " + whereCls;
		}
		return sql;
	}

}
