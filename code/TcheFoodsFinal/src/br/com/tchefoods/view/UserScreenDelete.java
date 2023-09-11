package br.com.tchefoods.view;

import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.UserModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserScreenDelete {
    private JPanel UserPanel;
    private JLabel JLTitle;
    private JTextField JTFId;
    private JLabel JLId;
    private JPanel UserScreenDelete;
    private JButton JBDelete;

    public UserScreenDelete() {
        JBDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JTFId.getText().isEmpty()){
                    JOptionPane.showMessageDialog(UserPanel, "Insert ID to delete!");
                    return;
                }
                UserModel user = new UserModel();
                user.setId(Integer.parseInt(JTFId.getText()));
                UserDAO dao = new UserDAO();
                try {
                    dao.delete(user);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserScreenDelete");
        frame.setContentPane(new UserScreenDelete().UserScreenDelete);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
