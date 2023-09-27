package br.com.tchefoods.view;

import br.com.tchefoods.dao.OrderDAO;
import br.com.tchefoods.model.OrderModel;
import br.com.tchefoods.model.OrderTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class RelatoryScreen {
    private JLabel JLTitle;
    private JLabel JLTitle2;
    private JTable JTBRelatory;
    private JComboBox JCBMonth;
    private JPanel PanelRelatory;
    private JTextField JTFDay;
    private JTextField JTFYear;
    private JLabel JLDay;
    private JLabel JLMonth;
    private JLabel JLYear;
    private JButton JBFilter;

    public RelatoryScreen () {

        this.JCBMonth.setModel(new DefaultComboBoxModel(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));

        try {
            initMyTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        JBFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JTFDay.getText().isEmpty()||JTFYear.getText().isEmpty()){
                    JOptionPane.showMessageDialog(PanelRelatory, "Enter the date, please.");
                    return;
                }
                String date =(JTFDay.getText()+"/"+JCBMonth.getSelectedItem()+"/"+JTFYear.getText());
                try {
                    JTBRelatory.setModel(new OrderTableModel(getOrdersByDate(date)));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void initMyTable() throws SQLException, ClassNotFoundException {
        this.JTBRelatory.setModel(new OrderTableModel(getOrders()));
    }

    public List<OrderModel> getOrders() throws SQLException, ClassNotFoundException {
        OrderDAO dao = new OrderDAO();
        return dao.selectAll();
    }

    public List<OrderModel> getOrdersByDate(String date) throws SQLException, ClassNotFoundException {
        OrderDAO dao = new OrderDAO();
        return dao.selectByDate(date);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RelatoryScreen");
        frame.setContentPane(new RelatoryScreen().PanelRelatory);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getRelatoryScreen() {
        return PanelRelatory;
    }
}
