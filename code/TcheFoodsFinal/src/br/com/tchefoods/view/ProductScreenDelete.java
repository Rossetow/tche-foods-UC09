package br.com.tchefoods.view;

import javax.swing.*;

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductScreenDelete");
        frame.setContentPane(new ProductScreenDelete().JPProductScreenDelete);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

