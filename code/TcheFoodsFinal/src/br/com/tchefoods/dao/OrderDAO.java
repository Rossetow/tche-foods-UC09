package br.com.tchefoods.dao;

import br.com.tchefoods.infra.ConnectionMysql;
import br.com.tchefoods.model.CategoryModel;
import br.com.tchefoods.model.OrderModel;
import br.com.tchefoods.model.PaymentMethodModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;

public class OrderDAO {
    public void save(OrderModel order) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO tb_oder(order_user_id, order_paymentmethod_id, order_datetime, order_total) VALUES (?, ?, ?, ?, ?)");

        stmt.setInt(1, order.getUserId());
        stmt.setInt(2, order.getProductId());
        stmt.setInt(3, order.getPaymentMethodId());
        stmt.setString(4, order.getDateTime());
        stmt.setFloat(5, order.getTotal());
        stmt.executeUpdate();
    }

    public ArrayList<OrderModel> selectAll() throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT order_id, order_user_id, order_product_id order_paymentmethod_id, order_datetime, order_total FROM tb_paymentmethod");
        ResultSet rs = stmt.executeQuery();

        ArrayList<OrderModel> output = new ArrayList<>();
        while(rs.next()){
            OrderModel addOrder = new OrderModel();
            addOrder.setId(rs.getInt("paymentmethod_id"));
            addOrder.setUserId(rs.getInt("order_user_id"));
            addOrder.setProductId(rs.getInt("order_product_id"));
            addOrder.setPaymentMethodId(rs.getInt("order_paymentmethod_id"));
            addOrder.setDateTime(rs.getString("order_datetime"));
            addOrder.setTotal(rs.getFloat("order_total"));
            output.add(addOrder);
        }
        return (output);
    }

    public ArrayList<OrderModel> selectByDate(String date) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT order_id, order_user_id, order_product_id, order_paymentmethod_id, order_datetime, order_total FROM tb_paymentmethod WHERE order_datetime = ?");
        stmt.setString(1, date);
        ResultSet rs = stmt.executeQuery();

        ArrayList<OrderModel> output = new ArrayList<>();
        while(rs.next()){
            OrderModel addOrder = new OrderModel();
            addOrder.setId(rs.getInt("paymentmethod_id"));
            addOrder.setUserId(rs.getInt("order_user_id"));
            addOrder.setProductId(rs.getInt("order_product_id"));
            addOrder.setPaymentMethodId(rs.getInt("order_paymentmethod_id"));
            addOrder.setDateTime(rs.getString("order_datetime"));
            addOrder.setTotal(rs.getFloat("order_total"));
            output.add(addOrder);
        }
        return (output);
    }
}
