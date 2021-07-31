package cn.budwing.stock.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import cn.budwing.stock.dao.BuyingDao;
import cn.budwing.stock.vo.Buying;

public class BuyingDaoImpl extends BaseDaoImpl implements BuyingDao {

	public List<Buying> selectOngoing() {
		return getHibernateTemplate().execute(new HibernateCallback<List<Buying>>() {

			public List<Buying> doInHibernate(Session session)
					throws HibernateException {
				return session.createQuery("from Buying").list();
			}
			
		});
	}

}
