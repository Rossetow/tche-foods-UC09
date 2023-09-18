package br.com.tchefoods.view;

import br.com.tchefoods.dao.OrderDAO;
import br.com.tchefoods.dao.UserDAO;
import br.com.tchefoods.model.OrderModel;
import br.com.tchefoods.model.OrderTableModel;
import br.com.tchefoods.model.UserModel;
import br.com.tchefoods.model.UserTableModel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class RelatoryScreen {
    private JLabel JLTitle;
    private JLabel JLTitle2;
    private JTable JTBRelatory;
    private JComboBox JCBMonth;
    private JPanel RelatoryScreen;
    private JTextField JTFDay;
    private JTextField JTFYear;
    private JLabel JLDay;
    private JLabel JLMonth;
    private JLabel JLYear;
    private JButton JBFilter;

    public RelatoryScreen () {
        try {
            initMyTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void initMyTable() throws SQLException, ClassNotFoundException {
        this.JTBRelatory.setModel(new OrderTableModel(getOrders()));
    }

    public List<OrderModel> getOrders() throws SQLException, ClassNotFoundException {
        OrderDAO dao = new OrderDAO();
        return dao.selectAll();
    }
    public static void main(String[] args) {
    }

    public JPanel getRelatoryScreen() {
        return RelatoryScreen;
    }
}
