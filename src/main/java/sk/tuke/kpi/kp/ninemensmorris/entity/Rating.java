package sk.tuke.kpi.kp.ninemensmorris.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQuery( name = "Rating.getRating",
        query = "SELECT r.rating FROM Rating r WHERE r.player=:player AND r.game=:nine_mens_morris ORDER BY r.rating DESC")
@NamedQuery( name = "Rating.getAverageRating",
        query = "SELECT ra.rating FROM Rating ra WHERE ra.game=:nine_mens_morris ORDER BY ra.rating DESC")
@NamedQuery( name = "Rating.resetRating",
        query = "DELETE FROM Rating ")

public class Rating {

    @Id
    @GeneratedValue
    private int ident;

    public Rating() {}

    public int getIdent() { return ident; }

    public void setIdent(int ident) { this.ident = ident; }

    private String player;

    private String game;

    private int rating;

    private Date ratedAt;

    public Rating(String player, String game, int rating, Date ratedAt) {
        this.player = player;
        this.game = game;
        this.rating = rating;
        this.ratedAt = ratedAt;
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

    @Override
    public String toString() {
        return "Rating{" +
                "ident=" + ident +
                ", player='" + player + '\'' +
                ", game='" + game + '\'' +
                ", rating=" + rating +
                ", ratedAt=" + ratedAt +
                '}';
    }
}
