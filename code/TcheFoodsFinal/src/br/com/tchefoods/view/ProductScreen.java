package br.com.tchefoods.view;

import javax.swing.*;

public class ProductScreen {
<<<<<<< HEAD
    private JTextField TFPrice;
    private JTextField TFNameProduct;
=======
    private JPanel JPProductScreen;
>>>>>>> bb6b69f9a17b730d7d3a2f2e7ac3ca78b12be425
    private JLabel JLAddProducts;
    private JTextField TFIdCategory;
<<<<<<< HEAD
    private JLabel JLNameProduct;
    private JPanel JPSddProducts;
=======
    private JTextField TFPrice;
    private JLabel JLIdCategory;
    private JLabel JLPrice;
    private JTextField TFDescription;
    private JLabel JLDescription;
>>>>>>> bb6b69f9a17b730d7d3a2f2e7ac3ca78b12be425
    private JButton BSubmit;
    private JPanel ProductScreen;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductScreen");
        frame.setContentPane(new ProductScreen().ProductScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
