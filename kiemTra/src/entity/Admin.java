package entity;

public class Admin extends User{
          private int expInYear ;
    public Admin(String name, String email, String password , int expInYear) {
        super(name, email, password);
        this.expInYear = expInYear ;

    }

    public Admin() {
        super();
    }

    public Admin(User user , int expInYear) {
        super(user.getName() , user.getEmail(), user.getPassword() );

        this.expInYear = expInYear ;


    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "expInYear=" + expInYear +
                '}'+super.toString() ;
    }
}
