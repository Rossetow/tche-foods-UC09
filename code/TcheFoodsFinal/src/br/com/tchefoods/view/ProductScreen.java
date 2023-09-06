package br.com.tchefoods.view;

import javax.swing.*;

public class ProductScreen {
    private JPanel JPProductScreen;
    private JLabel JLAddProducts;
    private JTextField TFIdCategory;
    private JTextField TFPrice;
    private JLabel JLIdCategory;
    private JLabel JLPrice;
    private JTextField TFDescription;
    private JLabel JLDescription;
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
