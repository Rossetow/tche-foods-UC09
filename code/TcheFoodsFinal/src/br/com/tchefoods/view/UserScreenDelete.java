package br.com.tchefoods.view;

import javax.swing.*;

public class UserScreenDelete {
    private JPanel UserPanel;
    private JLabel JLTitle;
    private JLabel JLName;
    private JLabel JLSecondName;
    private JLabel JLEmail;
    private JLabel JLPassword;
    private JTextField TFName;
    private JTextField TFSecondName;
    private JTextField TFEmail;
    private JTextField TFPassword;
    private JTextField TFCellphoneNumber;
    private JLabel JLCellphoneNumber;
    private JButton ButtonSubmit;
    private JLabel JLAdress;
    private JTextField TFAdress;
    private JRadioButton RBMasculine;
    private JRadioButton RBFeminine;
    private JLabel JLGender;
    private JRadioButton RBOthers;
    private JTextField TFId;
    private JLabel JLId;
    private JPanel UserScreenDelete;

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreenDelete");
        frame.setContentPane(new UserScreenDelete().UserScreenDelete);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}