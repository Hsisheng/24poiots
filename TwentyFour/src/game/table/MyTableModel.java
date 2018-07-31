package game.table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private List<String> TableData;//用来存放表格数据的线性表
    private Vector<String> TableTitle;//表格的 列标题
    
    

    public MyTableModel(List<String> TableData,Vector<String> TableTitle) {
    		this.TableData=TableData;
    		this.TableTitle=TableTitle;
    }
    
    
    public void setValue(List<String> TableData) {
    		
    		this.TableData=cut(TableData);
    		this.fireTableDataChanged();
    }
    
    private List<String> cut(List<String> orgList){
    	List<String> newList=new ArrayList<String>();
    	HashSet<Integer> set=new HashSet<Integer>();
    	for(String s:orgList) {
    		int i=1;
    		for(char c:s.toCharArray()) {
    			if(c=='+'||c=='-'||c=='*'||c=='/') i*=c;
    		}
    		if(set.add(i)) newList.add(s);
    		
    	}
    	return newList;
    }
    
    @Override
    public String getColumnName(int column) {
        return TableTitle.get(column);
    }
    
    @Override
    public int getRowCount(){
           return TableData.size();
    }

    @Override
    public int getColumnCount(){
           return TableTitle.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
           String LineTemp = (String)this.TableData.get(rowIndex);
           return LineTemp;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
           return true;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
           this.TableData.set(rowIndex,(String)aValue);
           super.setValueAt(aValue, rowIndex, columnIndex);

    }

}
