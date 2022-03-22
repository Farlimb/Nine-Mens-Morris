package sk.tuke.kpi.kp.ninemensmorris.core;

import org.junit.jupiter.api.Test;
import sk.tuke.kpi.kp.ninemensmorris.entity.Comment;
import sk.tuke.kpi.kp.ninemensmorris.service.CommentService;
import sk.tuke.kpi.kp.ninemensmorris.service.CommentServiceJDBC;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentServiceJDBCTest {
    private final CommentService commentService = new CommentServiceJDBC();
    @Test
    public void testReset() {
        commentService.addComment(new Comment("bla", "player", "nine-mens-morris", new Date()));
        commentService.reset();
        var scores = commentService.getComments("nine-mens-morris");
        assertTrue(scores.isEmpty());
    }
    @Test
    public void addCommentTest(){
        commentService.reset();
        commentService.addComment(new Comment("comment", "player", "nine-mens-morris", new Date()));
        var scores = commentService.getComments("nine-mens-morris");
        System.out.printf("%s",scores.get(0).getComment());
        assertEquals("comment",scores.get(0).getComment());
    }
    @Test
    public void getCommentsTest(){
        commentService.reset();
        commentService.addComment(new Comment("comment1", "player1", "nine-mens-morris", new Date()));
        commentService.addComment(new Comment("comment2", "player2", "nine-mens-morris", new Date()));
        commentService.addComment(new Comment("comment3", "player3", "nine-mens-morris", new Date()));
        commentService.addComment(new Comment("comment4", "player4", "nine-mens-morris", new Date()));
        var comments = commentService.getComments("nine-mens-morris");
        int j;
        int xd=0;
        for (j=0; j < comments.size(); j++) {
            xd++;
        }
        assertEquals(xd, 4,"Nepreslo daco zle");
    }
}
