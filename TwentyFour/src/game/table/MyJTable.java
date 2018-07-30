package game.table;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MyJTable extends JTable{
	private static final long serialVersionUID = 1L;
	public MyJTable(AbstractTableModel a) {
		super(a);
	}
	
	public MyJTable(Object[][] obj, String[] columnNames) {
		super(obj,columnNames);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int ColIndex){
        return false;
       }
}
