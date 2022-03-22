package sk.tuke.kpi.kp.ninemensmorris.entity;

import java.util.Date;

public class Comment {
    private String comment;
    private String player;
    private String game;
    private Date date;


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




}
