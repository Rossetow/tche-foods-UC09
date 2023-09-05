package br.com.tchefoods.view;

import javax.swing.*;

public class OrderAndPaymentScreen {
    private JPanel PanelOrder;
    private JTextField TFProductName;
    private JTextField TFPrice;
    private JButton ButtonAdd;
    private JTable TableProducts;
    private JTextField TFTtotalPrice;
    private JComboBox CBPaymentMethod;
    private JButton ButtonBuy;
    private JLabel JLTitle;
    private JLabel JLProductName;
    private JLabel JLPrice;
    private JLabel JLProductPriceTotal;

    public static void main(String[] args) {
        JFrame frame = new JFrame("OrderAndPaymentScreen");
        frame.setContentPane(new OrderAndPaymentScreen().PanelOrder);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
