package front_end;

import backend.presentationlayer.AccountController;
import entity.Account;
import utils.ScannerUltis;
import utils.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class program {
    private static AccountController accountController;

    public static void main(String[] args) throws Exception {
        accountController = new AccountController();
           while (true){
               menuAccount();
               int choose = ScannerUltis.inputInt() ;
               switch (choose){
                   case 1 :
                       System.out.println("======List account=====");
                       getlistAccount();
                       break;
                   case 2 :
                       System.out.println("=======Get account by id======");
                       getAccountbyID();
                       break;
                   case 3 :
                       System.out.println("=========Create account=========");
                       createAccount();
                       break;
                   case 4 :
                       System.out.println("=========Update account=========");
                       updateAccount();
                       break;
                   case 5 :
                       System.out.println("=========Delete account=========");
                      deleteAccount();
                       break;
                   case 6 :
                       System.out.println("ban co muon tiep tuc su dung chuong trinh vui long chon : ");
                       System.out.println("   1 . YES   ; 2 . NO ");
                       int check  = ScannerUltis.inputInt();
                      switch (check){
                          case 1 :
                              continue;
                          case 2 :
                           System.out.println("cam on ban da su dung chuong trinh ");
                              return;
                          default:
                              System.out.println("ban chon sai chuc nang");
                      }
                   default:
                       System.out.println("input wrong ! please input again.");

                       break;
               }
           }


    }

    private static void menuAccount() {
        System.out.println("============MENU===========");
        System.out.println("=|1. Get list account    |=");
        System.out.println("=|2. Get account by id   |=");
        System.out.println("=|3. Create account      |=");
        System.out.println("=|4. Update account      |=");
        System.out.println("=|5. Delete account      |=");
        System.out.println("=|6. Exit                |=");
        System.out.println("===========================");
        System.out.print("You choose: ");
    }

    private static void  getlistAccount() throws SQLException, ClassNotFoundException, IllegalAccessException {
        List<Account> accounts = accountController.getAccount() ;

        for (Account i : accounts){
            System.out.println(i);
        }

    }

    private static void getAccountbyID() throws Exception {
        System.out.println("nhap id ");
        int id = ScannerUltis.inputIntPosttive();

        Account account = accountController.getAccountById(id) ;
    }

   private  static void  createAccount() throws Exception {

       System.out.println("input email :");
       String email = ScannerUltis.inputString() ;

       System.out.println("input username :");
       String username = ScannerUltis.inputString() ;

       System.out.println("input Fullname :");
       String Fullname = ScannerUltis.inputString() ;

       accountController.createAccount(email ,username ,Fullname);

   }

   private static void  updateAccount() throws Exception {
       System.out.println("input id :");
       int id = ScannerUltis.inputIntPosttive() ;

       System.out.println("input username :");
       String username = ScannerUltis.inputString() ;

       accountController.updateAccount(id , username);
   }

    private static void  deleteAccount() throws Exception {
        System.out.println("input id :");
        int id = ScannerUltis.inputIntPosttive() ;



        accountController.deteleAccount(id );
    }

}

