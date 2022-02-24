package com.dylan.parameter;

import com.dylan.models.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.Random;

public class ValidUserParameterResolver implements ParameterResolver {

    public static User[] validUsers = {
        new User("dylan", "wilson"),
            new User("player1","wins"),
            new User("player2","loses"),

    };





    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {

        boolean ret = false;
        if(parameterContext.getParameter().getType() == User.class) {

            ret = true;
        }




        return ret;


    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Object ret = null;
        if(parameterContext.getParameter().getType() == User.class) {


            ret = validUsers[new Random().nextInt(validUsers.length)];
        }


return ret;
    }
}
