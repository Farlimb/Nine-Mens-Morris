package sk.tuke.kpi.kp.ninemensmorris.core;

public class Position extends Field{
    private Position up = null;
    private Position down = null;
    private Position right = null;
    private Position left = null;
    private Player player = null;
    private int id;
    private String color = "\u001B[0m";

    public String getColor() {
        return color;
    }
    public void setColor(String color){
        this.color=color;
    }
    public Position getUp() {
        return up;
    }

    public Position getDown() {
        return down;
    }

    public Position getRight() {
        return right;
    }

    public Position getLeft() {
        return left;
    }

    public void setUp(Position up) {
        this.up = up;
    }

    public void setDown(Position down) {
        this.down = down;
    }

    public void setRight(Position right) {
        this.right = right;
    }

    public void setLeft(Position left) {
        this.left = left;
    }

    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

}
