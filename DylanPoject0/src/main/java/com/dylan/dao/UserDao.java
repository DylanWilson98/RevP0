package com.dylan.dao;

import com.dylan.models.User;
import com.dylan.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    Connection conn;

    public UserDao() {

        conn = ConnectionUtil.getConnection();
    }


//    public void add(String username, String password) throws SQLException {
//
//        PreparedStatement statement = conn.prepareStatement("insert into users values( ?, ?)");
//
//        User u = new User();
//       statement.setString(1, u.getUsername());
//        statement.setString(2, u.getPassword());
//            ResultSet rs = statement.executeQuery();
//
//            if(rs.next()) {
//
//                u.setUsername(rs.getString("username"));
//                u.setPassword(rs.getString("password"));
//            }
//    }

    public User add(User u) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("insert into users values( ?, ?)");


        statement.setString(1, u.getUsername());
        statement.setString(2, u.getPassword());
         statement.execute();

//        if(rs.next()) {
//
//            u.setUsername(rs.getString("username"));
//            u.setPassword(rs.getString("password"));
//        }
//

        return u;
    }

    public User getByUsername(String username) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("select * from users where username = ?");
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();
        User u = null;
        if(rs.next()) {
             u = new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password")

            );


        }
        return u;
    }

    public User getById(Integer user_id) throws SQLException {
        User u = null;

        PreparedStatement statement = conn.prepareStatement("select * from users where id = ?");
        statement.setInt(1, user_id);

        ResultSet rs = statement.executeQuery();

        if(rs.next()) {
            u = new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password")

//                    u.setUser_id(rs.getInt("user_id"));
//            u.setUsername(rs.getString("username"));
//            u.setPassword(rs.getString("password"));
            );

        }

        return u;
    }















    public void update(User u, String newName) throws SQLException {

        PreparedStatement statement = conn.prepareStatement("update users set username = ? where user_id = ?");

        statement.setString(1, newName);
        statement.setInt(2, u.getUser_id());

        statement.execute();
    }

    public void updatePassword(User u, String newPass) throws SQLException {

        PreparedStatement statement = conn.prepareStatement("update users set password = ? where user_id = ?");

        statement.setString(1, newPass);
        statement.setInt(2, u.getUser_id());

        statement.execute();
    }


}
