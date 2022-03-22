package sk.tuke.kpi.kp.ninemensmorris.core;
import org.junit.jupiter.api.Test;
import sk.tuke.kpi.kp.ninemensmorris.entity.Rating;
import sk.tuke.kpi.kp.ninemensmorris.service.RatingService;
import sk.tuke.kpi.kp.ninemensmorris.service.RatingServiceJDBC;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RatingServiceJDBCTest {
    private final RatingService ratingService = new RatingServiceJDBC();
    @Test
    public void testReset() {
        ratingService.setRating(new Rating("Jozko","nine-mens-morris",1,new Date()));
        ratingService.reset();
        var ratings = ratingService.getRating("nine-mens-morris","Jozko");
        assertEquals(0, ratings);
    }

    @Test
    public void testGet(){
        ratingService.reset();
        ratingService.setRating(new Rating("1", "nine-mens-morris", 5, new Date()));
        ratingService.setRating(new Rating("2", "nine-mens-morris", 2, new Date()));
        ratingService.setRating(new Rating("3", "nine-mens-morris", 1, new Date()));


        assertEquals(5, ratingService.getRating("nine-mens-morris", "1"));
        assertEquals(2, ratingService.getRating("nine-mens-morris", "2"));
        assertEquals(1, ratingService.getRating("nine-mens-morris", "3"));
    }
    @Test
    public void testGetAverage(){
        ratingService.reset();
        ratingService.setRating(new Rating("1", "nine-mens-morris", 5, new Date()));
        ratingService.setRating(new Rating("2", "nine-mens-morris", 2, new Date()));
        ratingService.setRating(new Rating("3", "nine-mens-morris", 1, new Date()));

        assertEquals(2, ratingService.getAverageRating("nine-mens-morris"));
    }
}
