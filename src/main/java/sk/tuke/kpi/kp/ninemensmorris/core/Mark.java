package sk.tuke.kpi.kp.ninemensmorris.core;

import java.util.ArrayList;

public class Mark {
    public boolean exec(int i, Player player,Field field){
        ArrayList<Position> positions = field.getPositions();
        if(positions.get(i).getPlayer()!=null){ //check na zabratu poziciu
            System.out.println("Zabrata pozicia");
            return false;
        }
        positions.get(i).setPlayer(player);         //zadanie hraca
        if(player.getColor()== Field.Color.RED) { //check akej farby je
            positions.get(i).setColor("\u001B[31m");    // color set pre pozicu
        }
        else{
            positions.get(i).setColor("\u001B[34m");
        }
        return true;
    }

}
