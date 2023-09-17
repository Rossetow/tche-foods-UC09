package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.ProductModel;
import br.com.tchefoods.model.UserModel;

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

    public JPanel getJPProductScreenEdit() {
        return JPProductScreenEdit;
    }

    private JLabel JLIdCategoryProduct;
    private JLabel JLPriceProduct;
    private JLabel JLId;
    private JButton findByIdButton;

    public ProductScreenEdit() {
        JBSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (JTFId.getText().isEmpty() || JTFName.getText().isEmpty() || JTFPrice.getText().isEmpty() || JCBCaterory.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(JPProductScreenEdit, "Please fullfill all the options");
                    return;
                }

                ProductModel product = new ProductModel();

                product.setId(Integer.parseInt(JTFId.getText()));
                product.setName(JTFName.getText());
                product.setCategoryId(JCBCaterory.getSelectedIndex());
                product.setPrice(Float.parseFloat(JTFPrice.getText()));

                try {
                    daoProduct.edit(product);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JTFName.setEditable(false);
                JTFPrice.setEditable(false);
                JCBCaterory.setEditable(false);
                JOptionPane.showMessageDialog(JPProductScreenEdit, "User edited in the database successfully!");
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
                JCBCaterory.setSelectedIndex(selected.getCategoryId());

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
