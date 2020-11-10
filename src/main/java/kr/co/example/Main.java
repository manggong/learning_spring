package kr.co.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Hello world");
    }

    Connection connection = null;
    Statement statement = null;
    try {
        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:~/test;MODE=MySQL";
        connection = DriverManager.getConnection(url, "sa", "");
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from member");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");

            logger.info("id: " + id);
        }
    } catch(ClassNotFoundException e) {
        e.printStackTrace();
    } catch(SQLException e) {
        e.printStackTrace();
    }
}

