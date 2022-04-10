package sk.tuke.kpi.kp.ninemensmorris;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import sk.tuke.kpi.kp.ninemensmorris.consoleui.ConsoleUI;
import sk.tuke.kpi.kp.ninemensmorris.core.Field;
import sk.tuke.kpi.kp.ninemensmorris.service.*;

@SpringBootApplication
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "sk.tuke.kpi.kp.ninemensmorris.server.*"))
public class SpringClient {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
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
        return new ScoreServiceRestClient();
    }
    @Bean
    public RatingService ratingService() {
        return new RatingServiceRestClient();
    }
    @Bean
    public CommentService commentService() {
        return new CommentServiceRestClient();
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
