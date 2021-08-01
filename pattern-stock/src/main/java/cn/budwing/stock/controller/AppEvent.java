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

	public boolean handleEvent(Controller addBuyingController) {
		if(getMsg().equals("AddBuying")) {
			BuyingDao dao = (BuyingDao) addBuyingController.getModel();
			dao.insert(getData());
			return true;
		} else if ("ShowAddBuying".equals(getMsg())) {
			addBuyingController.getView().buildView();
			return true;
		}
		
		return false;
	}

	public boolean handleEvent(BuyingTableController buyingTableController) {
		if("GetOnGoingBuying".equals(getMsg())) {
			BuyingDao buyingDao = (BuyingDao)buyingTableController.getModel();
			setData(buyingDao.selectOngoing());
			return true;
		} else if ("DelBuying".equals(getMsg())) {
			BuyingDao dao = (BuyingDao) buyingTableController.getModel();
			BuyingTable bt = (BuyingTable) buyingTableController.getView();
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

	public boolean handleEvent(MainController mainController) {
		if("RepaintMain".equals(getMsg())) {
			mainController.buildView();
			return true;
		}
		return false;
	}
}
