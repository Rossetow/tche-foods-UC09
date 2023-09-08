package br.com.tchefoods.view;

import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UserScreenEdit {
    private JPanel UserPanel;
    private JLabel JLTitle;
    private JLabel JLName;
    private JLabel JLSecondName;
    private JLabel JLEmail;
    private JLabel JLPassword;
    private JTextField JTFName;
    private JTextField JTFSecondName;
    private JTextField JTFEmail;
    private JTextField JTFPassword;
    private JTextField JTFCellphoneNumber;
    private JLabel JLCellphoneNumber;
    private JButton JBSubmit;
    private JLabel JLAdress;
    private JTextField JTFAdress;
    private JRadioButton JRBMasculine;
    private JRadioButton JRBFeminine;
    private JLabel JLGender;
    private JRadioButton JRBOthers;
    private JTextField JTFId;
    private JLabel JLId;
    private JPanel UserScreenEdit;

    ButtonGroup btngroup = new ButtonGroup();

    public void clear() {
        JTFId.setText("");
        JTFName.setText("");
        JTFSecondName.setText("");
        JTFEmail.setText("");
        JTFAdress.setText("");
        JTFPassword.setText("");
        JTFCellphoneNumber.setText("");
        btngroup.clearSelection();
    }

    public UserScreenEdit() {

        btngroup.add(JRBFeminine);
        btngroup.add(JRBMasculine);
        btngroup.add(JRBOthers);
        JBSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDAO daoUser = new UserDAO();
                if (JTFId.getText().isEmpty()||JTFName.getText().isEmpty() || JTFSecondName.getText().isEmpty() || JTFEmail.getText().isEmpty() || JTFPassword.getText().isEmpty() || JTFAdress.getText().isEmpty() || JTFCellphoneNumber.getText().isEmpty() || btngroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(UserPanel, "Please fullfill all the options");
                    return;
                }

                UserModel user = new UserModel();
                user.setId(Integer.parseInt(JTFId.getText()));
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
                    daoUser.edit(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(UserPanel, "User edited in the database successfully!");
                clear();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreenEdit");
        frame.setContentPane(new UserScreenEdit().UserScreenEdit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
