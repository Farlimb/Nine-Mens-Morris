package sk.tuke.kpi.kp.ninemensmorris.server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.tuke.kpi.kp.ninemensmorris.service.ScoreService;
import sk.tuke.kpi.kp.ninemensmorris.service.ScoreServiceJPA;

@SpringBootApplication
@Configuration
@EntityScan("sk.tuke.kpi.kp.ninemensmorris.entity")
public class GameStudioServer {
    public static void main(String[] args) {
        SpringApplication.run(GameStudioServer.class, args);
    }
    @Bean
    public ScoreService scoreService() {
        return new ScoreServiceJPA();
    }
}