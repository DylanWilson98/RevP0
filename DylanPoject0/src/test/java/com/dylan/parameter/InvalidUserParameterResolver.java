package com.dylan.parameter;

import com.dylan.models.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.Random;

public class InvalidUserParameterResolver implements ParameterResolver {



    public static User[] invalidUsers = {
            new User("dydddlan", "wilddddson"),
            new User("playddder1","widddns"),
            new User("pladddyer2","losddddes"),

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


            ret = invalidUsers[new Random().nextInt(invalidUsers.length)];
        }


        return ret;
    }
}

