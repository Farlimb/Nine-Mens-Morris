package sk.tuke.kpi.kp.ninemensmorris.entity;

import java.util.Date;

public class Rating {
    private String game;
    private String player;
    private int rating;
    private Date ratedAt;

    @Override
    public String toString() {
        return "Rating{" +
                "game='" + game + '\'' +
                ", player='" + player + '\'' +
                ", rating=" + rating +
                ", ratedAt=" + ratedAt +
                '}';
    }

    public Rating(String player,String game, int rating, Date ratedAt) {
        this.game = game;
        this.player = player;
        this.rating = rating;
        this.ratedAt = ratedAt;
    }



    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(Date ratedAt) {
        this.ratedAt = ratedAt;
    }






}
