package com.dylan.dao;

import com.dylan.datastructure.GenericArrayList;
import com.dylan.util.ConnectionUtil;

import javax.xml.ws.soap.MTOMFeature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameCollectionDao {
    Connection conn;

    public GameCollectionDao() {

        conn = ConnectionUtil.getConnection();
    }

    //get user by id
    //put that into a game collection dao method
    // use that perhaps in sql statement or somewhere else to get games where id = x


    public void getGameCollection(Integer user_id) throws SQLException {
        int counter = 1;
        GenericArrayList<String> collectionArray = new GenericArrayList<>();
        PreparedStatement statement = conn.prepareStatement("select gc.game_id, gs.title, gs.rating from game_collection as gc inner join game_store gs on gc.game_id = gs.game_id where gc.user_id ="  + user_id);
        ResultSet rs = statement.executeQuery();



        while(rs.next()) {

            // TODO: 2/22/2022 add log here

            //collectionArray.addItem(rs.getString("title"));
           // counter +". " +
            System.out.println( rs.getString("title") + " | Rating: " + rs.getInt("rating" )+ "\n");
               // counter++;
        }
    }


    public void addGame(Integer user_id, Integer game_id) throws SQLException {

        PreparedStatement statement = conn.prepareStatement("insert into game_collection values(?,?)");
        statement.setInt(1,user_id);
        statement.setInt(2,game_id);
        statement.execute();





    }














}



//    public GenericArrayList<String> getCollection(Integer user_id) throws SQLException{
//
//        GenericArrayList<String> collectionArray = new GenericArrayList<>(10);
//
//        PreparedStatement statement = conn.prepareStatement("select gc.game_id, gs.title from game_collection as gc inner join game_store gs on gc.game_id = gs.game_id where gc.user_id ="  + user_id);
//       // statement.setInt(1, user_id);
//        ResultSet rs = statement.executeQuery();
//
//        while(rs.next()) {
//
//            collectionArray.addItem(rs.getString("title"));
//
//        }
//
//
//
//        return collectionArray;
//    }







//    public GameCollectionDao getByUserId(Integer user_id) throws SQLException{
//        GameCollectionDao gcd = null;
//
//        PreparedStatement statement = conn.prepareStatement("");
//
//        return gcd;
//    }



