package cn.budwing.stock.dao;

import java.util.List;

import cn.budwing.stock.vo.Buying;

public interface BuyingDao extends BaseDao {
	public List<Buying> selectOngoing();
}
