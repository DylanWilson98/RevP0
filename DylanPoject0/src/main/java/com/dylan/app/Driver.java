package com.dylan.app;


import com.dylan.menu.Main;
import org.apache.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Driver {
    public static final Logger log = Logger.getLogger(Driver.class);

    public static Scanner scanner = new Scanner(System.in);

    private static final   Main main = new Main();



    public static void main(String[] args) {
        log.info("Hello from top of main method in driver!");
        try{

            Main.mainMenu();

        }catch (NoSuchElementException e){
            System.out.println("Thanks for coming.");
                log.warn("No Such Element Exception caught in driver!");
            scanner.close();
        }

    }
}


        //Print game with rating


//        try {
//            GameStore genshin = gameStoreDao.getGame("Genshin Impact");
//            gameStoreDao.updateRating(genshin, 7);
//            System.out.println(genshin.getTitle() + " | Rating: " + genshin.getRating());
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//
//                //Print all games in gamestore table with space




//        try {
//            GenericArrayList<String> gamesArray;
//           gamesArray = gameStoreDao.getAllGames();
//
//
//            for (int i = 0; i < gamesArray.size(); i++) {
//
//
//                if(gamesArray.getItem(i)!= null) { System.out.println(gamesArray.getItem(i) + "\n");}
//
//            }
//




        //Return all games in a given users collection, must insert user id
        // TODO: 2/21/2022 Create service method to insert id or store id when logging in


//        try {
//            gameCollectionDao.getGameCollection(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }





        //adds game to user collection, must insert user id and game id
        // TODO: 2/21/2022 create service method to input user id and game id and call getGameCollection to return whole collection


//        try {
//            gameCollectionDao.addGame(1, 17);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }










