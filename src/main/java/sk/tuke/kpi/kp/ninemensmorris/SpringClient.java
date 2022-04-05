package sk.tuke.kpi.kp.ninemensmorris;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.tuke.kpi.kp.ninemensmorris.consoleui.ConsoleUI;
import sk.tuke.kpi.kp.ninemensmorris.core.Field;
import sk.tuke.kpi.kp.ninemensmorris.service.*;

@SpringBootApplication
@Configuration
public class SpringClient {

    public static void main(String[] args) {
        SpringApplication.run(SpringClient.class, args);
    }
    @Bean
    public Field field() {
        return new Field();
    }
    @Bean
    public ConsoleUI consoleUI(Field field) {
        return new ConsoleUI(field);
    }
    @Bean
    public CommandLineRunner runner(ConsoleUI ui) {
        return args -> ui.play();
    }

    @Bean
    public ScoreService scoreService() {
        return new ScoreServiceJPA();
    }
    @Bean
    public RatingService ratingService() {
        return new RatingServiceJPA();
    }
    @Bean
    public CommentService commentService() {
        return new CommentServiceJPA();
    }
}
