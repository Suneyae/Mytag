package com.test.mybatis.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.test.mybatis.util.UtilDBbyMyBatis;

public class MyUserDao {
	SqlSession sqlSession ;
	
	{
		try {
			sqlSession = new UtilDBbyMyBatis().GetSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public int delete(int id) throws IOException {
		SqlSession sqlSession = new UtilDBbyMyBatis().GetSqlSession();
		int num = sqlSession.delete("MyUser22.deleteOne", id);
		//一定要加上这个提交，因为mybatis做了封装后默认为不自动提交
		sqlSession.commit();
		return num;
	}
	
	
	
	
}
