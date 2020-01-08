package com.log.control;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.log.entity.MyGlt;
import com.log.entity.User4;

public class UserDao {
//	private SessionFactory sessionFactory;
//	private Session session;
//	private Transaction transaction;
	
	public SessionFactory sessionFactory;
	public Session session;
	public Transaction transaction;

//	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

//	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

//	@Test
	public void testInsert() {
		UserDao dao = new UserDao();
		dao.init();
		for (int i = 43; i < 64; i++) {
			dao.session
					.save(new User4(55, "xiaohong" + i, "qq" + i + "@163.com", new Date(System.currentTimeMillis())));
		}
		dao.destroy();
	}
	
	@Test
	public void testInsertglt() {
		UserDao dao = new UserDao();
		dao.init();
		for (int i = 1; i < 64; i++) {
			dao.session
					.save(new MyGlt(i,"wyl_glt"+i,"我是多记录表标题"+i,"姓名|邮件|日期","select username,email,datetime from user4"));
		}
		dao.destroy();
	}
}
