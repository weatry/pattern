package cn.budwing.stock.controller;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

import cn.budwing.stock.view.BuyingTable;
import cn.budwing.stock.view.MainToolBar;
import cn.budwing.stock.view.OperationToolBar;

public class MainController extends Controller {
	JFrame frame = null;
	public Object buildView() {
		if (frame==null) {
			frame = (JFrame)view.buildView();
		}
		if(children!=null) {
			frame.getContentPane().removeAll();
			
			for(Controller c:children) {
				if (c.view instanceof MainToolBar) {
					frame.add((Component)c.buildView(), BorderLayout.NORTH);
				} else if(c.view instanceof BuyingTable) {
					frame.add((Component)c.buildView(), BorderLayout.CENTER);
				} else if(c.view instanceof OperationToolBar) {
					frame.add((Component)c.buildView(), BorderLayout.SOUTH);
				}
			}
		}
		frame.validate();
		frame.setVisible(true);
		return frame;
	}
	@Override
	public boolean handleEvent(AppEvent event) {
		if("RepaintMain".equals(event.getMsg())) {
			this.buildView();
			return true;
		}
		return false;
	}
	
}
