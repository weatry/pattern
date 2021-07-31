package cn.budwing.stock.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import cn.budwing.stock.controller.AppEvent;
import cn.budwing.stock.util.ViewUtil;
import cn.budwing.stock.vo.Buying;

public class AddBuyingView extends View {
	private BuyingForm form = null;
	
	public Object buildView() {
		final JDialog view = new JDialog();
		JButton submit = new JButton("添加");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
				view.dispose();
			}
		});
		
		form = new BuyingForm();
		form.init();
		
		view.setSize(initWidth, initHeight);
		view.setTitle("买入");
		view.add(form, BorderLayout.CENTER);
		view.add(submit, BorderLayout.SOUTH);
		view.setModal(true);
		view.pack();
		view.setLocation(ViewUtil.getScreenCentral((int)view.getSize().getWidth(), (int)view.getSize().getHeight()));
		view.setVisible(true);
		
		return view;
	}
	
	public void submit() {
		Buying b = form.toBuying();
		AppEvent event = new AppEvent(this, "AddBuying");
		event.setData(b);
		controller.publishEvent(event);
		controller.publishEvent(new AppEvent(this, "RepaintMain"));
	}
}
