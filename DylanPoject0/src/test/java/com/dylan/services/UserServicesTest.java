package com.dylan.services;

import com.dylan.models.User;
import com.dylan.parameter.ValidUserParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@Nested
//@DisplayName("when using Valid data")
@ExtendWith(ValidUserParameterResolver.class)
class UserServicesTest {



//        String username = "dylan";
//        String password = "wilson";


    private UserServices userServicesTest = new UserServices();
   // UserServicesTest ust = new UserServicesTest();





   @RepeatedTest(value = 3)
@DisplayName("All usernames are valid")
    public void correctCredentials(User user) {


userServicesTest.correctCredentials(user.getUsername(), user.getPassword());






    }
























//        boolean bool = false;
//        try {
//            User user = userDao.getByUsername(username);
//
//
//            if(user != null) {
//
//
//                if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
//
//                    bool = true;
//
//                }
//
//
//
//            }else {System.out.println("Credentials do not match.\n\n");
//                Main.mainMenu();}
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        assertTrue(bool);

}