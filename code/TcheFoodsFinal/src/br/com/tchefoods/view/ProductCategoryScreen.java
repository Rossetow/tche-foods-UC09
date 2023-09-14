package br.com.tchefoods.view;

import javax.swing.*;

public class ProductCategoryScreen {
    private JTextField TFProductCategory;
    private JLabel JLProductCategory;

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
