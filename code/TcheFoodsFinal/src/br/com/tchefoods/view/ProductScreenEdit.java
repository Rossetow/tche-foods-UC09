package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class ProductScreenEdit {
    private JTextField TFId;
    private JComboBox CBIdCategory;
    private JTextField TFName;
    private JTextField TFPrice;
    private JButton BSubmit;
    private JLabel JPProductScreenEdit;
    private JLabel JLPriceProduct;
    private JLabel JLIdCategoryProduct;
    private JLabel JLNameProduct;
    private JLabel JLId;

    public ProductScreenEdit() {
        BSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (TFId.getText().isEmpty() || TFName.getText().isEmpty() || TFPrice.getText().isEmpty() || CBIdCategory.getSelectedIndex() == -1){ /*Não consegui colocar no cobo box o is Emptsy*/
                    JOptionPane.showMessageDialog(JPProductScreenEdit, "Please fullfill all the options");
                    return;
                }

                ProductModel user = new ProductModel();

                user.setId(Integer.parseInt(TFId.getText()));
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

                JOptionPane.showMessageDialog(JPProductScreenEdit, "User edited in the database successfully!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductScreen");
        frame.setContentPane(new ProductScreenEdit().JPProductScreenEdit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
