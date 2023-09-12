package br.com.tchefoods.view;

import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.TableModel;
import br.com.tchefoods.model.UserModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class ProductScreenTable {
    private JTable JTTable;
    private JLabel JLItensTable;

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
}

    private void initMyTable() throws SQLException, ClassNotFoundException {
        this.JTUser.setModel(new TableModel(getUsers()));
    }

    public List<UserModel> getUsers() throws SQLException, ClassNotFoundException {
        UserDAO dao = new UserDAO();
        return dao.selectAll();
    }
}
