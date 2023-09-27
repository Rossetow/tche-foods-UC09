package br.com.tchefoods.view.index;

import br.com.tchefoods.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen {
    private JPanel HomePanel;
    private JButton JBUserRegister;
    private JButton JBUserEdit;

    public static void main(String[] args) {
        JFrame frame = new JFrame("HomeScreen");
        frame.setContentPane(new HomeScreen().HomePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton JBUserDelete;
    private JButton JBOrderCreate;
    private JButton JBProductDelete;
    private JButton JBProductEdit;
    private JButton JBProductRegister;
    private JButton JBCategoryCreate;
    private JButton JBCategoryEdit;
    private JButton JBCategoryDelete;
    private JButton JBRelatoryOpen;
    private JButton JBUserView;
    private JButton JBProductView;
    private JButton JBCategoryView;
    private JButton JBUser;

    public HomeScreen() {
        JBUserRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new UserScreenRegister().getUserPanel());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBUserEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new UserScreenEdit().getUserPanel());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBUserDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new UserScreenDelete().getUserPanel());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBOrderCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new OrderAndPaymentScreen().getPanelOrder());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBProductRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new ProductScreenRegister().getJPProductScreenRegister());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBProductEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new ProductScreenEdit().getJPProductScreenEdit());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });


        JBProductDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new ProductScreenDelete().getJPProductScreenDelete());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBCategoryCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new ProductCategoryScreen().getJPProductCategory());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBRelatoryOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new RelatoryScreen().getRelatoryScreen());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBUserView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new UserScreenConsult().getPanelUserConsult());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
        JBProductView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userIndexScreen = new JFrame();
                userIndexScreen.setContentPane(new ProductScreenView().getPanelScreenView());
                userIndexScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                userIndexScreen.pack();
                userIndexScreen.setVisible(true);
            }
        });
    }

}
