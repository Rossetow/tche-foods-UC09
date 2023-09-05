package br.com.tchefoods.infra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionMysql {
    private String serverName = "127.0.0.1";
    private String user = "root";
    private String password = "senac";
    private String dataBaseName = "db_tchefoods_final";

    public Connection obterConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://" + this.serverName + ":3306/" + this.dataBaseName;

        Connection connection = null;

        connection = DriverManager.getConnection(url, user, password);
        return connection;

    }
}

