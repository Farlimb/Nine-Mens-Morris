package sk.tuke.kpi.kp.ninemensmorris.service;
import sk.tuke.kpi.kp.ninemensmorris.entity.Comment;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional

public class CommentServiceJPA implements CommentService {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addComment(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getComments(String game) {
        return entityManager.createNamedQuery("Comment.getComments")
                .setParameter("nine_mens_morris", game).setMaxResults(10).getResultList();
    }

    @Override
    public void reset() {
        entityManager.createNamedQuery("Comment.resetComment").executeUpdate();
    }
}