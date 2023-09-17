package br.com.tchefoods.dao;

import br.com.tchefoods.infra.ConnectionMysql;
import br.com.tchefoods.model.OrderModel;
import br.com.tchefoods.model.PaymentMethodModel;
import br.com.tchefoods.model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;

public class PaymenthMethodDAO {
    public void save(PaymentMethodModel paymenthMethod) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO tb_paymenthmethod VALUES (?)");

        stmt.setString(1, paymenthMethod.getDesc());
        stmt.executeUpdate();
    }

    public ArrayList<PaymentMethodModel> selectAll() throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT paymentmethod_id, paymentmethod_desc FROM tb_paymentmethod");
        ResultSet rs = stmt.executeQuery();

        ArrayList<PaymentMethodModel> output = new ArrayList<>();
        while(rs.next()){
            PaymentMethodModel addPaymentMethod = new PaymentMethodModel();
            addPaymentMethod.setId(rs.getInt("paymentmethod_id"));
            addPaymentMethod.setDesc(rs.getString("paymentmethod_desc"));
            output.add(addPaymentMethod);
        }
        return (output);
    }
}
