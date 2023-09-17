package br.com.tchefoods.dao;

import br.com.tchefoods.infra.ConnectionMysql;
import br.com.tchefoods.model.CategoryModel;
import br.com.tchefoods.model.OrderModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Clock;

public class OrderDAO {
    public void save(OrderModel order) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO tb_oder VALUES (?, ?, ?, ?, ?)");

        stmt.setInt(1, order.getUserId());
        stmt.setInt(2, order.getProductId());
        stmt.setInt(3, order.getPaymentMethodId());
        stmt.setString(4, ""+Clock.systemUTC().instant());
        stmt.setFloat(5, order.getTotal());
        stmt.executeUpdate();
    }
}
