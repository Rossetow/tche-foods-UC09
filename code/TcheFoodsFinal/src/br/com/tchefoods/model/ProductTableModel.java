package br.com.tchefoods.model;

import java.util.List;

public class ProductTableModel {

    private List<ProductModel> itens;

    private String[] columns = new String[] {
            "ID",
            "Name",
            "Category",
            "Price"
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
        return 7;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductModel item = itens.get(rowIndex);
        switch(columnIndex){
            case 0: return item.getId();
            case 1: return item.getName();
            case 2: return item.getCategoryId();
            case 3: return item.getPrice();
        }
        return null;
    }
}
