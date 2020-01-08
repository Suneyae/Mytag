package com.test.mybatis.service;

import java.io.IOException;
import java.util.List;

import com.test.mybatis.dao.MyUserDao;

public class MaintainService {
	/**
	 * 单条删除
	 * 
	 * @throws IOException
	 */
	public int delete(String id) throws IOException {
		if (id != null && !"".equals(id)) {
			MyUserDao dao = new MyUserDao();
			return dao.delete(Integer.valueOf(id));
		}
		return 0;
	}

	/**
	 * 批量删除
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public int deleteBatch(List<String> id) throws IOException {
		int num = 0;
		if (id != null && !"".equals(id)) {
			int len = id.size();
			for (int i = 0; i < len; i++) {
				MyUserDao dao = new MyUserDao();
				num += dao.delete(Integer.valueOf(id.get(i)));
			}
			return num;
		}
		return 0;
	}
}
