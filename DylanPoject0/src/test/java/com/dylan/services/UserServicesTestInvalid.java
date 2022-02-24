package com.dylan.services;


import com.dylan.models.User;
import com.dylan.parameter.InvalidUserParameterResolver;
import com.dylan.parameter.ValidUserParameterResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;

@Nested
@DisplayName("when using invalid data")
@ExtendWith(InvalidUserParameterResolver.class)
public class UserServicesTestInvalid {



    //Can't go throw login method with this

    private final UserServices userServicesTest = new UserServices();
   // @RepeatedTest(value = 3)
    @DisplayName("All usernames are invalid")
    public void incorrectCredentials(User user) {

        userServicesTest.correctCredentials(user.getUsername(), user.getPassword());

    }
}
