package entity;

public class User {
    public static int count = 0 ;
    private int id ;
    private String name ;
    private String email ;
    private String password ;

    public User( String name, String email, String password) {

        this.id =  ++count;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(int i) {

       String inputAgain = "nhap lai" ;
        this.id = ++count;
        this.name = ScannerUltis.inputString("moi nhap ten user",inputAgain);
        this.email =  ScannerUltis.inputString("moi nhap email user",inputAgain);;
        this.password =  ScannerUltis.inputString("moi nhap password user",inputAgain);;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
