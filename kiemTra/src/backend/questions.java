package backend;

import entity.Admin;
import entity.Employee;
import entity.ScannerUltis;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class questions {
    List<User> userList = new ArrayList<>();
//    ScannerUltis sc = new ScannerUltis();
      Scanner sc = new Scanner(System.in);
    public void One(){
        Admin admin = new Admin("dieu" ,"buivandieu@gmail.com","12345",4);
        Employee employee = new Employee("an ","an@gmail.com","asd123" ,"java");

        System.out.println(admin);
        System.out.println(employee);
              while (true){
                  menus();
                  int choose = sc.nextInt();
                  switch (choose){
                      case 1:
                            User user = new User(1);
                          System.out.println("day se la 1.admin hay la 2.employee ");
                          int i = ScannerUltis.inputInt("day se la 1.admin hay la 2.employee ","nhap sai dinh danh moi nhap lai") ;
                          switch (i){
                              case 1 :
                                  User admin1 = new Admin(user ,ScannerUltis.inputIntPosttive("moi nhap vao so nam kinh nghiem " ,"nhap lai")) ;
                                  userList.add(admin1) ;
                                  break;
                              case 2 :
                                  User admin2 = new Employee(user ,ScannerUltis.inputString("moi nhap chuyen nghan ","nhap lai")) ;
                                  userList.add(admin2) ;
                                  break;
                              default:
                                  userList.add(user) ;
                                  break;
                          }
                          break;
                      case 2:

                      default:
                          break;
                  }
              }



    }
    public void menus(){
        System.out.println("========== moi ban chon chuc nang==========");
        System.out.println("        1 . them moi  user");
    }
    public void Two(){

    }
public void five(String email , String password){
        if (validateEmail(email) && validatePassword(password)){
            System.out.println("valiDate thanh cong");
        }else {
            System.out.println("valiDate that bai ");
        }
}

    private boolean validatePassword(String password) {

        // Password: nhập từ 6 tới 12 ký tự, có ít nhất 1 ký tự viết hoa
        return  false ;
    }

    private boolean validateEmail(String email) {
      // email hop le phai chua mot va chi mot @ va khong the tan cung hoac bat dau bang @

      return false;
    };


}
