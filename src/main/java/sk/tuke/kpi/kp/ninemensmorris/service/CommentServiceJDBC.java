package sk.tuke.kpi.kp.ninemensmorris.service;

import sk.tuke.kpi.kp.ninemensmorris.entity.Comment;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommentServiceJDBC implements CommentService{
    public static final String JDBC_URL = "jdbc:postgresql://localhost/gamestudio";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = "heslo";
    public static final String INSERT = "INSERT INTO comment (comment, player, game, commented_at) VALUES (?, ?, ?, ?)";
    public static final String SELECT = "SELECT comment, player, game, commented_at FROM comment WHERE game = ?";
    public static final String DELETE = "DELETE FROM comment";

    @Override
    public void addComment(Comment comment) {
        try (var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             var statement = connection.prepareStatement(INSERT);
            ){
            statement.setString(1,comment.getComment());
            statement.setString(2,comment.getPlayer());
            statement.setString(3,comment.getGame());
            statement.setTimestamp(4,new Timestamp(comment.getDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new GamestudioException("Problem adding comment", e);
        }
    }

    @Override
    public List<Comment> getComments(String game) {
        try (var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             var statement = connection.prepareStatement(SELECT);
        ){
            statement.setString(1,game);
            try(var rs = statement.executeQuery()){
                var comments = new ArrayList<Comment>();
                while(rs.next()){
                    if(Objects.equals(rs.getString(3), game)) {
                        comments.add(new Comment(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4)));
                    }
                }
                return comments;
            }
        }catch (SQLException e) {
            throw new GamestudioException("Problem getting a comment", e);
        }
    }

    @Override
    public void reset() {
        try (var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             var statement = connection.createStatement();
        ){
            statement.executeUpdate(DELETE);
        } catch (SQLException e) {
            throw new GamestudioException("Problem deleting comment", e);
        }
    }
}
