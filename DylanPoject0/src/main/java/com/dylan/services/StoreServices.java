package com.dylan.services;

import com.dylan.dao.GameCollectionDao;
import com.dylan.dao.GameStoreDao;
import com.dylan.dao.UserDao;
import com.dylan.datastructure.GenericArrayList;
import com.dylan.menu.MenuCollection;
import com.dylan.menu.MenuStore;
import com.dylan.models.GameStore;
import com.dylan.models.User;

import java.sql.SQLException;
import java.util.Scanner;

public class StoreServices {

    GameStoreDao gameStoreDao;

    public StoreServices() {

        gameStoreDao = new GameStoreDao();

    }

    public StoreServices(GameStoreDao dao){

        gameStoreDao=dao;
    }






    private static final Scanner scanner = new Scanner(System.in);
    private static final GameStore gs = new GameStore();
    //private static final GameStoreDao gameStoreDao = new GameStoreDao();
    private static final GameCollectionDao gcd = new GameCollectionDao();
    private static final MenuStore menuStore = new MenuStore();
    private static final MenuCollection menuCollection = new MenuCollection();
    private static final UserDao userDao = new UserDao();
    User user = new User();

  public void viewGames(String username) {

      try {
          GenericArrayList<String> gamesArray;
          gamesArray = gameStoreDao.getAllGames();
          //gameStoreDao.getAllGames();
          //System.out.println(gamesArray);

          for (int i = 0; i < gamesArray.size(); i++) {


              if (gamesArray.getItem(i) != null) {
                  System.out.println(gamesArray.getItem(i) + "\n");
              }

          }

      } catch (SQLException e) {
          e.printStackTrace();
      }
//      try {
//          gameStoreDao.getAllGames();
//      } catch (SQLException e) {
//          e.printStackTrace();
//      }


      MenuStore.storeMenu(username);

  }




        //add game to collection
    public void addToCollection(String username) {

        try {
            user = userDao.getByUsername(username);
            Integer user_id = user.getUser_id();

            System.out.println("Which Game would you like to add to your collection?\n" +
                    "Please pick game using their respective number.");



            int option;
            option = scanner.nextInt();


            gcd.addGame(user_id, option);

            System.out.println("*** "+user.getUsername().toUpperCase() +"'s " + "GAME COLLECTION ***\n");

            gcd.getGameCollection(user_id);

            MenuCollection.CollectionMenu(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void changeRating(Integer game_id, Integer rating) {
        GameStore game = null;

        if(rating>10) {rating = 10;}

        if(rating<1) {rating=1;}

        try {


            game = GameStoreDao.getGameById(game_id);

            System.out.println("Please rate " + game.getTitle() + " (Scale of 1-10)");
            rating = scanner.nextInt();


            gameStoreDao.updateRating(game, rating);

          //  System.out.println( game.getTitle() + " | Rating: " + game.getRating());


            game = GameStoreDao.getGameById(game_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assert game != null;
        System.out.println( game.getTitle() + " | Rating: " + game.getRating());


    }





  }

