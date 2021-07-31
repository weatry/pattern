package cn.budwing.stock.dao.test;

import java.io.Serializable;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.budwing.stock.dao.StockDao;
import cn.budwing.stock.vo.Stock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestStockDao {
	@Autowired
	StockDao stockDao;

	@Test
	@Transactional
	@Rollback(false)
	public void test() {
		Stock s = new Stock();
		Serializable id = stockDao.insert(s);
		Stock s1 = (Stock)stockDao.selectByPK(id);
		
		Assert.assertEquals(id, s1.getId());
	}
}

