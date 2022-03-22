package sk.tuke.kpi.kp.ninemensmorris.core;

import sk.tuke.kpi.kp.ninemensmorris.consoleui.ConsoleUI;

public class Move {
    public boolean check(int i,int x,Field field,Player player){
        Position positioni = field.getPositions().get(i);
        Position positionx = field.getPositions().get(x);
        if(positionx.getPlayer()!=null || positioni.getPlayer()!=player) //check na poziciu ci je volna
            return false;
        if(positioni.getRight()!=positionx && positioni.getLeft()!=positionx && positioni.getUp()!=positionx && positioni.getDown()!=positionx ){
            return false;
        }
        move(i,x,field);
        return true;
    }
    private void move(int i, int x,Field field){
        ConsoleUI consoleUI = new ConsoleUI(field);
        Position positionI = field.getPositions().get(i);
        Position positionX = field.getPositions().get(x);

        if(positionX.getPlayer()==null){ //check ci zadana pozicia nie je zabrana
            positionX.setPlayer(positionI.getPlayer());
            positionX.setColor(positionI.getColor());
            positionI.setColor("\u001B[0m");
            positionI.setPlayer(null);
        }
        consoleUI.show();
    }

    public boolean checkIfCanAnyoneMove(Field field,Player player){         //check ci ma okolo seba aspon jednu volnu poziciu
        for(int i=0; i<=23; i++){
            Position position = field.getPositions().get(i);
            if(position.getPlayer()==player){
                if((position.getLeft()!=null && position.getLeft().getPlayer()==null)
                        || (position.getRight()!=null && position.getRight().getPlayer()==null)
                        || (position.getDown()!=null && position.getDown().getPlayer()==null)
                        || (position.getUp()!=null && position.getUp().getPlayer()==null) ){
                    return true;
                }
            }
        }
        return false;
    }
}
