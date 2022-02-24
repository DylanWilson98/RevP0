package com.dylan.services;

import com.dylan.dao.UserDao;
import com.dylan.menu.Main;
import com.dylan.menu.MenuLogin;
import com.dylan.models.User;

import java.sql.SQLException;
import java.util.Scanner;

public class UserServices {
        UserDao userDao;
    public UserServices() {

        userDao = new UserDao();
    }

    public UserServices(UserDao dao) {
        userDao = dao;

    }





    //private static final UserDao userDao = new UserDao();
    private static final Main main = new Main();
    private static final  Scanner scanner = new Scanner(System.in);

    public void createAccount(String username, String password)  {

        User ad = new User(username, password);
        try {
            userDao.add(ad);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean correctCredentials(String username, String password) {
      boolean bool = false;
        try {
            User user = userDao.getByUsername(username);


            if(user != null) {


                if (username.equals(user.getUsername()) && password.equals(user.getPassword())){

                    bool = true;

                }



            }else {System.out.println("Credentials do not match.\n\n");
                MenuLogin.login();}



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bool;
    }

    // Todo Switch from going to main to m2 and pass in newName
    public void updateUsername(String oldName)  {
        User user = null;
        try {

            System.out.println("Enter your new username: ");
            String newName = scanner.nextLine();
            user = userDao.getByUsername(oldName);
            userDao.update(user, newName);
            Main.mainMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    //Todo Switch from going to main to m2 and pass in newPasswword
    public void updatePassword(String username)  {
        User user = null;
        try {
            System.out.println("Enter your new password: ");
            String newPassword = scanner.nextLine();
            user = userDao.getByUsername(username);
            userDao.updatePassword(user, newPassword);
            Main.mainMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
