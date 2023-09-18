package br.com.tchefoods.model;
import br.com.tchefoods.dao.PaymenthMethodDAO;
import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.dao.UserDAO;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.List;

public class OrderTableModel extends AbstractTableModel {
    private List<OrderModel> itens;
    private String[] columns = new String[] {
            "ID",
            "User",
            "Product",
            "Payment Method",
            "Date",
            "Total"
    };
    private Class[] types = new Class [] {
            java.lang.Integer.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.Float.class
    };
    private boolean[] canEdit = new boolean [] {
            false,
            false,
            false,
            false,
            false,
            false
    };

    public OrderTableModel(List<OrderModel> input) {
        this.itens=input;
    }

    public int getRowCount() {
        return itens.size();
    }
    public int getColumnCount() {
        return 6;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderModel item = itens.get(rowIndex);
        switch(columnIndex){
            case 0: return item.getId();
            case 1:
                UserDAO userDAO = new UserDAO();
                UserModel userModel = new UserModel();
                userModel.setId(item.getUserId());
                try {
                    return userDAO.selectById(userModel).getName();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            case 2:
                ProductDAO productDAO = new ProductDAO();
                ProductModel productModel = new ProductModel();
                productModel.setId(item.getProductId());
                try {
                    return productDAO.selectById(productModel).getName();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            case 3:
                PaymenthMethodDAO methodDAO = new PaymenthMethodDAO();
                PaymentMethodModel methodModel = new PaymentMethodModel();
                methodModel.setId(item.getId());
                try {
                    return methodDAO.selectById(methodModel).getDesc();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            case 4: return item.getDateTime();
            case 5: return item.getTotal();
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

    public void add (OrderModel item){
        this.itens.add(item);
        int row = itens.indexOf(item);
        fireTableRowsInserted(row,row);

    }

    public void remove (OrderModel item){
        if(this.itens.contains(item)){
            int row = itens.indexOf(item);
            itens.remove(item);
            fireTableRowsDeleted(row, row);
        }
    }
}