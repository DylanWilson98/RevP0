package com.dylan.models;

public class GameStore {
    Integer game_id;
    String title;
    Integer rating;

    public GameStore() {
    }

    public GameStore(String title, Integer rating) {
        this.title = title;
        this.rating = rating;
    }

    public GameStore(Integer game_id, String title, Integer rating) {
        this.game_id = game_id;
        this.title = title;
        this.rating = rating;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "GameStore{" +
                "game_id=" + game_id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
