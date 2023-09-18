package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.ProductModel;
import br.com.tchefoods.model.ProductTableModel;
import br.com.tchefoods.model.UserModel;
import br.com.tchefoods.model.UserTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.SQLException;
import java.util.List;


public class ProductScreenView {
    private JTable JTProduct;
    private JPanel JPProductScreenView;

    public ProductScreenView() {

        this.JTProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ProductModel product = new ProductModel();
                ProductModel selected;
                int row = JTProduct.getSelectedRow();
                if(row >= 0){
                    product.setId((int)JTProduct.getModel().getValueAt(row, 0));
                    ProductDAO daoTable = new ProductDAO();

                    try {
                        selected = daoTable.selectById(product);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

    private void initMyTable() throws SQLException, ClassNotFoundException {
        this.JTProduct.setModel(new ProductTableModel(getProducts()));

    }
    public List<ProductModel> getProducts() throws SQLException, ClassNotFoundException {
        ProductDAO daoProduct = new ProductDAO();
        return daoProduct.selectAll();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Product Screen");
        frame.setContentPane(new ProductScreenView().JPProductScreenView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}