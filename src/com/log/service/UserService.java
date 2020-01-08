package com.log.service;

import com.log.entity.User;

public class UserService {
	public boolean login(User user) {
		if ("wyl".equals(user.getUserName())
				&& "123".equals(user.getPassWord())) {
			return true;
		} else {
			return false;
		}
	}
}
