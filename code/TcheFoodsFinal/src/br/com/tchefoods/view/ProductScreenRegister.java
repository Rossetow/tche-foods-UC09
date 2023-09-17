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


    public ProductScreenRegister()  {
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
                if (JTFName.getText().isEmpty() || JTFPrice.getText().isEmpty() || JCBIdCategory.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(JPProductScreenRegister, "Please fullfill all the options");
                    return;
                }

                ProductModel user = new ProductModel();

                user.setName(JTFName.getText());
                user.setCategoryId(JCBIdCategory.getSelectedIndex());
                user.setPrice(JTFPrice.getText());

                try {
                    daoProduct.save(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(JPProductScreenRegister, "User added in the database successfuly!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductScreen");
        frame.setContentPane(new ProductScreenRegister().JPProductScreenRegister);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
