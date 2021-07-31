package cn.budwing.stock.view;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.budwing.stock.controller.AppEvent;
import cn.budwing.stock.vo.Buying;

public class BuyingTable extends View {
	private JTable table;

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public Object buildView() {
		table = createTable();
		return new JScrollPane(table);
	}

	private JTable createTable() {
		AppEvent event = new AppEvent(this, "GetOnGoingBuying");
		controller.publishEvent(event);

		return new JTable(new BuyingTableModel((List<Buying>) event.getData()));
	}
}
