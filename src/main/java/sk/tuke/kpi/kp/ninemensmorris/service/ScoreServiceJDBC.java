package sk.tuke.kpi.kp.ninemensmorris.service;

import sk.tuke.kpi.kp.ninemensmorris.entity.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreServiceJDBC implements ScoreService{

    public static final String JDBC_URL = "jdbc:postgresql://localhost/gamestudio";
    public static final String JBDC_USER = "postgres";
    public static final String JBDC_PASSWORD = "heslo";
    public static final String SELECT = "SELECT player, game, points, played_at FROM score WHERE game = ? ORDER BY points DESC LIMIT 10";
    public static final String DELETE = "DELETE FROM score";
    public static final String INSERT = "INSERT INTO score (player, game, points, played_at) VALUES (?, ?, ?, ?)";

    @Override
    public void addScore(Score score) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JBDC_USER, JBDC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setString(1, score.getPlayer());
            statement.setString(2, score.getGame());
            statement.setInt(3, score.getPoints());
            statement.setTimestamp(4, new Timestamp(score.getPlayedAt().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new GamestudioException("Problem inserting score", e);
        }
    }

    @Override
    public List<Score> getTopScores(String game) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JBDC_USER, JBDC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT);
        ) {
            statement.setString(1, game);
            try (ResultSet rs = statement.executeQuery()) {
                List<Score> scores = new ArrayList<>();
                while (rs.next()) {
                    scores.add(new Score(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getDate(4)));
                }
                return scores;
            }
        } catch (SQLException e) {
            throw new GamestudioException("Problem selecting score", e);
        }

    }

    @Override
    public void reset() {
        try (
                var connection = DriverManager.getConnection(JDBC_URL, JBDC_USER, JBDC_PASSWORD);
                var statement = connection.createStatement();
        ) {
            statement.executeUpdate(DELETE);

        } catch (SQLException e) {
            throw new GamestudioException("Problem deleting score", e);
        }
    }
}
