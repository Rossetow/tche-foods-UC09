package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductScreenDelete {
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

                ProductModel user = new ProductModel();

                user.setId(Integer.parseInt(JTFId.getText()));
                user.setName(JTFName.getText());
                user.setCategoryId(JCBCategory.getSelectedIndex());
                user.setPrice(JTFPrice.getText());

                try {
                    daoProduct.edit(user);
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

