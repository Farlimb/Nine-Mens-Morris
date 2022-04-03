package sk.tuke.kpi.kp.ninemensmorris.service;

import sk.tuke.kpi.kp.ninemensmorris.entity.Rating;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class RatingServiceJDBC implements RatingService{
    public static final String JDBC_URL = "jdbc:postgresql://localhost/gamestudio";
    public static final String JDBC_USER = "postgres";
    public static final String JDBC_PASSWORD = "heslo";
    public static final String INSERT = "INSERT INTO rating (player, game, rating, rated_at) VALUES (?, ?, ?, ?)";
    public static final String SELECT = "SELECT player, game, rating, rated_at FROM rating WHERE game = ? ORDER BY rating DESC LIMIT 10";
    public static final String DELETE = "DELETE FROM rating";

    @Override
    public void setRating(Rating rating) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setString(1, rating.getPlayer());
            statement.setString(2, rating.getGame());
            statement.setInt(3, rating.getRating());
            statement.setTimestamp(4, new Timestamp(rating.getRatedAt().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new GamestudioException("Problem inserting score", e);
        }
    }

    @Override
    public int getAverageRating(String game) {
        try (var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             var statement = connection.prepareStatement(SELECT)
        ){
            statement.setString(1,game);
            try(var rs = statement.executeQuery()) {
                var ratings = new ArrayList<Rating>();
                while (rs.next()) {
                    ratings.add(new Rating(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4)));
                }
                int rating1 = 0;
                int j;
                if(ratings.size()==0){
                    return 0;
                }
                for (j=0; j < ratings.size(); j++) {
                    rating1 = rating1 + ratings.get(j).getRating();
                }
                return rating1/j;
            }
        }catch (SQLException e) {
            throw new GamestudioException("Problem getting average",e);
        }

    }

    @Override
    public int getRating(String game, String player) {
        try (var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             var statement = connection.prepareStatement(SELECT);
             var statement1 = connection.prepareStatement(SELECT)
        ){
            statement.setString(1,game);
            statement1.setString(1,player);
            try(var rs = statement.executeQuery()){
                var ratings = new ArrayList<Rating>();
                while(rs.next()){
                    ratings.add(new Rating(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4)));
                }
                for (Rating rating : ratings) {
                    var game1 = rating.getGame();
                    var player1 = rating.getPlayer();
                    if (Objects.equals(game1, game) && Objects.equals(player1, player)) {
                        return rating.getRating();
                    }
                }
            }
            return 0;
        }catch (SQLException e) {
            throw new GamestudioException("Problem getting rating",e);
        }
    }

    @Override
    public void reset() {
        try (
                var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                var statement = connection.createStatement()
        ) {
            statement.executeUpdate(DELETE);

        } catch (SQLException e) {
            throw new GamestudioException("Problem deleting rating", e);
        }
    }
}
