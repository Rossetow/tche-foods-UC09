package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductScreenRegister {
    private JPanel JPProductScreenRegister;
    private JTextField TFName;
    private JLabel JLNameProduct;
    private JComboBox CBIdCategory;
    private JLabel JLIdCategoryProduct;
    private JTextField TFPrice;
    private JLabel JLPriceProduct;
    private JButton BSubmit;
    private JLabel JLProductScreen;

    public ProductScreenRegister() {
        BSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (TFName.getText().isEmpty() || TFPrice.getText().isEmpty() || CBIdCategory.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(JPProductScreenRegister, "Please fullfill all the options");
                    return;
                }

                ProductModel user = new ProductModel();

                user.setName(TFName.getText());
                user.setCategoryId(CBIdCategory.getSelectedIndex());
                user.setPrice(TFPrice.getText());

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
