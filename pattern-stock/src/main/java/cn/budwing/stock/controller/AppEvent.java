package cn.budwing.stock.controller;


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
}
