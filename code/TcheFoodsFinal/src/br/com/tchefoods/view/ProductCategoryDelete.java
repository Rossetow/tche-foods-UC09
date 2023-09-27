package br.com.tchefoods.view;

import br.com.tchefoods.dao.CategoryDAO;
import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.model.CategoryModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductCategoryDelete {
    private JTextField TFProductCategory;
    private JButton BDelete;
    private JPanel JPProductCategoryDelete;
    private JLabel JLId;
    private JLabel JLTitle;

    public ProductCategoryDelete() {
        BDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();

                    if (TFProductCategory.getText().isEmpty()){
                        JOptionPane.showMessageDialog(JPProductCategoryDelete, "Please insert the information");
                        return;
                    }

                    CategoryModel categoryModel = new CategoryModel();
                    CategoryDAO categoryDAO = new CategoryDAO();

                    categoryModel.setId(Integer.parseInt(TFProductCategory.getText()));
                    try {
                        categoryDAO.delete(categoryModel);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }


                    JOptionPane.showMessageDialog(TFProductCategory,"Category deleted!");
            }
        });
        }



    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductCategoryDelete");
        frame.setContentPane(new ProductCategoryDelete().JPProductCategoryDelete);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

