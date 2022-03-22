package sk.tuke.kpi.kp.ninemensmorris.entity;
import java.util.Date;

public class Score {
    private String player;
    private String game;
    private int points;
    private Date date;

    public Score(String player, String game, int points, Date date) {
        this.game = game;
        this.player = player;
        this.points = points;
        this.date=date;
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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
