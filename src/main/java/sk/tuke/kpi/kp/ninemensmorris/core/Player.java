package sk.tuke.kpi.kp.ninemensmorris.core;

import sk.tuke.kpi.kp.ninemensmorris.entity.Score;

import java.util.Date;

public class Player {
    private Field.Color color = null;
    private String name;
    private final Score score = new Score(name,"nine-mens-morris",0,new Date());

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Score getScore() {
        return score;
    }

    public Player(Field.Color color){
        this.color=color;
    }

    public Field.Color getColor(){
        return color;
    }
}
