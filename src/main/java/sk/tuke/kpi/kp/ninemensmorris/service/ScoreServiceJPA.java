package sk.tuke.kpi.kp.ninemensmorris.service;
import sk.tuke.kpi.kp.ninemensmorris.entity.Score;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class ScoreServiceJPA implements ScoreService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addScore(Score score){
        entityManager.persist(score);
    }

    @Override
    public List getTopScores(String game){
        return entityManager.createNamedQuery("Score.getTopScores")
                .setParameter("nine_mens_morris", game).setMaxResults(10).getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNamedQuery("Score.resetScores").executeUpdate();
    }
}