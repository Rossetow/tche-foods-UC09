package br.com.tchefoods.model;

import javax.swing.table.AbstractTableModel;
import java.awt.print.Book;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private List<UserModel> itens;

    private String[] columns = new String[] {
            "ID",
            "Name",
            "Surname",
            "Email",
            "Cellphone",
            "Address",
            "Gender"
    };
    private Class[] types = new Class [] {
            java.lang.Integer.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
    };
    private boolean[] canEdit = new boolean [] {
            false,
            false,
            false,
            false,
            false,
            false,
            false
    };

    public TableModel(List<UserModel> input) {
        this.itens=input;
    }

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UserModel item = itens.get(rowIndex);
        switch(columnIndex){
            case 0: return item.getId();
            case 1: return item.getName();
            case 2: return item.getSurname();
            case 3: return item.getEmail();
            case 4: return item.getCellphone();
            case 5: return item.getAdress();
            case 6: return item.getGender();
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

    public void add (UserModel item){
        this.itens.add(item);
        int row = itens.indexOf(item);
        fireTableRowsInserted(row, row);
    }

    public void remove (UserModel item){
        if(this.itens.contains(item)){
            int row = itens.indexOf(item);
            itens.remove(item);
            fireTableRowsDeleted(row, row);
        }
    }


}
