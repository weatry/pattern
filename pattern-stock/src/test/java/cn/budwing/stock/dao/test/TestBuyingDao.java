package cn.budwing.stock.dao.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.budwing.stock.dao.BuyingDao;
import cn.budwing.stock.vo.Buying;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestBuyingDao {
	@Autowired
	BuyingDao buyingDao;
	
	@Autowired
	SessionFactory factory;

	@Test
	public void test() {
		Session session = factory.openSession();
		
		session.createQuery("from Buying").list();
		
		session.close();
		
		session = factory.openSession();
		
		session.beginTransaction();
		Buying b = (Buying)session.get(Buying.class, "402880e44a22fe46014a22fe490b0000");
		System.out.println(b.getNotes());
		session.getTransaction().commit();
		
		session.close();
	}
	@Test
	public void testA() {
		
	}
}

