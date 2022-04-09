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
        entityManager.persist(rating);
    }

    @Override
    public int getAverageRating(String game) {
        double variable = (double) entityManager.createNamedQuery("Rating.getAverageRating").setParameter("nine_mens_morris", game).getSingleResult();
        return (int)Math.round(variable);
    }

    @Override
    public int getRating(String game, String player) {
        return (int) entityManager.createNamedQuery("Rating.getRating").setParameter("player",player).setParameter("nine_mens_morris",game).getSingleResult();
    }

    @Override
    public void reset() {
        entityManager.createNamedQuery("Rating.resetRating").executeUpdate();
    }
}