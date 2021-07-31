package cn.budwing.stock.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {
	public Serializable insert(Object entity);
	public void delete(Object entity);
	public Object selectByPK(Serializable pk);
	public void update(Object entity);
	
	public void delete(List entitys);
}
