package br.com.tchefoods.view;

import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductCategoryDelete {
    private JPanel JPProductCategory;
    private JLabel JLDescriptionId;
    private JLabel JLProductCategory;
    private JTextField JTF;
    private JButton BDelete;
    private JTextField TFProductCategory;
    private JPanel PCategoryDelete;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductCategoryDelete");
        frame.setContentPane(new ProductCategoryDelete().JPProductCategory);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ProductCategoryDelete() {
        BDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (JTF.getText().isEmpty()){
                    JOptionPane.showMessageDialog(JPProductCategory, "Please insert the information");
                    return;
                }

                ProductModel product = new ProductModel();

                product.setId(Integer.parseInt(TFProductCategory.getText()));

                try {
                    daoProduct.delete(product);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JTF.setEditable(false);
                JOptionPane.showMessageDialog(JPProductCategory, "User edited in the database successfully!");
            }
        });
    }


}