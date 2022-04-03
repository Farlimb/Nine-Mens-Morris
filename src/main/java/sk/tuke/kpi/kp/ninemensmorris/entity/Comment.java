package sk.tuke.kpi.kp.ninemensmorris.entity;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

public class Comment {
    @Id
    @GeneratedValue
    private int ident;
    private String comment;
    private String player;
    private String game;
    private Date date;

    public Comment(){}

    public Comment(String comment, String player, String game, Date date){
        this.comment=comment;
        this.date=date;
        this.game=game;
        this.player=player;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }
}
