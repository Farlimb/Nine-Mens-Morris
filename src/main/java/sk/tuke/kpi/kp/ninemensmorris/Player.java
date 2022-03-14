package sk.tuke.kpi.kp.ninemensmorris;

public class Player {
    private Field.Color color = null;
    public Player(Field.Color color){
        this.color=color;
    }

    public Field.Color getColor(){
        return color;
    }
}
