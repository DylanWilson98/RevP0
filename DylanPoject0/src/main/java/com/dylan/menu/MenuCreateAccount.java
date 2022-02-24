package com.dylan.menu;

import com.dylan.services.UserServices;


import java.util.Scanner;

public class MenuCreateAccount {
    public  Scanner scanner = new Scanner(System.in);
    UserServices us = new UserServices();
    Main main = new Main();

    //changed logic to put whole password section in an else to stop no such element exception

    public  void createAccount() {
        System.out.println("Please create new username: ");

        String username = scanner.nextLine();

        if(username.equals("")) {

            System.out.println("Username must be at least 1 character\n");
            Main.mainMenu();

        }else{
            System.out.println("Please create a new password: ");

            String password = scanner.nextLine();
            if(password.equals("")){

                System.out.println("Password must be at least 1 character\n");
                Main.mainMenu();

            }else{

                    us.createAccount(username, password);
                    System.out.println("Account created. Please log in.\n\n");
                    Main.mainMenu();


            }

        }

    }//method

}//class
