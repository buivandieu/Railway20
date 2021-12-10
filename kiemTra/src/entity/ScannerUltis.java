package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUltis {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt(String mes , String err ){
        System.out.println(mes);
        while (true){
            try {
                return Integer.parseInt(scanner.next().trim()) ;
            }catch (Exception e){
                System.err.println(err);

            }
        }
    }
    public static int inputIntPosttive(String mes , String err ){
        while (true){
            try {
                int intPosttive = Integer.parseInt(scanner.next());
                if (intPosttive >= 0 ){
                      return intPosttive ;
                }else {
                    System.err.println(err);
                }
            }catch (Exception e){
                System.err.println(err);
            }
        }
    }
    public static Float inputFloat(String mes , String err ){
             System.out.println(mes);
        while (true){
            try {
                return Float.parseFloat(scanner.next()) ;

            }catch (Exception e){
                System.err.println(err);

            }
        }
    }
    public static Double inputDouble(String mes , String err ){
        System.out.println(mes);
        while (true){
            try {
                return Double.parseDouble(scanner.next()) ;

            }catch (Exception e){
                System.err.println(err);
            }
        }
    }
    public static String inputString(String mes , String err ){
        System.out.println(mes);
        while (true){
            String string = scanner.nextLine().trim() ;
            if (!string.isEmpty()){
                return string ;
            }else {
                System.err.println(err);

            }
        }
    }
    public static  LocalDate inputLocalDate(String mes , String err ){
        System.out.println(mes);
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
                System.err.println(err);
                e.printStackTrace();
            }
        }


        }



    }


