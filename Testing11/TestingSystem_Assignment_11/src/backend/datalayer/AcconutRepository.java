package backend.datalayer;

import entity.Account;
import utils.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcconutRepository  implements IAccountRepositiory {
   private jdbc jd ;

    public AcconutRepository() throws SQLException {
        jd = new jdbc() ;
    }




    @Override
    public List<Account> getlistAccount() throws SQLException, ClassNotFoundException, IllegalAccessException {
        List<Account> acconutList = new ArrayList<>();

        Connection connection = jd.connect();

        String sql = "SELECT AccountID ,Email,Username,FullName FROM assignment_1.account;";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Account acconut = new Account(
                    resultSet.getInt("AccountID"),
                    resultSet.getString("Email"),
                    resultSet.getString("Username"),
                    resultSet.getString("FullName") );
            acconutList.add(acconut);
        }
        jd.disconnect();
        return acconutList ;
    }

    @Override
    public Account getAccountById(int id) throws Exception {
        Connection connection = jd.connect();

        String sql = "SELECT * FROM assignment_1.account WHERE AccountID = ? ;";

       PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
        preparedStatement.setInt(1 , id );


        ResultSet resultSet = preparedStatement.executeQuery();
       if (resultSet.next()){
           Account account = new Account(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)) ;
           jd.disconnect();
           return account;
       }else {
           throw new Exception("Account.getAccountByID.cannotFindAccountById") ;
       }
    }

    @Override
    public boolean isAccountIDExists(int id) throws SQLException, ClassNotFoundException, IllegalAccessException {
        Connection connection = jd.connect();

        String sql = "SELECT * FROM assignment_1.account where AccountID = ? ";;

        PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
        preparedStatement.setInt(1 , id );

       ResultSet resultSet = preparedStatement.executeQuery();
       if (resultSet.next()){
           System.out.println(" :"+resultSet.next());
           jd.disconnect();
           return true ;
       }else {
           jd.disconnect();
           return false ;
       }
    }

    @Override
    public boolean isAccountNameExists(String username) throws SQLException, ClassNotFoundException, IllegalAccessException {
        Connection connection = jd.connect();

        String sql = "SELECT * FROM assignment_1.account where Username = ? ";;

        PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
        preparedStatement.setString(1 , username );

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println(" :"+resultSet.next());
            jd.disconnect();
            return true ;
        }else {
            jd.disconnect();
            return false ;
        }
    }

    @Override
    public void createAccount(String email, String username, String fullName) throws Exception {

        Connection connection = jd.connect();

        String sql = "INSERT INTO `assignment_1`.`account` (`Email`, `Username`, `FullName`) VALUES (? ,? ,?)";;

        PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
        preparedStatement.setString(1 ,email);
        preparedStatement.setString(2 ,username);
        preparedStatement.setString(3,fullName);


      int check =   preparedStatement.executeUpdate();
        System.out.println(check > 0 ? "tao moi thanh cong " : " tao moi that bai ");
       jd.disconnect();
    }

    @Override
    public void updateAccount(int id, String username) throws Exception {
        Connection connection = jd.connect();
        String sql = "  UPDATE `assignment_1`.`account` SET  `Username` = ? WHERE (`AccountID` = ?);    " ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1 ,username);
        preparedStatement.setInt(2 , id );
      int check =  preparedStatement.executeUpdate() ;
        System.out.println(check > 0 ? "update thanh cong " : " updat that bai ");
        jd.disconnect();
    }

    @Override
    public void deteleAccount(int id) throws Exception {
         if (!isAccountIDExists(id)){
             throw  new Exception("Account.getAccountByID.cannotFindAccountById"+id) ;
        }

         Connection connection = jd.connect();

         String sql = "DELETE FROM `Account`  WHERE AccountID = ? ";

         PreparedStatement preparedStatement = connection.prepareStatement(sql);

         preparedStatement.setInt(1 , id );
        int check =  preparedStatement.executeUpdate() ;

        System.out.println(check > 0 ? "delete thanh cong " : " delete that bai ");
        jd.disconnect();
    }


}
