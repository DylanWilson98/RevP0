package com.dylan.dao;

import com.dylan.datastructure.GenericArrayList;
import com.dylan.models.GameStore;
import com.dylan.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class GameStoreDao {



Connection conn;

public GameStoreDao() {

    conn = ConnectionUtil.getConnection();
}


//Currently, returns just games excludes id and rating
    public GenericArrayList<String> getAllGames() throws SQLException {
        int counter = 1;
        GenericArrayList<String> gamesArray = new GenericArrayList<>(10);

        PreparedStatement statement = conn.prepareStatement("Select * from game_store");

        ResultSet rs = statement.executeQuery();


//Currently, returns just games excludes id and rating
        while(rs.next()) {

             gamesArray.addItem(rs.getString("title"));

//            System.out.println(counter +". " + rs.getString("title") + "\n");
//            counter++;






            //gamesArray.addItem(String.valueOf(rs.getInt("game_id")));
           // gamesArray.addItem(String.valueOf(rs.getInt("rating")));

        }

        return gamesArray;
    }


    public GameStore getGameByTitle(String title) throws SQLException {


        GameStore gameStore = null;
        PreparedStatement statement = conn.prepareStatement("Select * From game_store where title = ?");
        int parameterIndex = 0;
        statement.setString(++parameterIndex, title);

        ResultSet rs = statement.executeQuery();


            while (rs.next()) {
                gameStore = new GameStore(rs.getInt("game_id"),
                        rs.getString("title"),
                        rs.getInt("rating"));


            }
            rs.close();
        return gameStore;
    }

    public static GameStore getGameById(Integer game_id) throws SQLException{
        Connection conn1 = ConnectionUtil.getConnection();
        GameStore gameStore = null;
        PreparedStatement statement = conn1.prepareStatement("Select * From game_store where game_id = ?");
        int parameterIndex = 0;
        statement.setInt(++parameterIndex, game_id);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            gameStore = new GameStore(rs.getInt("game_id"),
                    rs.getString("title"),
                    rs.getInt("rating"));


        }
        rs.close();
        return gameStore;
    }






    public void updateRating(GameStore game, Integer rating) throws SQLException {

        PreparedStatement  statement = conn.prepareStatement("update game_store set rating = ? where title = ?");

       Integer oldRating = game.getRating();
       int newRating = 0;
       if(oldRating == 0) {

           newRating = rating;


       }else{
           newRating = ((oldRating + rating)/2);}

        statement.setInt(1, newRating);
        statement.setString(2, game.getTitle());

        statement.execute();
    }

    // TODO: 2/21/2022 may need get id method where the title is put in and it returns the id


    public void getUnownedGames(Integer user_id) {
        int counter = 1;
        try {
            PreparedStatement statement = conn.prepareStatement("select game_id  from game_store gs except " +
                    "select game_id from game_collection gc where gc.user_id =" +user_id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {

   GameStore game = GameStoreDao.getGameById(rs.getInt("game_id"));
                System.out.println(game.getGame_id() +". " +game.getTitle() + " | Rating: " + game.getRating() + "\n");


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void getNumberedGames() throws SQLException {
        int counter = 1;
       // GenericArrayList<String> gamesArray = new GenericArrayList<>(10);

        PreparedStatement statement = conn.prepareStatement("Select * from game_store");

        ResultSet rs = statement.executeQuery();


//Currently, returns just games excludes id and rating
        while(rs.next()) {

            //gamesArray.addItem(rs.getString("title"));

            System.out.println(counter +". " + rs.getString("title") + "\n");
            counter++;






            //gamesArray.addItem(String.valueOf(rs.getInt("game_id")));
            // gamesArray.addItem(String.valueOf(rs.getInt("rating")));

        }

       // return gamesArray;
    }

}














//public MyArrayList getAllGames() throws SQLException {
//
//    MyArrayList gamesArray = new MyArrayList();
//
//    PreparedStatement statement = conn.prepareStatement("Select * from game_store");
//
//    ResultSet rs = statement.executeQuery();
//// TODO: 2/17/2022 genric array list or fix this
//
//    while(rs.next()) {
//        gamesArray.addItem(String.valueOf(rs.getInt("game_id")));
//             gamesArray.addItem(rs.getString("title"));
//            gamesArray.addItem(String.valueOf(rs.getInt("rating")));
//
//
//
//
////        gamesArray = new GameStore( rs.getInt("game_id"),
////             rs.getString("title"),
////              rs.getInt("rating"));
//
//
//
//
//    }
//
//
//    return gamesArray;
//}