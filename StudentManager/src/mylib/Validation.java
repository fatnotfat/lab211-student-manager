/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class Validation {

    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    //ham nay de nhap so nguyen tu ban phim
    //va tra ve so nguyen vua nhap
    //input:msg la cau thong bao cua user
    //code nay co kha nang gay 2 loai error:
    //  - Loi nhap sai format cua ngon ngu 
    //  - Loi nhap num <0
    public static int inputNumber(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.print(msg);
        num = sc.nextInt();
        if (num < 0) {
            throw new Exception();
        }
        return num;
    }

    //ham nay de nhap chuoi tu ban phim
    //va tra ve chuoi vua nhap
    //code nay co kha nang gay error: la chuoi trong
    public static String inputString(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        String str = sc.nextLine();
        if (str.equals("")) {
            throw new Exception();
        }
        return str;
    }

    public static double inputDouble(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        double num = 0;
        System.out.print(msg);
        num = sc.nextDouble();
        if (num < 0) {
            throw new Exception();
        }
        return num;
    }

    public static boolean inputBoolean(String msg) throws Exception {
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        boolean s = sc.nextBoolean();
        if (s != true && s != false) {
            throw new Exception();
        }
        return s;
    }
    //ham nay dung de kiem tra format ma sinh vien co dung hay khong.
    public static boolean checkStudentIDFormat(String ID) {
        try {
            String match = "(^[a-zA-Z]{2}+[0-9]{6}$)";
            if (!ID.matches(match)) {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Wrong format! Please try again!");
            return false;
        }
    }
//ham nay de khiem tra format cua ngay thang nam sinhc o dung voi yeu cau cua de bai hay khong
    public static boolean checkDateFormatValid(String dOB) {
        //tach chuoi va khoi tao mang
        String[] split = dOB.split("/");
        int arr[] = new int[split.length];
        if (split.length != 3) {
            System.out.println("Wrong format! Please type again!");
            return false;
        }
        //doi chuoi thanh kieu so nguyen
        try {
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
        } catch (Exception e) {
            System.out.println("Wrong format! Please type again!");
            return false;
        }
        if (checkDateValid(arr[0], arr[1], arr[2]) == false) {
            System.out.println("Invalid! Please type again!");
            return false;
        }
        return true;
    }

    public static boolean checkLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static boolean checkDateValid(int day, int month, int year) {
        if (year >= 1970 && year <= 2022) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day <= 31) {
                        return true;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day <= 30) {
                        return true;
                    }
                    break;
                case 2:
                    if (day <= 28 || (day == 29 && checkLeapYear(year))) {
                        return true;
                    }
                    return false;

            }
        }
        return false;
    }

    public static boolean checkEmailFormat(String eFormat) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(eFormat);
        if (matcher.matches() == false) {
            System.out.println("Wrong format! Please type again!");
        }
        return matcher.matches();
    }

    public static boolean checkPhoneFormat(String pFormat) {
        try {
            String patrn = "^\\d{10,12}$";
            if (!pFormat.matches(patrn)) {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Wrong format! Please try again!");
            return false;
        }
    }
    
    public static String returnGender(boolean gender){
        if(gender){
            return "Male";
        }
        return "Female";
    }
}
