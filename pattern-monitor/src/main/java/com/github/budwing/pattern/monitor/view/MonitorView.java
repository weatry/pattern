package com.github.budwing.pattern.monitor.view;

import com.github.budwing.pattern.monitor.service.BuyingService;
import com.github.budwing.pattern.monitor.service.QuotationService;
import com.github.budwing.pattern.monitor.vo.Buying;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MonitorView  {
	private JDialog view = new JDialog();
	private JLabel content = new JLabel();
	private BuyingService buyingService;
	private QuotationService quotationService;

	public JLabel getContent() {
		return content;
	}

	public void setContent(JLabel content) {
		this.content = content;
	}

	public BuyingService getBuyingService() {
		return buyingService;
	}

	public void setBuyingService(BuyingService buyingService) {
		this.buyingService = buyingService;
	}

	public QuotationService getQuotationService() {
		return quotationService;
	}

	public Object render() {
		view.setTitle("警告");
		view.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		view.add(content);
		view.setSize(400, 300);
		view.setLocation(ViewUtil.getScreenCentral(400, 300));
		view.validate();

		return view;
	}

	public void monitor() throws Exception {
		if (view.isVisible())
			return;
		List<Buying> buyings = buyingService.getNotFinished();
		if (buyings == null || buyings.size() == 0)
			return;

		quotationService.refresh(buyings);
		StringBuilder sb = new StringBuilder();
		for (Buying buying : buyings) {
			if (buying.getLossPrice() >= buying.getCurrentPrice()) {
				sb.append("<font color=red>").append(buying.getStockName())
						.append("当前价格是").append(buying.getCurrentPrice())
						.append("，已达到止损价").append(buying.getLossPrice())
						.append("，请即刻抛出！</font><br>");
			}
			if (buying.getTargetPrice() <= buying.getCurrentPrice()) {
				sb.append("<font color=green>").append(buying.getStockName())
						.append("当前价格是").append(buying.getCurrentPrice())
						.append("，已达到止盈价").append(buying.getTargetPrice())
						.append("，请即刻抛出！</font><br>");
			}
		}

		if (sb.length() > 0) {
			sb.insert(0, "<html>");
			content.setText(sb.toString());
			sb.append("</html>");
			view.setVisible(true);
		}
	}

}
