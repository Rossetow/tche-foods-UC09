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

public class ProductScreenRegister {
    private JPanel JPProductScreenRegister;

    public JPanel getJPProductScreenRegister() {
        return JPProductScreenRegister;
    }

    private JTextField JTFName;
    private JLabel JLNameProduct;
    private JComboBox JCBIdCategory;
    private JLabel JLIdCategoryProduct;
    private JTextField JTFPrice;
    private JLabel JLPriceProduct;
    private JButton JBSubmit;
    private JLabel JLProductScreen;

    public void clear() {
        JTFName.setText("");
        JTFPrice.setText("");
        JCBIdCategory.setSelectedIndex(0);
    }


    public ProductScreenRegister()  {
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            ArrayList<CategoryModel > listaCategorias = categoryDAO.selectAll();
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
                if (JTFName.getText().isEmpty() || JTFPrice.getText().isEmpty() || JCBIdCategory.getSelectedIndex() == -1 ){
                    JOptionPane.showMessageDialog(JPProductScreenRegister, "Please fullfill all the options");
                    return;
                }

                ProductModel product = new ProductModel();

                product.setName(JTFName.getText());
                product.setCategoryId(JCBIdCategory.getSelectedIndex() + 1);
                product.setPrice(Float.parseFloat(JTFPrice.getText()));

                try {
                    daoProduct.save(product);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(JPProductScreenRegister, "Product added in the database successfuly!");
                clear();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductScreenRegister");
        frame.setContentPane(new ProductScreenRegister().JPProductScreenRegister);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
