package com.ims.gui;

import javax.swing.table.AbstractTableModel;

public class ProductsTableModel extends AbstractTableModel {
	private String[] columnNames;	
	private Object[][] products;
	
	
	public ProductsTableModel(Object[][] products, String[] columnNames){
		this.columnNames = columnNames;
		this.products = products;
		
	}
	
	@Override
	public boolean isCellEditable(int row, int column){
		
		return column == 5;
		
	}
	
	@Override
	public void setValueAt(Object inValue, int inRow, int inCol){
		if(inCol==5){
			products[inRow][inCol] = (Boolean)inValue;
			
			}
		
	}
	
	public String getColumnName(int column) {
		  return columnNames[column];
		}

	
	@Override
	public int getRowCount() {
		return products.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return products[rowIndex][columnIndex];
	}
	
	//
    // This method is used by the JTable to define the default
    // renderer or editor for each cell. For example if you have
    // a boolean data it will be rendered as a check box. A
    // number value is right aligned.
    //
	
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return products[0][columnIndex].getClass();
    }

}
