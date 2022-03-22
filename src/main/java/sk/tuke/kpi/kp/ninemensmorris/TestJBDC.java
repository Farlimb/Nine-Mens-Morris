package sk.tuke.kpi.kp.ninemensmorris;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJBDC {
    public static void main(String[] args) throws SQLException {
       try (
           var connection = DriverManager.getConnection("jdbc:postgresql://localhost/gamestudio", "postgres", "heslo");
           var statement = connection.createStatement();
           var rs = statement.executeQuery("SELECT player, game, points FROM score WHERE game = 'nine-mens-morris' ORDER BY points DESC LIMIT 10");
           ) {
          //statement.executeUpdate("INSERT INTO score(player,game,points) VALUES ('player','nine-mens-morris','100')");
          while(rs.next()){
              System.out.printf("%s %s %d\n", rs.getString(1), rs.getString(2), rs.getInt(3));
          }
       }
       System.out.println("--------------------------------");
       }
    }
