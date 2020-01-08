package com.clob; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.wyl.util.DBConnUtil;

import oracle.jdbc.driver.OracleDriver;
import oracle.sql.CLOB; 
/**
 * 测试插入clob对象到数据库
 * @author Wei
 * @time  2016年9月18日 上午10:43:11
 */
public class ClobTest { 
    String url = "jdbc:oracle:thin:@localhost:1521:orcl2"; 
    String user = "hr"; 
    String pwd = "hr"; 
    String text = "这是要插入到CLOB里面的数据"; 
    private DBConnUtil util = new DBConnUtil();
    /**
     * 把字符串以clob的形式插到表里
     * 注意：如果是私有的方法那么JUnit就没法实例化，也就没法执行
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void clobImport() throws ClassNotFoundException, SQLException { 
    	text = "i am the data to be inserted on 20160918 卫永乐";
    	DriverManager.registerDriver(new OracleDriver()); 
        Connection conn = DriverManager.getConnection(url, user, pwd);// 得到连接对象 
        String sql = "insert into clob_test(id,str) values ('8',?)";// 要执行的SQL语句 

        PreparedStatement stmt = conn.prepareStatement(sql);// 加载SQL语句 
        // PreparedStatement支持SQL带有问号？，可以动态替换？的内容。 
        Reader clobReader = new StringReader(text); // 将 text转成流形式 
        stmt.setCharacterStream(1, clobReader, text.length());// 替换sql语句中的？ 
        int num = stmt.executeUpdate();// 执行SQL 
        if (num > 0) { 
            System.out.println("-----------  ok"); 
        } else { 
            System.out.println("-----------  NO"); 
        } 
        stmt.close(); 
        conn.close(); 
    } 

    private void clobExport() throws ClassNotFoundException, SQLException, 
            IOException { 
        // TODO Auto-generated method stub 
        CLOB clob = null; 
        String sql = "select * from clob_test where id=2"; 
//        DriverManager.registerDriver(new OracleDriver()); 
//        Connection conn = DriverManager.getConnection(url, user, pwd);// 得到连接对象 
        Connection conn = util.getConn();
        PreparedStatement stmt = conn.prepareStatement(sql); 
        ResultSet rs = stmt.executeQuery(); 
        String id = ""; 
        String content = ""; 
        if (rs.next()) { 
            id = rs.getString("id");// 获得ID 
            clob = (oracle.sql.CLOB) rs.getClob("str"); // 获得CLOB字段str 
            // 注释： 用 rs.getString("str")无法得到 数据 ，返回的 是 NULL; 
            content = ClobToString(clob); 
            CharSequence ch1 = "style=\"PADDING-LEFT: 70px\"";
            CharSequence ch2 = "style=\"PADDING-LEFT: 70px\" algin=\"centerwyl\"";
            ch1 = "微软";
            ch2 = "微软软";
            if(content.contains("style=\"PADDING-LEFT: 70px\"")){
            	System.out.println("包含1");
//            	content.replace("style=\"PADDING-LEFT: 70px\"", "style=\"PADDING-LEFT: 70px\" algin=\"centerwyl\"");
//            	content.replaceAll("style=\"PADDING-LEFT: 70px\"", "weiyongle");
            	content.replace(ch1, ch2);
            	System.out.println("包含2");
            }else{
            	System.out.println("不包含");
            }
        } 
        stmt.close(); 
        conn.close(); 
        // 输出结果 
//        if(content.contains("style=\"PADDING-LEFT: 70px\"")){
        
        System.out.println(id); 
        System.out.println("clobExport():"+content); 
    } 

    // 将字CLOB转成STRING类型 
    public String ClobToString(CLOB clob) throws SQLException, IOException { 

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
        System.out.println("clob:"+reString);
        return reString; 
    } 

    
    // TODO Auto-generated method stub 
    public static void main(String[] args) throws IOException, 
            ClassNotFoundException, SQLException { 
        // TODO Auto-generated method stub 
        ClobTest clobtest = new ClobTest(); 
//        clobtest.clobExport();
        clobtest.clobImport();
//        // read file 
//        FileReader _frd = new FileReader(new File("D:\\AA.txt")); 
//        BufferedReader _brd = new BufferedReader(_frd); 
//        String _rs = _brd.readLine(); 
//        StringBuffer _input = new StringBuffer(); 
//        while (_rs != null) { 
//            _input.append(_rs); 
//            _rs = _brd.readLine(); 
//        } 
//        // System.out.println(_input.toString()); 
//        // 输入测试 
//        clobtest.text = _input.toString(); 
//        clobtest.clobImport(); 
        // 输出测试 
        // clobtest.clobExport(); 
//        String a = "zhangyalan";
//        String b = a.replaceAll("y", "8");
//        System.out.println("b:"+b);
    } 
    
    
}