package entity;

public class Account {
    private  int AccountID ;
    private  String Email ;
    private  String Username ;
    private  String FullName ;

    public Account(int accountID, String email, String username, String fullName) {
        this.AccountID = accountID;
        this.Email = email;
       this.Username= username;
        this.FullName = fullName;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountID=" + AccountID +
                ", Email='" + Email + '\'' +
                ", Username='" + Username + '\'' +
                ", FullName='" + FullName + '\'' +
                '}';
    }
}
