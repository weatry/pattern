package cn.budwing.stock.view;

import javax.swing.JFrame;

import cn.budwing.stock.util.ViewUtil;

public class MainView extends View {

	public Object buildView() {
		JFrame view = new JFrame();
		view.setSize(initWidth, initHeight);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setLocation(ViewUtil.getScreenCentral(initWidth, initHeight));
		view.setTitle("交易管理");
		
		return view;
	}

}
