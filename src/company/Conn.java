package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    public Connection connection;
    public Statement statement;

    public Conn(){
        String userName = "root";
        String pass = "Welcome123";
        String url = "jdbc:mysql://localhost:3306/forkhaki";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,userName,pass);
            statement = connection.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}
