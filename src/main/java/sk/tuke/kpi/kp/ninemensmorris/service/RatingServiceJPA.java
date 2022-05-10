package sk.tuke.kpi.kp.ninemensmorris.service;
import sk.tuke.kpi.kp.ninemensmorris.entity.Rating;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class RatingServiceJPA implements RatingService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void setRating(Rating rating) {
        var player = rating.getPlayer();
        var game = rating.getGame();
        System.out.println(getRating(game,player));
        if(rating.getRating()<0||rating.getRating()>5){
            System.out.println("tu sa nemal dostat");
            return;
        }

        if(getRating(game,player)>0 && getRating(game,player)<5) {
            System.out.println("tu sa nemal dostat");
            try{
                entityManager.persist(rating);
            }
            catch (Exception e){

            }
        }
        else{
            entityManager.persist(rating);
        }
    }

    @Override
    public int getAverageRating(String game) {
        double variable =0;
        try {
             variable = (double) entityManager.createNamedQuery("Rating.getAverageRating").setParameter("nine_mens_morris", game).getSingleResult();
        }
        catch (Exception ignored){

        }
        return (int)Math.round(variable);
    }

    @Override
    public int getRating(String game, String player) {
        try {
            return (int) entityManager.createNamedQuery("Rating.getRating").setParameter("player",player).setParameter("nine_mens_morris",game).getSingleResult();
        }
        catch (Exception e){

        }
        return -1;
    }

    @Override
    public void reset() {
        entityManager.createNamedQuery("Rating.resetRating").executeUpdate();
    }
}