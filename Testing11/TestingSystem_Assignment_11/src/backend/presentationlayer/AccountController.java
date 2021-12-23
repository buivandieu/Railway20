package backend.presentationlayer;

import backend.businesslayer.AccountService;
import backend.businesslayer.IAccountService;
import entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountController {
    private IAccountService service ;

    public AccountController () throws SQLException {
        service = new AccountService() ;
    }

    public List<Account> getAccount() throws SQLException, ClassNotFoundException, IllegalAccessException {
        return service.getlistAccount();
    }


    public Account getAccountById(int id) throws Exception {
        return service.getAccountById(id);
    }


    public void createAccount(String email, String username, String fullName) throws Exception {
        service.createAccount(email, username, fullName);
    }


    public void updateAccount(int id, String username) throws Exception {
        service.updateAccount(id, username);
    }


    public void deteleAccount(int id) throws Exception {
        service.deteleAccount(id);
    }


    public boolean isAccountIDExists(int id) throws SQLException, ClassNotFoundException, IllegalAccessException {
        return service.isAccountIDExists(id);
    }


    public boolean isAccountExistsNameExists(String username) throws SQLException, ClassNotFoundException, IllegalAccessException {
        return service.isAccountExistsNameExists(username);
    }
}




