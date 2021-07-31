package cn.budwing.stock.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import cn.budwing.stock.controller.AppEvent;

public class OperationToolBar extends View {
	private JButton delBtn;
	private JButton editBtn;
	private JButton sellBtn;

	public Object buildView() {
		delBtn = new JButton("删除");  
		editBtn = new JButton("修改"); 
		sellBtn = new JButton("卖出"); 
		
		JToolBar view = new JToolBar();
		delBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				delBuying();
			}
			
		});
		view.setBackground(new Color(240, 220, 200));
		view.add(sellBtn);
		view.add(editBtn);
		view.add(delBtn);
		
		return view;
	}
	
	public void delBuying() {
		controller.publishEvent(new AppEvent(this, "DelBuying"));
		controller.publishEvent(new AppEvent(this, "RepaintMain"));
	}
	
	public void editBtn() {
		//controller.publishEvent(new ShowEditBuyingEvent());
	}
}
