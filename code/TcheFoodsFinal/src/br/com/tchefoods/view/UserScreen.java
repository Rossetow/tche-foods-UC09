package br.com.tchefoods.view;

import javax.swing.*;

public class UserScreen {
    private JTextField TFName;
    private JTextField TFSecondName;
    private JTextField TFEmail;
    private JTextField TFPassword;
    private JTextField TFCellphoneNumber;
    private JButton ButtonSubmit;
    private JPanel UserPanel;
    private JLabel JLTitle;
    private JLabel JLName;
    private JLabel JLSecondName;
    private JLabel JLEmail;
    private JLabel JLPassword;
    private JLabel JLCellphoneNumber;

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreen");
        frame.setContentPane(new UserScreen().UserPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
