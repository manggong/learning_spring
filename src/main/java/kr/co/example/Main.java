package kr.co.example;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.debug("Hello World");

        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:~/test;MODE=MySQL;";
            connection = DriverManager.getConnection(url, "sa", "");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from member");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
