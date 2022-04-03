package sk.tuke.kpi.kp.ninemensmorris.entity;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

public class Score {
    @Id
    @GeneratedValue
    private int ident;
    private String player;
    private String game;
    private int points;
    private Date date;

    @Entity
    @NamedQuery( name = "Score.getTopScores",
            query = "SELECT s FROM Score s WHERE s.game=:game ORDER BY s.points DESC")
    @NamedQuery( name = "Score.resetScores",
            query = "DELETE FROM Score")
    public Score(){}

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

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }
}
