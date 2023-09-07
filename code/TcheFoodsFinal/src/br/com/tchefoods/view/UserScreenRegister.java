package br.com.tchefoods.view;

import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UserScreenRegister {
    private JTextField JTFName;
    private JTextField JTFSecondName;
    private JTextField JTFEmail;
    private JTextField JTFPassword;
    private JTextField JTFCellphoneNumber;
    private JButton JBSubmit;
    private JPanel UserPanel;
    private JLabel JLTitle;
    private JLabel JLName;
    private JLabel JLSecondName;
    private JLabel JLEmail;
    private JLabel JLPassword;
    private JLabel JLCellphoneNumber;
    private JTextField JTFAdress;
    private JRadioButton JRBMasculine;
    private JRadioButton JRBFeminine;
    private JLabel JLAdress;
    private JLabel JLGender;
    private JRadioButton JRBOthers;

    ButtonGroup btngroup = new ButtonGroup();

    public void clear() {
        JTFName.setText("");
        JTFSecondName.setText("");
        JTFEmail.setText("");
        JTFAdress.setText("");
        JTFPassword.setText("");
        JTFCellphoneNumber.setText("");
        btngroup.clearSelection();
    }

    public UserScreenRegister() {

        btngroup.add(JRBFeminine);
        btngroup.add(JRBMasculine);
        btngroup.add(JRBOthers);
        JBSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDAO daoUser = new UserDAO();
                if (JTFName.getText().isEmpty() || JTFSecondName.getText().isEmpty() || JTFEmail.getText().isEmpty() || JTFPassword.getText().isEmpty() || JTFAdress.getText().isEmpty() || JTFCellphoneNumber.getText().isEmpty() || btngroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(UserPanel, "Please fullfill all the options");
                    return;
                }

                UserModel user = new UserModel();
                user.setName(JTFName.getText());
                user.setSurname(JTFSecondName.getText());
                try {
                    user.setPassword(JTFPassword.getText());
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                }
                user.setEmail(JTFEmail.getText());
                user.setCellphone(JTFCellphoneNumber.getText());
                user.setAdress(JTFAdress.getText());
                if (JRBFeminine.isSelected()) {
                    user.setGender("Feminine");
                } else if (JRBMasculine.isSelected()) {
                    user.setGender("Masculine");
                } else {
                    user.setGender("Other");
                }

                try {
                    daoUser.save(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(UserPanel, "User added in the database successfuly!");
                clear();
            }
        });
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreen");
        frame.setContentPane(new UserScreenRegister().UserPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
