package front_end;

import utils.jdbc;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        jdbc jdbc = new jdbc() ;
        jdbc.isConnectedForTesting();
    }
}
