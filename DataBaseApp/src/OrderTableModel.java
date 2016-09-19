/**
 * @author Eduard Ulasenka, 273173
 */

import java.util.List;

import javax.swing.table.AbstractTableModel;

class OrderTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ORDER_ID_COL = 0;
	private static final int TOURIST_ID_COL = 1;
	private static final int DATE_COL = 2;
	private static final int AMOUNT_COL = 3;

	private String[] columnNames = { "order_id", "tourist_id", "order_date",
			"amount" };
	private List<Order> orders;

	public OrderTableModel(List<Order> theOrder) {
		orders = theOrder;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return orders.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Order tempOrder = orders.get(row);

		switch (col) {
		case ORDER_ID_COL:
			return tempOrder.getOrder_id();
		case TOURIST_ID_COL:
			return tempOrder.getTourist_id();
		case DATE_COL:
			return tempOrder.getDate();
		case AMOUNT_COL:
			return tempOrder.getAmount();
		default:
			return tempOrder.getOrder_id();
		}
	}
}