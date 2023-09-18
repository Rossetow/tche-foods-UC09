package br.com.tchefoods.view;

import br.com.tchefoods.dao.CategoryDAO;
import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.CategoryModel;
import br.com.tchefoods.model.ProductModel;
import br.com.tchefoods.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductScreenEdit {


    private JButton JBSubmit;
    private JTextField JTFId;
    private JTextField JTFName;
    private JComboBox JCBIdCategory;
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
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            ArrayList<CategoryModel> listaIdCategorias = categoryDAO.selectAll();
            for (CategoryModel categoryModel : listaIdCategorias){
                JCBIdCategory.addItem((categoryModel));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        JBSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDAO daoProduct = new ProductDAO();
                if (JTFId.getText().isEmpty() || JTFName.getText().isEmpty() || JTFPrice.getText().isEmpty() || JCBIdCategory.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(JPProductScreenEdit, "Please fullfill all the options");
                    return;
                }

                ProductModel product = new ProductModel();

                product.setId(Integer.parseInt(JTFId.getText()));
                product.setName(JTFName.getText());
                product.setCategoryId(JCBIdCategory.getSelectedIndex() + 1);
                product.setPrice(Float.parseFloat(JTFPrice.getText()));

                try {
                    daoProduct.edit(product);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


                JOptionPane.showMessageDialog(JPProductScreenEdit, "Product edited in the database successfully!");
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
                JCBIdCategory.setSelectedIndex(selected.getCategoryId() - 1);

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
