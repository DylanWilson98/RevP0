package com.dylan.models;

public class GameCollection {

    Integer user_id;
    Integer game_id;

    public GameCollection() {
    }

    public GameCollection(Integer user_id) {
        this.user_id = user_id;
    }



    public GameCollection(Integer user_id, Integer game_id) {
        this.user_id = user_id;
        this.game_id = game_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    @Override
    public String toString() {
        return "GameCollection{" +
                "user_id=" + user_id +
                ", game_id=" + game_id +
                '}';
    }
}
