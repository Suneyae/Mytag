package com.test.javaAPI.annotation.test;

import java.lang.reflect.Method;

/**
 * 参考： http://www.cnblogs.com/liangweiping/p/3837332.html 这是第3步：用“构造工厂”充当“注解解析器”
 * 
 * @author Wei
 * @time 2017年4月10日 下午4:43:46
 */
public class UserFactory {
	@SuppressWarnings("all")
	public static User create() {
		User user = new User();

		// 获取User类中所有的方法（getDeclaredMethods也行）
		Method[] methods = User.class.getMethods();
		
		try {
			for (Method method : methods) {
				// 如果此方法有注解，就把注解里面的数据赋值到user对象
				if (method.isAnnotationPresent(Init.class)) {
					Init init = method.getAnnotation(Init.class);
					String methodName = method.getName();
					if("setAge".equals(method.getName())){
						System.out.println("我是UserFactory.create()方法");
						method.invoke(user, init.value());
					}else if("setName".equals(method.getName())){
						method.invoke(user, init.value());
					}else if("setHeight".equals(method.getName())){
						method.invoke(user, init.valueInt());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}
	@SuppressWarnings("all")
	public static void main(String[] args) {
		UserFactory f = new UserFactory();
		f.create();
	}
}
