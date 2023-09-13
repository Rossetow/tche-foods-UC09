package br.com.tchefoods.model;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {
    private List<ProductModel> itens;

    private String[] columns = new String[] {
            "ID",
            "Name",
            "Price",
            "Category"
    };
    private Class[] types = new Class [] {
            java.lang.Integer.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
    };
    private boolean[] canEdit = new boolean [] {
            false,
            false,
            false,
            false
    };

    public ProductTableModel(List<ProductModel> input) {
        this.itens=input;
    }

    public int getRowCount() {
        return itens.size();
    }
    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductModel item = itens.get(rowIndex);
        switch(columnIndex){
            case 0: return item.getId();
            case 1: return item.getName();
            case 2: return item.getPrice();
            case 3: return item.getCategoryId();
        }
        return null;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

    public void add (ProductModel item){
        this.itens.add(item);
        int row = itens.indexOf(item);
        fireTableRowsInserted(row,row);

    }

    public void remove (ProductModel item){
        if(this.itens.contains(item)){
            int row = itens.indexOf(item);
            itens.remove(item);
            fireTableRowsDeleted(row, row);
        }
    }
}