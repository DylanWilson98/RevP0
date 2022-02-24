package com.dylan.menu;

import com.dylan.app.Driver;
import com.dylan.dao.UserDao;
import com.dylan.models.User;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuCollection {
    private static final  Menu2 menu2 = new Menu2();
    private static final  Scanner scanner = new Scanner(System.in);

    private static final UserDao userDao = new UserDao();
    private static final MenuStore menuStore = new MenuStore();
    public static final Logger log = Logger.getLogger(Driver.class);
    public static void CollectionMenu(String username) {
        try {
          User  user = userDao.getByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("What would You like to do now?\n" +
                "a. View Game Store\n" +
                "b. Back");
        char option;
        option = scanner.next().charAt(0);




        switch (option) {

            case 'a': {
                MenuStore.storeMenu(username);
            break;}    //view game store


            case 'b': {try {
                Menu2.userMenu(username); //back
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;

            }

            default: { log.info("Default case ran in Collection menu");
                System.out.println("Please enter a letter from the given options.\n");
                MenuCollection.CollectionMenu(username);

            }



        }




    }
}
