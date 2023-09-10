package br.com.tchefoods.view;

import javax.swing.*;

public class ProductScreenRegister {
    private JPanel ProductScreenRegister;
    private JTextField TFName;
    private JLabel JLNameProduct;
    private JComboBox TFIdCategory;
    private JLabel JLIdCategoryProduct;
    private JTextField TFPrice;
    private JLabel JLPriceProduct;
    private JButton BSubmit;
    private JLabel JLProductScreen;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductScreen");
        frame.setContentPane(new ProductScreenRegister().ProductScreenRegister);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
