package cn.budwing.stock.controller;

import java.util.List;

import cn.budwing.stock.dao.BuyingDao;
import cn.budwing.stock.view.BuyingTable;
import cn.budwing.stock.view.BuyingTableModel;
import cn.budwing.stock.vo.Buying;

public class AppEvent {
	protected Object source;
	protected Object data;
	protected String msg;

	public AppEvent(Object source) {
		this.source = source;
	}

	public AppEvent(Object source, String msg) {
		super();
		this.source = source;
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean handleEvent(Controller controller) {
		if(getMsg().equals("AddBuying")) {
			BuyingDao dao = (BuyingDao) controller.getModel();
			dao.insert(getData());
			return true;
		} else if ("ShowAddBuying".equals(getMsg())) {
			controller.getView().buildView();
			return true;
		} else if("GetOnGoingBuying".equals(getMsg())) {
			BuyingDao buyingDao = (BuyingDao)controller.getModel();
			setData(buyingDao.selectOngoing());
			return true;
		} else if ("DelBuying".equals(getMsg())) {
			BuyingDao dao = (BuyingDao) controller.getModel();
			BuyingTable bt = (BuyingTable) controller.getView();
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
		} else if("RepaintMain".equals(getMsg())) {
			controller.buildView();
			return true;
		}
		
		return false;
	}

}
