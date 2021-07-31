package cn.budwing.stock.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.budwing.stock.dao.BaseDao;

public abstract class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
	protected Class entityClass;

	public Class getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

	@Transactional
	public Serializable insert(Object entity) {
		return getHibernateTemplate().save(entity);
	}

	@Transactional
	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	@Transactional
	public void delete(List entitys) {
		for (Object entity:entitys) {
			getHibernateTemplate().delete(entity);
		}
	}

	public Object selectByPK(Serializable pk) {
		return getHibernateTemplate().get(entityClass, pk);
	}

	@Transactional
	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

}
