package com.dylan.menu;

import com.dylan.app.Driver;
import com.dylan.dao.GameStoreDao;

import com.dylan.dao.UserDao;
import com.dylan.models.User;
import com.dylan.services.StoreServices;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuStore {
    private static final   Scanner scanner = new Scanner(System.in);
    private static final StoreServices ss = new StoreServices();
    private static final Menu2 menu2 = new Menu2();
    private static final GameStoreDao gsd = new GameStoreDao();
    private static final UserDao userDao = new UserDao();
    public static final Logger log = Logger.getLogger(Driver.class);

    public static void storeMenu(String username){

        System.out.println("GAME STORE");
        System.out.println("What would You like to do now?\n" +
                "a. View All Games \n" +
                "b. Add Game to collection\n" +
                "c. Change Rating\n" +
                "d. Back");
        // possibly put add also change rating

// TODO: 2/22/2022 change rating needs to be option
        char option;
        option = scanner.next().charAt(0);



        switch (option) {

            case 'a': {ss.viewGames(username);
            break;}

            case 'b': {  try {

               User user = userDao.getByUsername(username);
                gsd.getUnownedGames(user.getUser_id());
                //gsd.getAllGames(); // new exclude method here
            } catch (SQLException e) {
                e.printStackTrace();
            }
                ss.addToCollection(username);

            break;
            }

            case 'c': {
                try {
                    gsd.getNumberedGames();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.out.println("Which game would you like to rate. Please choose game by their number.");
                Integer game = scanner.nextInt();
                        Integer rating = 0;
                    ss.changeRating(game, rating);

                try {
                    Menu2.userMenu(username);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            break;
            }

            case 'd': {

                try {
                    Menu2.userMenu(username);
                    break;
                } catch (SQLException e) {e.printStackTrace();}

            }

                    default: {
                            log.info("Default case ran in Store Menu");
                        System.out.println("Please enter a letter from the given options.\n");
                        MenuStore.storeMenu(username);
                    }


        }


        }
}
