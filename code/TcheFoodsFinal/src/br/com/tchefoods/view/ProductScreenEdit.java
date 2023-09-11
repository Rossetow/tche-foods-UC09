package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductScreenEdit {


    private JButton BSubmit;
    private JTextField TFId;
    private JTextField TFNome;
    private JComboBox TFCaterory;
    private JTextField textField3;
    private JPanel JPProductScreenEdit;
    private JLabel JLEdicaoProduto;

    public ProductScreenEdit() {
        BSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (TFId.getText().isEmpty() || TFName.getText().isEmpty() || TFPrice.getText().isEmpty() || CBIdCategory.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(JLProductScreenEdit, "Please fullfill all the options");
                    return;
                }

                ProductModel user = new ProductModel();

                user.setId(Integer.parseInt(TFId.getText()));
                user.setName(TFName.getText());
                user.setCategoryId(CBIdCategory.getSelectedIndex());
                user.setPrice(TFPrice.getText());

                try {
                    daoProduct.edit(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(JLProductScreenEdit, "User edited in the database successfully!");
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
