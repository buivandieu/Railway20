package backend.businesslayer;

import entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    List<Account> getlistAccount() throws SQLException, ClassNotFoundException, IllegalAccessException;
    Account getAccountById(int id) throws Exception ;
    void createAccount(String email, String username, String fullName) throws Exception ;
    void updateAccount(int id, String username) throws Exception;
    void deteleAccount(int id) throws Exception ;
    boolean isAccountIDExists(int id) throws SQLException, ClassNotFoundException, IllegalAccessException;
    boolean isAccountExistsNameExists(String username) throws SQLException, ClassNotFoundException, IllegalAccessException;



}
