package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
    private  Connection connection ;
    public void isConnectedForTesting() throws ClassNotFoundException, SQLException {
        String bdurl = "jdbc:mysql://localhost:3306/assignment_1?useSSL=false ";
        String username = "root" ;
        String password = "root" ;

        Class.forName("com.mysql.cj.jdbc.Driver");

      connection = DriverManager.getConnection(bdurl, username, password);
        try {
            if (connection != null){
                System.out.println("Connect success!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
   public Connection connect() throws ClassNotFoundException, SQLException,  IllegalAccessException {
       String bdurl = "jdbc:mysql://localhost:3306/assignment_1?useSSL=false ";
       String username = "root" ;
       String password = "root" ;


       Class.forName("com.mysql.cj.jdbc.Driver");


        connection = DriverManager.getConnection(bdurl, username, password);

        return connection;
   }

   public void disconnect() throws SQLException {
        connection.close();
   }

}
