package cn.budwing.stock.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.budwing.stock.vo.Buying;

public class BuyingTableModel extends AbstractTableModel {
	private List<Buying> buyings;
	private Object[] headers = new Object[] { "序号", "股票代码", "股票名称", "买入价格",
			"买入数量", "止损价格", "止盈价格", "持有时间", "购入日期" };
	private Object[][] data;
	

	public BuyingTableModel(List<Buying> buyings) {
		super();
		this.buyings = buyings;
		
		data = new Object[buyings.size()][];
		for (int i = 0; i < buyings.size(); i++) {
			data[i] = new Object[] { i + 1, buyings.get(i).getStockCode(),
					buyings.get(i).getStockName(), buyings.get(i).getPrice(),
					buyings.get(i).getAmount(), buyings.get(i).getLossPrice(),
					buyings.get(i).getTargetPrice(),
					buyings.get(i).getHoldDays(), buyings.get(i).getDate()};
		}
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return buyings.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return headers[column].toString();
	}

	public Buying getBuying(int rowIndex) {
		return buyings.get(rowIndex);
	}
	
	public List<Buying> getBuyings(int[] rows) {
		List<Buying> results = new ArrayList<Buying>(rows.length);
		for (int i = 0; i < rows.length; i++) {
			results.add(this.buyings.get(rows[i]));
		}
		return results;
	}

}
