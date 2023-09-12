package br.com.tchefoods.view.index;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {
    private JPanel HomePanel;
    private JButton JBUser;
    private JButton JBOrder;
    private JButton JBProduct;
    private JButton JBCategory;
public HomeScreen() {
    JBUser.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame userIndexScreen = new JFrame("User administration");
            userIndexScreen.setContentPane(new UserIndexScreen().getUserIndexPanel());
            userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            userIndexScreen.pack();
            userIndexScreen.setVisible(true);
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("HomeScreen");
        frame.setContentPane(new HomeScreen().HomePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
