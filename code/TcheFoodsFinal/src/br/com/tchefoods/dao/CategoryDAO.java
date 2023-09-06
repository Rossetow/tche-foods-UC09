package br.com.tchefoods.dao;

import br.com.tchefoods.infra.ConnectionMysql;
import br.com.tchefoods.model.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public void save(CategoryModel category) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO tb_category VALUES (?)");

        stmt.setString(1, category.getDesc());
        stmt.executeUpdate();
    }

    public void edit(CategoryModel category) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("UPDATE tb_category SET desc = ? WHERE id = ?");
        stmt.setString(1, category.getDesc());
        stmt.setInt(2, category.getId());
    }

    public ArrayList<CategoryModel> selectAll (CategoryModel category) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT desc FROM tb_category");
        ResultSet rs = stmt.executeQuery();
        ArrayList<CategoryModel> output = new ArrayList<CategoryModel>();

        while(rs.next()){
            CategoryModel category = new CategoryModel();
            category.setId(rs.getInt("desc"));
            category.setDesc(rs.getString("desc"));
            output.add(category);
        }
        return (output);
    }
}
