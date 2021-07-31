package cn.budwing.stock.controller;

import java.util.List;

import cn.budwing.stock.dao.BuyingDao;
import cn.budwing.stock.view.BuyingTable;
import cn.budwing.stock.view.BuyingTableModel;
import cn.budwing.stock.vo.Buying;

public class BuyingTableController extends Controller {
	public Object buildView() {
		return view.buildView();
	}

	@Override
	public boolean handleEvent(AppEvent event) {
		if("GetOnGoingBuying".equals(event.getMsg())) {
			BuyingDao buyingDao = (BuyingDao)getModel();
			event.setData(buyingDao.selectOngoing());
			return true;
		} else if ("DelBuying".equals(event.getMsg())) {
			BuyingDao dao = (BuyingDao) getModel();
			BuyingTable bt = (BuyingTable) getView();
			BuyingTableModel model = (BuyingTableModel) bt.getTable()
					.getModel();

			int[] selection = bt.getTable().getSelectedRows();
			if (selection!=null && selection.length>0) {
				for (int i = 0; i < selection.length; i++) {
					selection[i] = bt.getTable().convertRowIndexToModel(
							selection[i]);
				}
				List<Buying> buyingToDel = model.getBuyings(selection);
				dao.delete(buyingToDel);
			}
			return true;
		} 
		
		return false;
	}
}
