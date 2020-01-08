package com.test.mybatis.dao.interf;

import java.util.List;

import com.test.mybatis.entity.MyUser;

/**
 * MyBatis接口式编程Demo
 * @author Wei
 * @time  2017年3月23日 下午1:26:21
 */
public interface IMyUserDao {
	public MyUser getUser(int id);
	public MyUser getUserbyUser(MyUser user);
	public void deleteUser(String username);
	public MyUser getUserbyUser2(MyUser user);
	public int delBatch(List<Integer> list);
}
