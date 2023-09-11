package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductScreenEdit {


    private JButton JBSubmit;
    private JTextField JTFId;
    private JTextField JTFName;
    private JComboBox JCBCaterory;
    private JTextField JTFPrice;
    private JPanel JPProductScreenEdit;
    private JLabel JLEdicaoProduto;
    private JLabel JLNameProduct;
    private JLabel JLIdCategoryProduct;
    private JLabel JLPriceProduct;
    private JLabel JLId;

    public ProductScreenEdit() {
        JBSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (JTFId.getText().isEmpty() || JTFName.getText().isEmpty() || JTFPrice.getText().isEmpty() || JCBCaterory.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(JPProductScreenEdit, "Please fullfill all the options");
                    return;
                }

                ProductModel user = new ProductModel();

                user.setId(Integer.parseInt(JTFId.getText()));
                user.setName(JTFName.getText());
                user.setCategoryId(JCBCaterory.getSelectedIndex());
                user.setPrice(JTFPrice.getText());

                try {
                    daoProduct.edit(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(JPProductScreenEdit, "User edited in the database successfully!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductScreenEdit");
        frame.setContentPane(new ProductScreenEdit().JPProductScreenEdit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
