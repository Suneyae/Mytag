package com.test.mybatis.dao.interf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.test.mybatis.entity.MyUser;

/**
 * 接口式编程的测试类
 * @author Wei
 * @time  2017年3月23日 下午2:26:22
 */
public class IMyUserTest {

	public IMyUserTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		InputStream is = null;
		SqlSessionFactory factory = null;
		SqlSession sqlsession = null;
		try {
			is = Resources.getResourceAsStream("com/test/mybatis/config/Configuration.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
			sqlsession = factory.openSession();
			/**
			 * 获取接口，实际上是通过代理模式来获取的代理对象
			 * 1 首先要有一个namespace为接口的全类名的映射文件，该例中是 IMyUser.xml
			 * 2 然后在mybatis的容器(就是总的配置文件)里的mappers标签内
			 * 引入第1步中的映射文件，这里是 IMyUser.xml
			 * 3 通过SqlSession对象的getMapper(IMyUserDao.class)
			 * 获取一个接口的代理对象
			 * 4 调用代理对象的具体方法，也就是对应着 IMyUser.xml中的各个select,insert
			 * 等标签，这些标签的id属性同时必须与接口中的方法名一一对应
			 */
			IMyUserDao dao = sqlsession.getMapper(IMyUserDao.class);
			MyUser user = new MyUser();
			user.setUsername("weiyongle363");
//			user.setAdministrator("wyl");
			//调用接口的方法
//			user = dao.getUserbyUser(user);//正常
//			user = dao.getUserbyUser2(null);
			ArrayList<Integer> list = new ArrayList<>();
			list.add(13);
			list.add(352);
			dao.delBatch(list);//批量删除 使用 foreach标签
			sqlsession.commit();
//			user = dao.getUser(361);//正常运行
//			user = dao.getUser(355);
//			MyUser user = sqlsession.selectOne("com.test.mybatis.dao.interf.IMyUserDao.getUser",1);
			if(user!=null){
				System.out.println(user.toString());
			}else{
				System.out.println("没有查询到结果");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
