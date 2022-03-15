package sk.tuke.kpi.kp.ninemensmorris;

public class Move {
    public boolean check(int i,int x,Field field,Player player){
        Position positioni = field.getPositions().get(i);
        Position positionx = field.getPositions().get(x);
        if(positionx.getPlayer()!=null || positioni.getPlayer()!=player)
            return false;
        if(positioni.getRight()!=positionx && positioni.getLeft()!=positionx && positioni.getUp()!=positionx && positioni.getDown()!=positionx ){
            return false;
        }
        move(i,x,field);
        return true;
    }
    private void move(int i, int x,Field field){
        Position positioni = field.getPositions().get(i);
        Position positionx = field.getPositions().get(x);

        if(positionx.getPlayer()==null){
            positionx.setPlayer(positioni.getPlayer());
            positionx.setColor(positioni.getColor());
            positioni.setColor("\u001B[0m");
            positioni.setPlayer(null);
        }
        field.show();
    }

    public boolean checkIfCanAnyoneMove(Field field,Player player){
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
