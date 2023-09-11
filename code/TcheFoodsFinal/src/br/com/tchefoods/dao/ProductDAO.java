package br.com.tchefoods.dao;

import br.com.tchefoods.infra.ConnectionMysql;
import br.com.tchefoods.model.ProductModel;
import br.com.tchefoods.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

    public void save(ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql connectionMysql = new ConnectionMysql();
        Connection con = null;

        con = connectionMysql.getConection();
        PreparedStatement stmt = null;

        stmt = con.prepareStatement("INSERT INTO user(name ,price, categoryId ) VALUES (?,?,?)");

        stmt.setString(1, product.getName());
        stmt.setFloat(2, product.getPrice());
        stmt.setInt(3, product.getCategoryId());

        stmt.executeUpdate();
    }
    public void edit (ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("UPDATE tb_user SET user_name = ?, set_price = ?, set_categoryId = ? WHERE user_id = ?");
        stmt.setString(1, product.getName());
        stmt.setInt(2, product.getCategoryId());
        stmt.setFloat(3, product.getPrice());
        stmt.setInt(4,product.getId());
        stmt.executeUpdate();
    }

    public void delete(ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("DELETE FROM tb_user WHERE id = ?");
        stmt.setInt(1, product.getId());
        ResultSet rs = stmt.executeQuery();
    }
}
