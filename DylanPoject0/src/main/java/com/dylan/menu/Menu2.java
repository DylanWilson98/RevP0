package com.dylan.menu;

import com.dylan.app.Driver;
import com.dylan.dao.GameCollectionDao;
import com.dylan.dao.UserDao;
import com.dylan.models.User;
import com.dylan.services.CollectionServices;
import com.dylan.services.UserServices;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu2 {

    private static final  Scanner scanner = new Scanner(System.in);
    private static final  Main main = new Main();
    private static final   GameCollectionDao gameCollectionDao = new GameCollectionDao();
    private static final  UserDao userDao = new UserDao();

    private static final   CollectionServices cs = new CollectionServices();
    private static final MenuStore menuStore = new MenuStore();
    private static final UserServices us = new UserServices();
    public static final Logger log = Logger.getLogger(Driver.class);


    public static void userMenu(String username) throws SQLException {
       User user = userDao.getByUsername(username);


        System.out.println("Welcome to your account.\n What would you like to do?");
        System.out.println("a. Change Username \nb. Change Password\n " +
                "c. View Game Store \nd. View Collection \ne. Logout");

        char option;
        option = scanner.next().charAt(0);
        // scanner.nextLine();

        switch (option) {
            //change username
            case 'a':


              us.updateUsername(username);
              break;


            // change password
            case 'b':


                us.updatePassword(username);
                break;






                //view game store

            case 'c': MenuStore.storeMenu(username);
                break;



            //view collection
            case 'd':

                System.out.println("*** "+user.getUsername().toUpperCase() +"'s " + "GAME COLLECTION ***\n");

                cs.viewCollection(username);
                break;






            case 'e': Main.mainMenu();
            break;//logout



            default:
                log.info("Default case ran in user menu.");
                System.out.println("Please enter a letter from the given options.\n");
                Menu2.userMenu(username);

        }


    }



}
