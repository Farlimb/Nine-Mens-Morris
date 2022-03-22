package sk.tuke.kpi.kp.ninemensmorris.service;

import sk.tuke.kpi.kp.ninemensmorris.entity.Rating;

public interface RatingService {
    void setRating(Rating rating);
    int getAverageRating(String game);
    int getRating(String game, String player);
    void reset();
}
