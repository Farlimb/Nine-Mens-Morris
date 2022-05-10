package sk.tuke.kpi.kp.ninemensmorris.server.webservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.kpi.kp.ninemensmorris.entity.Rating;
import sk.tuke.kpi.kp.ninemensmorris.service.RatingService;


@RestController
@RequestMapping("/api/rating")
public class RatingServiceRest {
    @Autowired
    private RatingService ratingService;


    @GetMapping("/{game}")
    public int getAverageRating(@PathVariable String game) {
        if(ratingService.getAverageRating(game)>5 && ratingService.getAverageRating(game)>-1){
            return 3;
        }
        return ratingService.getAverageRating(game);
    }

    @PostMapping
    public void setRating(@RequestBody Rating rating) {
        ratingService.setRating(rating);
    }

    @GetMapping("/{game}/{player}")
    public int getRating(@PathVariable String game,@PathVariable String player) {
        return ratingService.getRating(game,player);
    }
}