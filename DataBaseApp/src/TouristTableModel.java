/**
 * @author Eduard Ulasenka, 273173
 */

import java.util.List;

import javax.swing.table.AbstractTableModel;

class TouristTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int tourist_id_COL = 0;
	private static final int name_COL = 1;
	private static final int surame_COL = 2;
	private static final int clubcard_id_COL = 3;
	private static final int address_id_COL = 4;


	private String[] columnNames = { "tourist_id", "name", "surame",
			"clubcard_id", "address_id" };
	private List<Tourist> tourists;

	public TouristTableModel(List<Tourist> theTourist) {
		tourists = theTourist;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return tourists.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Tourist tempTourist = tourists.get(row);

		switch (col) {
		case tourist_id_COL:
			return tempTourist.getTourist_id();
		case name_COL:
			return tempTourist.getName();
		case surame_COL:
			return tempTourist.getSurname();
		case clubcard_id_COL:
			return tempTourist.getClubCard();
		case address_id_COL:
			return tempTourist.getAddress();
		default:
			return tempTourist.getTourist_id();
		}
	}
}