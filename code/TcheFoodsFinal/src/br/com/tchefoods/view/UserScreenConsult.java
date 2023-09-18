package br.com.tchefoods.view;

import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.UserModel;
import br.com.tchefoods.model.UserTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class UserScreenConsult {
    private JPanel PanelUserConsult;
    private JTextField JTFName;
    private JTextField JTFSecondName;
    private JTextField JTFEmail;
    private JTextField JTFCellphoneNumber;
    private JTextField JTFAdress;
    private JRadioButton JRBMasculine;
    private JRadioButton JRBFeminine;
    private JRadioButton JRBOthers;
    private JTextField JTFId;
    private JButton findByIdButton;
    private JButton JBFindByName;
    private JLabel JLId;
    private JLabel JLName;
    private JLabel JLSurname;
    private JLabel JLEmail;
    private JLabel JLCellphone;
    private JLabel JLAddress;
    private JLabel JLGender;
    private JTable JTUser;

    public UserScreenConsult() {
        this.JTUser.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                UserModel user = new UserModel();
                UserModel selected;
                int row = JTUser.getSelectedRow();
                if (row >= 0) {
                    user.setId((int) JTUser.getModel().getValueAt(row, 0));
                    UserDAO daoTable = new UserDAO();

                    try {
                        selected = daoTable.selectById(user);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    JTFId.setText("" + selected.getId());
                    JTFName.setText(selected.getName());
                    JTFSecondName.setText(selected.getSurname());
                    JTFEmail.setText(selected.getEmail());
                    JTFAdress.setText(selected.getAdress());
                    JTFCellphoneNumber.setText(selected.getCellphone());
                    if (selected.getGender().equals("Masculine")) {
                        JRBMasculine.setSelected(true);
                    } else if (selected.getGender().equals("Feminine")) {
                        JRBFeminine.setSelected(true);
                    } else {
                        JRBOthers.setSelected(true);
                    }
                }
            }
        });
        findByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserModel selected = new UserModel();
                selected.setId(Integer.parseInt(JTFId.getText()));
                UserDAO dao = new UserDAO();

                try {
                    selected = dao.selectById(selected);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                JTFId.setText("" + selected.getId());
                JTFName.setText(selected.getName());
                JTFSecondName.setText(selected.getSurname());
                JTFEmail.setText(selected.getEmail());
                JTFAdress.setText(selected.getAdress());
                JTFCellphoneNumber.setText(selected.getCellphone());
                if (selected.getGender().equals("Masculine")) {
                    JRBMasculine.setSelected(true);
                } else if (selected.getGender().equals("Feminine")) {
                    JRBFeminine.setSelected(true);
                } else {
                    JRBOthers.setSelected(true);
                }
            }
        });
        JBFindByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserModel selected = new UserModel();
                selected.setName(JTFName.getText());
                UserDAO dao = new UserDAO();

                try {
                    selected = dao.selectByName(selected);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


                JTFId.setText("" + selected.getId());
                JTFName.setText(selected.getName());
                JTFSecondName.setText(selected.getSurname());
                JTFEmail.setText(selected.getEmail());
                JTFAdress.setText(selected.getAdress());
                JTFCellphoneNumber.setText(selected.getCellphone());
                if (selected.getGender().equals("Masculine")) {
                    JRBMasculine.setSelected(true);
                } else if (selected.getGender().equals("Feminine")) {
                    JRBFeminine.setSelected(true);
                } else {
                    JRBOthers.setSelected(true);
                }
            }
        });
    }

    private void initMyTable() throws SQLException, ClassNotFoundException {
        this.JTUser.setModel(new UserTableModel(getUsers()));
    }

    public List<UserModel> getUsers() throws SQLException, ClassNotFoundException {
        UserDAO dao = new UserDAO();
        return dao.selectAll();
    }

    public JPanel getPanelUserConsult() {
        return PanelUserConsult;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreenConsult");
        frame.setContentPane(new UserScreenConsult().PanelUserConsult);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
