package cn.budwing.stock.controller;

import java.util.List;

import cn.budwing.stock.dao.BaseDao;
import cn.budwing.stock.view.View;

public abstract class Controller {
	protected View view;
	protected Object model;
	protected Controller parent;
	protected List<Controller> children;

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	public Controller getParent() {
		return parent;
	}

	public void setParent(Controller parent) {
		this.parent = parent;
	}

	public List<Controller> getChildren() {
		return children;
	}

	public void setChildren(List<Controller> children) {
		this.children = children;
	}

	/**
	 * 从根结点开始，向所有子结点发布事件
	 * @param event
	 */
	public void publishEvent(AppEvent event) {
		Controller root = getRoot();
		root.sendEvent(event);
	}
	
	private void sendEvent(AppEvent event) {

		if (!handleEvent(event)) {
			if (children != null && !children.isEmpty()) {
				for (Controller c : children) {
					c.sendEvent(event);
				}
			}
		}
	}

	private Controller getRoot() {
		if (parent != null) {
			return parent.getRoot();
		}

		return this;
	}
	
	public abstract boolean handleEvent(AppEvent event);
	public abstract Object buildView();
}
