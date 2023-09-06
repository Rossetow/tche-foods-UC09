package br.com.tchefoods.view;

import javax.swing.*;

public class UserScreenRegister {
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
    private JTextField TFAdress;
    private JRadioButton RBMasculine;
    private JRadioButton RBFeminine;
    private JLabel JLAdress;
    private JLabel JLGender;
    private JRadioButton RBOthers;

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreen");
        frame.setContentPane(new UserScreenRegister().UserPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
