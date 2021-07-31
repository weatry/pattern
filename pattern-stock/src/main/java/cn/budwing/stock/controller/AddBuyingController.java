package cn.budwing.stock.controller;

import cn.budwing.stock.dao.BuyingDao;

public class AddBuyingController extends Controller {

	public Object buildView() {
		return view.buildView();
	}

	@Override
	public boolean handleEvent(AppEvent event) {
		if(event.getMsg().equals("AddBuying")) {
			BuyingDao dao = (BuyingDao) getModel();
			dao.insert(event.getData());
			return true;
		} else if ("ShowAddBuying".equals(event.getMsg())) {
			getView().buildView();
			return true;
		}
		
		return false;
	}

}
