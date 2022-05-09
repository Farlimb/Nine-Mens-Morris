package sk.tuke.kpi.kp.ninemensmorris.core;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Position{
    @JsonIgnore
    private Position up = null;
    @JsonIgnore
    private Position down = null;
    @JsonIgnore
    private Position right = null;
    @JsonIgnore
    private Position left = null;
    /*private int upp = -1;
    private int downn = -1;
    private int rightt = -1;
    private int leftt = -1;*/
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

   /* public int getUpp() {
        return upp;
    }

    public void setUpp(int upp) {
        this.upp = upp;
    }

    public int getDownn() {
        return downn;
    }

    public void setDownn(int downn) {
        this.downn = downn;
    }

    public int getRightt() {
        return rightt;
    }

    public void setRightt(int rightt) {
        this.rightt = rightt;
    }

    public int getLeftt() {
        return leftt;
    }

    public void setLeftt(int leftt) {
        this.leftt = leftt;
    }*/

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
