package com.dylan.services;

import com.dylan.dao.GameCollectionDao;
import com.dylan.menu.Menu2;
import com.dylan.menu.MenuCollection;
import com.dylan.models.User;
import com.dylan.dao.UserDao;

import java.sql.SQLException;
import java.util.Scanner;

public class CollectionServices {

    GameCollectionDao gameCollectionDao;

    public CollectionServices() {

        gameCollectionDao = new GameCollectionDao();
    }

    public CollectionServices(GameCollectionDao dao) {

        gameCollectionDao = dao;
    }




    private static final    MenuCollection menuCollection = new MenuCollection();
       User user = new User();
    //private static final    GameCollectionDao gameCollectionDao = new GameCollectionDao();
    private static final  UserDao userDao = new UserDao();


    public void viewCollection(String username) {
        try {
            user = userDao.getByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            gameCollectionDao.getGameCollection(user.getUser_id());
            MenuCollection.CollectionMenu(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
