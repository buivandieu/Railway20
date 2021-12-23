package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUltis {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt(){
        while (true){
            try {
                return Integer.parseInt(scanner.next().trim()) ;
            }catch (Exception e){
                System.err.println("nhập lại :");

            }
        }
    }
    public static int inputIntPosttive(){
        while (true){
            try {
                int intPosttive = Integer.parseInt(scanner.next());
                if (intPosttive >= 0 ){
                      return intPosttive ;
                }else {
                    System.err.println(" nhập lại ");
                }
            }catch (Exception e){
                System.err.println("nhập lại ");
            }
        }
    }
    public static Float inputFloat(String i ){
        while (true){
            try {
                return Float.parseFloat(scanner.next()) ;

            }catch (Exception e){
                System.err.println(" nhập lại ");
            }
        }
    }
    public static Double inputFloat(){
        while (true){
            try {
                return Double.parseDouble(scanner.next()) ;

            }catch (Exception e){
                System.err.println(" nhập lại ");
            }
        }
    }
    public static String inputString(){
        while (true){
            String string = scanner.nextLine().trim() ;
            if (!string.isEmpty()){
                return string ;
            }else {
                System.err.println(" 0 nhập lại ");

            }
        }
    }
    public static  LocalDate inputLocalDate(){
        System.out.println(" nhập theo định dạng yyyy - MM - dd");
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        while (true){
            String localDate = scanner.next().trim() ;
            try {
                if (format.parse(localDate)!= null){
                    LocalDate lc = LocalDate.parse(localDate);
                    return lc ;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        }



    }


