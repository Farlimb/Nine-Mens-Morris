package sk.tuke.kpi.kp.ninemensmorris.service;

import sk.tuke.kpi.kp.ninemensmorris.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getComments(String game);
    void reset();
}
