package sk.tuke.kpi.kp.ninemensmorris.entity;

import sk.tuke.kpi.kp.ninemensmorris.core.Player;

import java.util.Date;

public class Score {
    private String player;


    private String game;

    private int points;

    public Score(String player, String game, int points) {
        this.game = game;
        this.player = player;
        this.points = points;
    }


    public void setPlayer(String player) {
        this.player = player;
    }


    public void setPoints(int points) {
        this.points = points;
    }



    public String getPlayer() {
        return player;
    }

    public int getPoints() {
        return points;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

}
