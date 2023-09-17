package br.com.tchefoods.view;

import br.com.tchefoods.dao.OrderDAO;
import br.com.tchefoods.dao.ProductDAO;
import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.OrderModel;
import br.com.tchefoods.model.ProductModel;
import br.com.tchefoods.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OrderAndPaymentScreen {
    private JPanel PanelOrder;
    private JTextField JTFProductName;
    private JButton JBAdd;
    private JTextField JTFTotalPrice;
    private JComboBox JCBPaymentMethod;
    private JButton JBFinish;
    private JLabel JLTitle;
    private JLabel JLProductName;
    private JLabel JLQuantity;
    private JLabel JLProductPriceTotal;
    private JTextField JTFUser;
    private JButton JBSearch;
    private JSpinner JSPQuantity;

    public JPanel getPanelOrder() {
        return PanelOrder;
    }

    private OrderModel order = new OrderModel();
    public OrderAndPaymentScreen (){

        
        JBAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (JTFProductName.getText().isEmpty()||JTFUser.getText().isEmpty()){
                    JOptionPane.showMessageDialog(PanelOrder, "Please insert the information!");
                    return;
                }
                ProductModel product = new ProductModel();
                ProductDAO daoProduct = new ProductDAO();
                product.setName(JTFProductName.getText());
                try {
                    product = daoProduct.selectByName(product);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                JTFTotalPrice.setText(""+product.getPrice());
                order.setProductId(product.getId());
                order.setTotal(product.getPrice());

                UserModel user = new UserModel();
                UserDAO userDAO = new UserDAO();

                user.setName(JTFUser.getText());
                try {
                    user=userDAO.selectByName(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                order.setUserId(user.getId());
            }
        });
        JBFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderDAO orderDAO = new OrderDAO();
                order.setPaymentMethodId(JCBPaymentMethod.getSelectedIndex()+1);
                try {
                    orderDAO.save(order);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OrderAndPaymentScreen");
        frame.setContentPane(new OrderAndPaymentScreen().PanelOrder);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
