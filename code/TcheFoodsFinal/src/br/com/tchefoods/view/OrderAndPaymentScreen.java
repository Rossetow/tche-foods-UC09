package br.com.tchefoods.view;

import javax.swing.*;

public class OrderAndPaymentScreen {
    private JPanel PanelOrder;
    private JTextField JTFProductName;
    private JButton ButtonAdd;
    private JTable JTProducts;
    private JTextField TFTtotalPrice;
    private JComboBox JCBPaymentMethod;
    private JButton JBFinish;
    private JLabel JLTitle;
    private JLabel JLProductName;
    private JLabel JLQuantity;
    private JLabel JLProductPriceTotal;
    private JSpinner JSPQuantity;

    public JPanel getPanelOrder() {
        return PanelOrder;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OrderAndPaymentScreen");
        frame.setContentPane(new OrderAndPaymentScreen().PanelOrder);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
