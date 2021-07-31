package cn.budwing.stock.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import cn.budwing.stock.controller.AppEvent;

public class MainToolBar extends View {
	private JButton viewOngoingBtn;
	private JButton addBuyingBtn;

	public Object buildView() {
		viewOngoingBtn = new JButton("查看");
		addBuyingBtn = new JButton("买入");  
		JToolBar view = new JToolBar();
		addBuyingBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				showAddBuying();
			}
			
		});
		view.setBackground(new Color(210, 240, 200));
		view.add(viewOngoingBtn);
		view.add(addBuyingBtn);
		
		return view;
	}
	
	public void showAddBuying() {
		controller.publishEvent(new AppEvent(this, "ShowAddBuying"));
	}
}
