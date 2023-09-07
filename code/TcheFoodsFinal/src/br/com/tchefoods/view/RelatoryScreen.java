package br.com.tchefoods.view;

import javax.swing.*;

public class RelatoryScreen {
    private JLabel JLTitle;
    private JLabel JLTitle2;
    private JSpinner SPDay;
    private JSpinner SPYear;
    private JTable TBRelatory;
    private JComboBox CBMonth;
    private JPanel RelatoryScreen;

    public static void main(String[] args) {
        JFrame frame = new JFrame("RelatoryScreen");
        frame.setContentPane(new RelatoryScreen().RelatoryScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
