package com.test.mybatis.mybatistest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.test.mybatis.entity.EncryptedString;
import com.test.mybatis.entity.MyUser;
import com.test.mybatis.service.MaintainService;
import com.test.mybatis.util.UtilDBbyMyBatis;

/**
 * MyBatis测试类
 * 
 * @author Wei
 * @time 2016年11月6日 下午5:13:18
 */
public class MyBatisDemo02 {
	public static void main(String[] args) throws IOException {
		
		SqlSession sqlSession = UtilDBbyMyBatis.GetSqlSession();
		/*
		 * SqlSession.selectList(String str);里的str是根据实体类映射文件里的id来寻找的，
		 * 实际上框架内部是通过"命名空间.str"的形式来查找对应的sql语句的(这个命名空间就是
		 * 映射文件的namespace的值，具体到这个例子中就是<mapper namespace="MyUser22">)，比如
		 * sqlSession.selectList("queryMyUserList_wyl");这行代码，框架内部是根据
		 * sqlSession.selectList("MyUser22.queryMyUserList_wyl");来寻找的，
		 */
		List<MyUser> list = sqlSession.selectList("MyUser22.queryMyUserList_wyl");
		
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i).getUsername() + ",id=" + list.get(i).getId());
		}
		System.out.println("==============分割线==============");
		
	}
}
