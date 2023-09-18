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

        stmt = con.prepareStatement("INSERT INTO tb_product(product_name ,product_price, product_category_id ) VALUES (?,?,?)");

        stmt.setString(1, product.getName());
        stmt.setFloat(2, product.getPrice());
        stmt.setInt(3, product.getCategoryId());

        stmt.executeUpdate();
    }
    public void edit (ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("UPDATE tb_product SET product_name = ?, product_price = ?, product_category_id = ? WHERE product_id = ?");
        stmt.setString(1, product.getName());
        stmt.setFloat(2, product.getPrice());
        stmt.setInt(3, product.getCategoryId());
        stmt.setInt(4,product.getId());
        stmt.executeUpdate();
    }

    public void delete(ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("DELETE FROM tb_product WHERE product_id = ?");
        stmt.setInt(1, product.getId());
        stmt.executeUpdate();
    }

    public ArrayList<ProductModel> selectAll() throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT product_id, product_name, product_price, c.category_desc FROM tb_product as p" +
                "INNER JOIN tb_category as c on c.category_id = p.product_category_id;");
        ResultSet rs = stmt.executeQuery();

        ArrayList<ProductModel> output = new ArrayList<>();
        while(rs.next()){
            ProductModel addProduct = new ProductModel();
            addProduct.setId(rs.getInt("product_id"));
            addProduct.setName(rs.getString("product_name"));
            addProduct.setPrice(rs.getFloat("product_price"));
            addProduct.setCategoryDesc(rs.getString("c.category_desc"));
            output.add(addProduct);
        }
        return (output);
    }

    public ProductModel selectById(ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT product_id, product_name, c.category_desc, product_price FROM tb_product as p" +
                "INNER JOIN tb_category as c on c.category_id = product_category_id " +
                "WHERE product_id = ?;");
        stmt.setInt(1, product.getId());
        ResultSet rs = stmt.executeQuery();
        rs.next();

        ProductModel addProduct = new ProductModel();
        addProduct.setId(rs.getInt("product_id"));
        addProduct.setName(rs.getString("product_name"));
        addProduct.setPrice(rs.getFloat("product_price"));
        addProduct.setCategoryDesc(rs.getString("c.category_desc"));
        return addProduct;
    }

    public ProductModel selectByName(ProductModel product) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;
       /* product.setName("'"+product.getName() + "'"); */

        stmt = conn.prepareStatement("SELECT product_id, product_name, c.category_desc, product_price FROM tb_product as p" +
                "INNER JOIN tb_category as c on c.category_id = product_category_id " +
                "WHERE product_name = ?;");
        stmt.setString(1, product.getName());
        ResultSet rs = stmt.executeQuery();
        rs.next();

        ProductModel addProduct = new ProductModel();
        addProduct.setId(rs.getInt("product_id"));
        addProduct.setName(rs.getString("product_name"));
        addProduct.setPrice(rs.getFloat("product_price"));
        addProduct.setCategoryDesc(rs.getString("c.category_desc"));
        return addProduct;
    }
}
