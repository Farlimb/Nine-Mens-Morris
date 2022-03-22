package sk.tuke.kpi.kp.ninemensmorris;
import sk.tuke.kpi.kp.ninemensmorris.entity.Comment;
import sk.tuke.kpi.kp.ninemensmorris.entity.Rating;
import sk.tuke.kpi.kp.ninemensmorris.entity.Score;
import sk.tuke.kpi.kp.ninemensmorris.service.*;
import java.util.Date;

public class TestJBDC {
    public static void main(String[] args){
        ScoreService service = new ScoreServiceJDBC();
        RatingService service1 = new RatingServiceJDBC();
        CommentService service2 = new CommentServiceJDBC();
        service.reset();
    }
    }
