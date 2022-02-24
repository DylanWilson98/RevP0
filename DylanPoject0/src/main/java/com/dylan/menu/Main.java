package com.dylan.menu;

import com.dylan.app.Driver;
import com.dylan.models.User;
import org.apache.log4j.Logger;


import java.util.Scanner;

public class Main {

    private static final  Scanner scanner = new Scanner(System.in);
    private static final   MenuLogin menuLogin = new MenuLogin();
    private static final   MenuCreateAccount mca = new MenuCreateAccount();
    public static final Logger log = Logger.getLogger(Driver.class);


    public static void mainMenu() {




        User currentUser = null;


        System.out.println("Welcome to my Game App!\n Please choose from options below:");
        System.out.println("a. Login\nb. Create New Account\nc. Quit");


        char option;
        option = scanner.next().charAt(0);
        //String input = scanner.nextLine();
        //



        //scanner.nextLine();

        switch (option) {
            // LOGIN SERVICE
            case 'a': {  MenuLogin.login();
            break;}


            //Create User Service
            case 'b': { mca.createAccount();
            break;}

            case 'c': {
               // try {
                   System.out.println("Thanks for coming.");

                    scanner.close();
                    break;

            }

            default: {
                        log.info("default case ran in Main menu");
                System.out.println("Please enter a letter from the given options.\n");
                Main.mainMenu();
            }





        }


    }
}
