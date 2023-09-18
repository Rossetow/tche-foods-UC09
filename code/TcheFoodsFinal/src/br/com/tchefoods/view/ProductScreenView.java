package br.com.tchefoods.view;

import br.com.tchefoods.dao.OrderDAO;
import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.SQLException;
import java.util.List;


public class ProductScreenView {
    private JTable JTProduct;
    private JPanel JPProductScreenView;

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