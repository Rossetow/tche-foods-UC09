package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductScreenDelete {
    public JPanel getJPProductScreenDelete() {
        return JPProductScreenDelete;
    }

    private JTextField JTFId;
    private JTextField JTFName;
    private JComboBox JCBCategory;
    private JTextField JTFPrice;
    private JButton JBSubmit;
    private JLabel JLDeleteProducts;
    private JPanel JPProductScreenDelete;
    private JLabel JLId;
    private JLabel JLName;
    private JLabel JLCategory;
    private JLabel JLPrice;

    public ProductScreenDelete() {
        JBSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (JTFId.getText().isEmpty() || JTFName.getText().isEmpty() || JTFPrice.getText().isEmpty() || JCBCategory.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(JPProductScreenDelete, "Please fullfill all the options");
                    return;
                }

                ProductModel product = new ProductModel();

                product.setId(Integer.parseInt(JTFId.getText()));
                product.setName(JTFName.getText());
                product.setCategoryId(JCBCategory.getSelectedIndex());
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
                JCBCategory.setEditable(false);
                JOptionPane.showMessageDialog(JPProductScreenDelete, "User edited in the database successfully!");
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

