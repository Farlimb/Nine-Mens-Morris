package sk.tuke.kpi.kp.ninemensmorris;

import java.util.ArrayList;

public class Mark {
    public void exec(int i, Player player,Field field){
        ArrayList<Position> positions = field.getPositions();
        positions.get(i).setPlayer(player);
        if(player.getcolor()== Field.Color.RED) {
            positions.get(i).setColor("\u001B[31m");
        }
        else{
            positions.get(i).setColor("\u001B[34m");
        }
    }

}
