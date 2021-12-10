package entity;

public class Employee extends User {
      private String proSkill ;
    public Employee(String name, String email, String password , String proSkill) {
        super();
        this.proSkill = proSkill ;
    }

//    public Employee(int i, String proSkill) {
//        super(i);
//        this.proSkill = proSkill;
//    }

    public Employee(User i,String proSkill) {
        super(i.getName() ,i.getEmail() ,i.getPassword());
        this.proSkill = proSkill;
    }

    public Employee() {
        super();
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Employee{ " +"proSkill='" + proSkill + '\'' +'}'+super.toString();
    }
}
