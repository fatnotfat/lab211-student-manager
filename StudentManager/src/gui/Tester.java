/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import mylib.Menu;

/**
 *
 * @author admin
 */
public class Tester {

    public static void main(String[] args) {
        Menu menu = new Menu();
        int choice;
        do {
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    menu.function1();
                    break;
                case 2:
                    menu.function2();
                    break;
                case 3:
                    menu.function3();
                    break;
                case 4:
                    menu.function4();
                    break;
                case 5:
                    menu.function5();
                    break;
                case 6:
                    menu.function6();
                    break;
                case 7:
                    menu.function7();
                    break;
            }
        } while (choice < 8);
        System.out.println("Goodbye! ");
        System.out.println("By Nguyen Tien Phat - SE160374");
    }
}
