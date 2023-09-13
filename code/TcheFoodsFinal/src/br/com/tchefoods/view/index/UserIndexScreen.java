package br.com.tchefoods.view.index;

import br.com.tchefoods.view.UserScreenRegister;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserIndexScreen extends JFrame{
    private JButton JBCreate;
    private JButton JBEdit;
    private JButton JBDelete;
    private JPanel UserIndexPanel;

    public UserIndexScreen(){
        JBCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userScreenRegister = new JFrame("User register");
                userScreenRegister.setContentPane(new UserScreenRegister().getUserPanel());
                userScreenRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userScreenRegister.setSize(600,500);
                userScreenRegister.setVisible(true);
            }
        });
    }

    public JPanel getUserIndexPanel() {
        return UserIndexPanel;
    }
}
