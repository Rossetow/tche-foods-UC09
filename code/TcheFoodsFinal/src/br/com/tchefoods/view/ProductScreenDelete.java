package br.com.tchefoods.view;

import br.com.tchefoods.dao.CategoryDAO;
import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.CategoryModel;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductScreenDelete {
    public JPanel getJPProductScreenDelete() {
        return JPProductScreenDelete;
    }

    private JTextField JTFId;
    private JTextField JTFName;
    private JComboBox JCBIdCategory;
    private JTextField JTFPrice;
    private JButton JBSubmit;
    private JLabel JLDeleteProducts;
    private JPanel JPProductScreenDelete;
    private JLabel JLId;
    private JLabel JLName;
    private JLabel JLCategory;
    private JLabel JLPrice;
    private JButton findByIdButton;

    public void clear() {
        JTFId.setText("");
        JTFName.setText("");
        JTFPrice.setText("");
        JCBIdCategory.setSelectedIndex(0);
    }

    public ProductScreenDelete() {
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            ArrayList<CategoryModel> listaCategorias = categoryDAO.selectAll();
            for (CategoryModel categoryModel : listaCategorias){
                JCBIdCategory.addItem((categoryModel));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        JBSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (JTFId.getText().isEmpty()){
                    JOptionPane.showMessageDialog(JPProductScreenDelete, "Please fullfill all the options");
                    return;
                }

                ProductModel product = new ProductModel();

                product.setId(Integer.parseInt(JTFId.getText()));
                product.setName(JTFName.getText());
                product.setCategoryId(JCBIdCategory.getSelectedIndex());
                product.setPrice(Float.parseFloat(JTFPrice.getText()));

                try {
                    daoProduct.delete(product);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JTFName.setEditable(false);
                JTFPrice.setEditable(false);
                JCBIdCategory.setEditable(false);
                JOptionPane.showMessageDialog(JPProductScreenDelete, "Product deleted in the database successfully!");
                clear();
            }


        });
        findByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductModel selected = new ProductModel();
                selected.setId(Integer.parseInt(JTFId.getText()));
                ProductDAO daoProduct = new ProductDAO();

                try {
                    selected = daoProduct.selectById(selected);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                JTFId.setText(""+selected.getId());
                JTFName.setText(selected.getName());
                JTFPrice.setText(""+selected.getPrice());
                JCBIdCategory.setSelectedIndex(selected.getCategoryId() - 1);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductScreenDelete");
        frame.setContentPane(new ProductScreenDelete().JPProductScreenDelete);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

