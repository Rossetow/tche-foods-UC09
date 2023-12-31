package br.com.tchefoods.view;

import br.com.tchefoods.dao.CategoryDAO;
import br.com.tchefoods.model.CategoryModel;
import br.com.tchefoods.model.ProductModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductCategoryScreen {
    private JTextField TFProductCategory;
    private JLabel JLProductCategory;

    public ProductCategoryScreen() {
        BSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TFProductCategory.getText().isEmpty()){
                    JOptionPane.showMessageDialog(JPProductCategory, "Please insert the information");
                    return;
                }

                CategoryModel categoryModel = new CategoryModel();
                CategoryDAO categoryDAO = new CategoryDAO();

                categoryModel.setDesc(TFProductCategory.getText());
                try {
                    categoryDAO.save(categoryModel);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(JPProductCategory,"Category saved!");

            }
        });
    }

    public JPanel getJPProductCategory() {
        return JPProductCategory;
    }

    private JLabel JLDescription;
    private JButton BSubmit;
    private JPanel JPProductCategory;


    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductCategoryScreen");
        frame.setContentPane(new ProductCategoryScreen().JPProductCategory);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
