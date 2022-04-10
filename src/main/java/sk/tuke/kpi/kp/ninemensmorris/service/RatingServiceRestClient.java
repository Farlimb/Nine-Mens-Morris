package sk.tuke.kpi.kp.ninemensmorris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import sk.tuke.kpi.kp.ninemensmorris.entity.Rating;


public class RatingServiceRestClient implements RatingService{
    private final String url = "http://localhost:8080/api/rating";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void setRating(Rating rating) {
        restTemplate.postForEntity(url, rating, Rating.class);
    }

   @Override
    public int getAverageRating(String game) {
        var x = restTemplate.getForEntity(url + "/" + game, String.class).getBody();
       assert x != null;
       return Integer.parseInt(x);
    }

    @Override
    public int getRating(String game, String player) {
        var x = restTemplate.getForEntity(url + "/"+game+"/"+player, String.class).getBody();
        assert x != null;
        return Integer.parseInt(x);
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported via web service");
    }
}
