package org.example.atvlpi3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    private static final String url = "jdbc:mysql://localhost:3306/AtvLPI?useTimezone=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "Einstein_12!";

    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Atualizado para o driver MySQL
                conn = DriverManager.getConnection(url, user, password);
            }

            return conn;

        } catch(SQLException e){
            //e.printStackTrace();
            System.err.println("Falha ao conectar ao banco de dados: " + e.getMessage());
            return null;
        } catch(ClassNotFoundException e){
            //throw new RuntimeException(e);
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            return null;
        }
    }

    public static void testConnection() {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } else {
            System.out.println("Falha na conexão com o banco de dados.");
        }
    }

}
