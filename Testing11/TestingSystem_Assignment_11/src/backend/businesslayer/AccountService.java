package backend.businesslayer;

import backend.datalayer.AcconutRepository;
import backend.datalayer.IAccountRepositiory;
import entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountService  implements  IAccountService{
    private IAccountRepositiory repository;

    public AccountService() throws SQLException {
        repository = new AcconutRepository();
    }

    @Override
    public List<Account> getlistAccount() throws SQLException, ClassNotFoundException, IllegalAccessException {
        return repository.getlistAccount();
    }

    @Override
    public Account getAccountById(int id) throws Exception {
        return repository.getAccountById(id);
    }

    @Override
    public void createAccount(String email, String username, String fullName) throws Exception {
            repository.createAccount(email, username, fullName);
    }

    @Override
    public void updateAccount(int id, String username) throws Exception {
           repository.updateAccount(id, username);
    }

    @Override
    public void deteleAccount(int id) throws Exception {
              repository.deteleAccount(id);
    }

    @Override
    public boolean isAccountIDExists(int id) throws SQLException, ClassNotFoundException, IllegalAccessException {
        return repository.isAccountIDExists(id);
    }

    @Override
    public boolean isAccountExistsNameExists(String username) throws SQLException, ClassNotFoundException, IllegalAccessException {
        return repository.isAccountNameExists(username);
    }
}


