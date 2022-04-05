package sk.tuke.kpi.kp.ninemensmorris.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQuery( name = "Comment.getComments",
        query = "SELECT s FROM Comment s WHERE s.game=:nine_mens_morris")
@NamedQuery( name = "Comment.resetComment",
        query = "DELETE FROM Comment ")
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
