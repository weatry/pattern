package cn.budwing.stock.controller;

public class AddBuyingController extends Controller {

	public Object buildView() {
		return view.buildView();
	}

	public boolean handleEvent(AppEvent event) {
		return event.handleEvent(this);
	}

}
