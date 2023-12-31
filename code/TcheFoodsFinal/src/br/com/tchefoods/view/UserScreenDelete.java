package br.com.tchefoods.view;

import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.UserTableModel;
import br.com.tchefoods.model.UserModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class UserScreenDelete {


    private JPanel UserPanel;
    private JLabel JLTitle;
    private JLabel JLName;
    private JLabel JLSecondName;
    private JLabel JLEmail;
    private JTextField JTFName;
    private JTextField JTFSecondName;
    private JTextField JTFEmail;
    private JTextField JTFCellphoneNumber;
    private JLabel JLCellphoneNumber;
    private JButton JBSubmit;
    private JLabel JLAdress;
    private JTextField JTFAdress;
    private JRadioButton JRBMasculine;
    private JRadioButton JRBFeminine;
    private JLabel JLGender;
    private JRadioButton JRBOthers;
    private JLabel JLId;
    private JTextField JTFId;
    private JButton findByIdButton;
    private JPanel UserScreenDelete;
    private JTable JTUser;
    private JButton JBFindByName;

    ButtonGroup btngroup = new ButtonGroup();

    public void clear() {
        JTFId.setText("");
        JTFName.setText("");
        JTFSecondName.setText("");
        JTFEmail.setText("");
        JTFAdress.setText("");
        JTFCellphoneNumber.setText("");
        btngroup.clearSelection();
    }

    public JPanel getUserPanel() {
        return UserPanel;
    }

    public UserScreenDelete(){

            btngroup.add(JRBFeminine);
            btngroup.add(JRBMasculine);
            btngroup.add(JRBOthers);
            try {
                this.initMyTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            JBSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UserDAO daoUser = new UserDAO();
                    if (JTFId.getText().isEmpty()||JTFName.getText().isEmpty() || JTFSecondName.getText().isEmpty() || JTFEmail.getText().isEmpty() || JTFAdress.getText().isEmpty() || JTFCellphoneNumber.getText().isEmpty() || btngroup.getSelection() == null) {
                        JOptionPane.showMessageDialog(UserPanel, "Please fullfill all the options");
                        return;
                    }

                    if(JOptionPane.showConfirmDialog(UserPanel, "Are you sure you want to delete this user from the database?") == 1){
                        JOptionPane.showMessageDialog(UserPanel, "Canceled!");
                        return;
                    }

                    UserModel user = new UserModel();
                    user.setId(Integer.parseInt(JTFId.getText()));
                    user.setName(JTFName.getText());
                    user.setSurname(JTFSecondName.getText());
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
                    user.setId(Integer.parseInt(JTFId.getText()));
                    try {
                        daoUser.delete(user);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(UserPanel, "User deleted from the database successfully!");
                    clear();
                    try {
                        initMyTable();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            });

            this.JTUser.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    UserModel user = new UserModel();
                    UserModel selected;
                    int row = JTUser.getSelectedRow();
                    if(row >= 0){
                        user.setId((int)JTUser.getModel().getValueAt(row, 0));
                        UserDAO daoTable = new UserDAO();

                        try {
                            selected = daoTable.selectById(user);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        JTFId.setText(""+selected.getId());
                        JTFName.setText(selected.getName());
                        JTFSecondName.setText(selected.getSurname());
                        JTFEmail.setText(selected.getEmail());
                        JTFAdress.setText(selected.getAdress());
                        JTFCellphoneNumber.setText(selected.getCellphone());
                        if (selected.getGender().equals("Masculine")){
                            JRBMasculine.setSelected(true);
                        } else if (selected.getGender().equals("Feminine")){
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
                    JTFId.setText(""+selected.getId());
                    JTFName.setText(selected.getName());
                    JTFSecondName.setText(selected.getSurname());
                    JTFEmail.setText(selected.getEmail());
                    JTFAdress.setText(selected.getAdress());
                    JTFCellphoneNumber.setText(selected.getCellphone());
                    if (selected.getGender().equals("Masculine")){
                        JRBMasculine.setSelected(true);
                    } else if (selected.getGender().equals("Feminine")){
                        JRBFeminine.setSelected(true);
                    } else {
                        JRBOthers.setSelected(true);
                    }
                }
            });
        JBFindByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(JTFName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(UserPanel, "Insert a name to search");
                    return;
                }
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


                JTFId.setText(""+selected.getId());
                JTFName.setText(selected.getName());
                JTFSecondName.setText(selected.getSurname());
                JTFEmail.setText(selected.getEmail());
                JTFAdress.setText(selected.getAdress());
                JTFCellphoneNumber.setText(selected.getCellphone());
                if (selected.getGender().equals("Masculine")){
                    JRBMasculine.setSelected(true);
                } else if (selected.getGender().equals("Feminine")){
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


    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreenDelete");
        frame.setContentPane(new UserScreenDelete().UserScreenDelete);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
