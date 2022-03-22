package sk.tuke.kpi.kp.ninemensmorris.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    private Field field;
    private Random randomGenerator = new Random();
    private int z=0;
    private int x=0;
    private Player player = new Player(Field.Color.RED);

    public FieldTest(){
        this.field=new Field();
        field.setUp();
        Position position = field.getPositions().get(randomGenerator.nextInt(24));
        position.setColor("RED");
        position.setPlayer(player);
        z++;
    }

    @Test
    public void checkIfPosition() {
        ArrayList<Position> positions = field.getPositions();
        for (int i = 0; i<=23; i++){
            Player playerx=positions.get(i).getPlayer();
            if(playerx!=null){
                x++;
            }
        }
        assertEquals(z, x,"Nepreslo daco zle");
    }

    @Test
    public void checkIfCanMove(){
        Field field1 = new Field();
        field1.setUp();
        Move move = new Move();
        Position position1 = field.getPositions().get(20);
        Position position2 = field.getPositions().get(23);
        Position position3 = field.getPositions().get(21);
        Position position4 = field.getPositions().get(19);
        Position position5 = field.getPositions().get(17);
        position1.setPlayer(player);
        Player player2 = new Player(Field.Color.BLUE);
        position2.setPlayer(player2);
        position3.setPlayer(player2);
        position4.setPlayer(player2);
        position5.setPlayer(player2);
        assertFalse(move.checkIfCanAnyoneMove(field1, player), "Nepreslo daco zle");
    }
}