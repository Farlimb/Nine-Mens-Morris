package sk.tuke.kpi.kp.ninemensmorris.core;
import org.junit.jupiter.api.Test;
import sk.tuke.kpi.kp.ninemensmorris.entity.Score;
import sk.tuke.kpi.kp.ninemensmorris.service.ScoreService;
import sk.tuke.kpi.kp.ninemensmorris.service.ScoreServiceJDBC;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreServiceJDBCTest {
    private final ScoreService scoreService = new ScoreServiceJDBC();

    @Test
    public void testReset() {
        scoreService.addScore(new Score("bla", "nine-mens-morris", 100, new Date()));
        scoreService.reset();
        var scores = scoreService.getTopScores("nine-mens-morris");
        assertTrue(scores.isEmpty());
    }

    @Test
    public void addScoreTest(){
        scoreService.reset();
        scoreService.addScore(new Score("Test", "nine-mens-morris", 100, new Date()));
        var scores = scoreService.getTopScores("nine-mens-morris");
        assertFalse(scores.isEmpty());
    }
    @Test
    public void getTopScoreTest(){
        scoreService.reset();
        scoreService.addScore(new Score("bla", "nine-mens-morris", 100, new Date()));
        scoreService.addScore(new Score("brasko", "nine-mens-morris", 100, new Date()));
        scoreService.addScore(new Score("janko", "nine-mens-morris", 100, new Date()));
        scoreService.addScore(new Score("hrasko", "nine-mens-morris", 100, new Date()));
        var scores = scoreService.getTopScores("nine-mens-morris");
        var scores1 = scoreService.getTopScores("wrong input");
        int j;
        int xd=0;
        for (j=0; j < scores.size(); j++) {
            xd++;
        }
        assertEquals(xd, 4,"Nepreslo daco zle");
        xd=0;
        for (j=0; j < scores1.size(); j++) {
            xd++;
        }
        assertEquals(0,xd);
    }

}
