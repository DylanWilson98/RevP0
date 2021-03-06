package com.dylan.models;

public class User {
    Integer user_id;
    String username;
    String password;


    public User() {
    }

    public User(Integer user_id) {
        this.user_id = user_id;

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer user_id, String username, String password ) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
