package cn.budwing.stock.view;

import cn.budwing.stock.controller.Controller;

public abstract class View {
	protected int initHeight;
	protected int initWidth;
	protected Controller controller;

	public int getInitHeight() {
		return initHeight;
	}

	public void setInitHeight(int initHeight) {
		this.initHeight = initHeight;
	}

	public int getInitWidth() {
		return initWidth;
	}

	public void setInitWidth(int initWidth) {
		this.initWidth = initWidth;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public abstract Object buildView();
}
