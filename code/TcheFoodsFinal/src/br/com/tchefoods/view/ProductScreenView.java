package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;


public class ProductScreenView {
    private JTable JTProduct;
    private JPanel PanelScreenView;

    public ProductScreenView() {
        try {
            initMyTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void initMyTable() throws SQLException, ClassNotFoundException {
        this.JTProduct.setModel(new ProductTableModel(this.getProducts()));
    }

    public List<ProductModel> getProducts() throws SQLException, ClassNotFoundException {
        ProductDAO dao = new ProductDAO();
        return dao.selectAll();
    }
}