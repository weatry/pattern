package cn.budwing.stock.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import cn.budwing.stock.vo.Buying;

public class BuyingForm extends JPanel {
	private String[] fieldNames = new String[] {
			"股票代码","股票名称","买入价格","买入数量",
			"止损价格","止盈价格","持有时间","购入日期","购入说明"
	};

	public JTextField stockCodeField = new JTextField(6);
	public JTextField stockNameField = new JTextField(10);
	public JTextField buyPriceField = new JTextField(6);
	public JTextField buyAmountField = new JTextField(6);
	public JTextField lossPriceField = new JTextField(6);
	public JTextField targetPriceField = new JTextField(6);
	public JTextField maxHoldDaysField = new JTextField(6);
	public JDatePickerImpl buyDateField = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(new Date())));
	public JTextArea notesField = new JTextArea(10, 20);
	public JButton submit = new JButton("提交");

	public void init() {

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipadx = 4;
		c.ipady = 4;
		
		for (int i = 0; i < fieldNames.length; i++) {
			add(new JLabel(fieldNames[i]), c);
			c.gridy++;
		}

		c.gridx++;
		c.gridy = 0;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.WEST;
		
		add(stockCodeField, c);
		c.gridy++;
		add(stockNameField, c);
		c.gridy++;
		add(buyPriceField, c);
		c.gridy++;
		add(buyAmountField, c);
		c.gridy++;
		add(lossPriceField, c);
		c.gridy++;
		add(targetPriceField, c);
		c.gridy++;
		add(maxHoldDaysField, c);
		c.gridy++;
		add(buyDateField, c);
		c.gridy++;
		add(notesField, c);
	}
	
	public Buying toBuying() {
		return new Buying(
				stockCodeField.getText().trim(), 
				stockCodeField.getText().trim(), 
				stockNameField.getText().trim(), 
				((UtilDateModel)buyDateField.getModel()).getValue(), 
				Float.valueOf(buyPriceField.getText().trim()), 
				Integer.valueOf(buyAmountField.getText().trim()),
				Float.valueOf(lossPriceField.getText().trim()), 
				Float.valueOf(targetPriceField.getText().trim()), 
				Integer.valueOf(maxHoldDaysField.getText().trim()), 
				notesField.getText().trim());
	}
}
