package com.dylan.exception;

public class InvalidUserNameException extends RuntimeException{

    public InvalidUserNameException() {

        super("Invalid Username. Username contained banned word.");
    }
}
