package br.com.tchefoods.dao;

import br.com.tchefoods.infra.ConnectionMysql;
import br.com.tchefoods.model.CategoryModel;
import br.com.tchefoods.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

    public void save (UserModel user) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("INSERT INTO tb_user (user_name, user_surname, user_email, user_password, user_cellphone, user_adress, user_gender) VALUES (?, ?, ?, ?, ?, ?, ?)");

        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getEmail());
        stmt.setBytes(4, user.getPassword());
        stmt.setString(5, user.getCellphone());
        stmt.setString(6, user.getAdress());
        stmt.setString(7, user.getGender());
        stmt.executeUpdate();
    }

    public void edit (UserModel user) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("UPDATE tb_user SET user_name = ?, user_surname = ?, user_email = ?, user_cellphone = ?, user_adress = ?, user_gender = ? WHERE user_id = ?");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getCellphone());
        stmt.setString(5, user.getAdress());
        stmt.setString(6, user.getGender());
        stmt.setInt(7, user.getId());
        stmt.executeUpdate();
    }

    public ArrayList<UserModel> selectAll() throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT user_id, user_name, user_surname, user_email, user_cellphone, user_adress, user_gender FROM tb_user");
        ResultSet rs = stmt.executeQuery();
        ArrayList<UserModel> output = new ArrayList<UserModel>();

        while(rs.next()){
            UserModel addUser = new UserModel();
            addUser.setId(rs.getInt("user_id"));
            addUser.setName(rs.getString("user_name"));
            addUser.setSurname(rs.getString("user_surname"));
            addUser.setEmail(rs.getString("user_email"));
            addUser.setCellphone(rs.getString("user_cellphone"));
            addUser.setAdress(rs.getString("user_adress"));
            addUser.setGender(rs.getString("user_gender"));
            output.add(addUser);
        }
        return (output);
    }

    public UserModel selectById(UserModel user) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT user_id, user_name, user_surname, user_email, user_cellphone, user_adress, user_gender FROM tb_user WHERE user_id = ?");
        stmt.setInt(1, user.getId());
        ResultSet rs = stmt.executeQuery();
        rs.next();

        UserModel addUser = new UserModel();
        addUser.setId(rs.getInt("user_id"));
        addUser.setName(rs.getString("user_name"));
        addUser.setSurname(rs.getString("user_surname"));
        addUser.setEmail(rs.getString("user_email"));
        addUser.setCellphone(rs.getString("user_cellphone"));
        addUser.setAdress(rs.getString("user_adress"));
        addUser.setGender(rs.getString("user_gender"));
        return addUser;
    }

    public UserModel selectByName (UserModel user){
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("SELECT user_id, user_name, user_surname, user_email, user_cellphone, user_adress, user_gender FROM tb_user WHERE user_name LIKE %?%");
        stmt.setString(1, user.getName());
        ResultSet rs = stmt.executeQuery();
        rs.next();

        UserModel addUser = new UserModel();
        addUser.setId(rs.getInt("user_id"));
        addUser.setName(rs.getString("user_name"));
        addUser.setSurname(rs.getString("user_surname"));
        addUser.setEmail(rs.getString("user_email"));
        addUser.setCellphone(rs.getString("user_cellphone"));
        addUser.setAdress(rs.getString("user_adress"));
        addUser.setGender(rs.getString("user_gender"));
        return addUser;
    }

    public void delete(UserModel user) throws SQLException, ClassNotFoundException {
        ConnectionMysql conexaoMysql = new ConnectionMysql();
        Connection conn = conexaoMysql.getConection();
        PreparedStatement stmt = null;

        stmt = conn.prepareStatement("DELETE FROM tb_user WHERE user_id = ?");
        stmt.setInt(1, user.getId());
        stmt.executeUpdate();
    }


}
