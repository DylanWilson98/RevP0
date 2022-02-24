package com.dylan.menu;

import com.dylan.services.UserServices;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuLogin {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserServices us = new UserServices();
    private static final Main main = new Main();
    private static final Menu2 m2 = new Menu2();

    // TODO: 2/22/2022 Problem here causes app to throw exception when closed (no such element)
    public static void login(){



        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        boolean signInResponse = us.correctCredentials(username, password);

        if(signInResponse) {

            System.out.println("Successfully logged in...");
            try {
                Menu2.userMenu(username);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else {
            System.out.println("Credentials do not match.\n\n");
            MenuLogin.login();


            
            
        }
    }


}
