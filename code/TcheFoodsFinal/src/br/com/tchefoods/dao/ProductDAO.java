package br.com.tchefoods.dao;

import br.com.tchefoods.infra.ConnectionMysql;
import br.com.tchefoods.model.ProductModel;

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

        stmt.setString(3, product.getCategoryId());

        stmt.executeUpdate();
    }
    public void edit(ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("UPDATE tb_category SET WHERE id = ?");
        stmt.setInt(1, product.getId());
    }

    public ArrayList<ProductModel> selectAll (ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT desc FROM tb_product");
        ResultSet rs = stmt.executeQuery();
        ArrayList<ProductModel> output = new ArrayList<ProductModel>();

        while(rs.next()){

            product.setId(rs.getInt("desc"));
            output.add(product);
        }
        return (output);
    }
}
