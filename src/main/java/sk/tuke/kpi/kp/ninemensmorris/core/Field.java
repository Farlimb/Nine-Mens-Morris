package sk.tuke.kpi.kp.ninemensmorris.core;
import sk.tuke.kpi.kp.ninemensmorris.consoleui.ConsoleUI;
import java.util.ArrayList;

public class Field{
    private final ArrayList<Position> positions = new ArrayList<>();
    private final Remove remove = new Remove();
    private final Mill mill = new Mill();
    private int startingPlayerCountRed = 9;
    private int startingPlayerCountBlue = 9;
    private int actualPlayerCountRed = 9;
    private int actualPlayerCountBlue = 9;
    public enum Color {RED, BLUE}
    private  Player player1 = new Player("RED");
    private  Player player2 = new Player("BLUE");
    private Player playerOnTurn = player1;
    private FieldState state = FieldState.PLAYING;


    public Field(){
        setUp();
        /*int startingPos = 0;
        int endingPos = 23;
        for (int i = startingPos; i<= endingPos; i++){
            positions.add(new Position());
            positions.get(i).setId(i);          //zadavanie ideciek pre kazdu poziciu
            positions.get(i).setPlayer(null);
        }
        positions.get(0).setRightt(1);  //zadavanie susedov pre konkretne pozicie
        positions.get(0).setDownn(9);

        positions.get(1).setRightt(2);
        positions.get(1).setLeftt(0);
        positions.get(1).setDownn(4);

        positions.get(2).setLeftt(1);
        positions.get(2).setDownn(14);

        positions.get(3).setRightt(4);
        positions.get(3).setDownn(10);

        positions.get(4).setLeftt(3);
        positions.get(4).setRightt(5);
        positions.get(4).setUpp(1);
        positions.get(4).setDownn(7);

        positions.get(5).setLeftt(4);
        positions.get(5).setDownn(13);

        positions.get(6).setRightt(7);
        positions.get(6).setDownn(11);

        positions.get(7).setLeftt(6);
        positions.get(7).setRightt(8);
        positions.get(7).setUpp(4);

        positions.get(8).setLeftt(7);
        positions.get(8).setDownn(12);

        positions.get(9).setRightt(10);
        positions.get(9).setUpp(0);
        positions.get(9).setDownn(21);

        positions.get(10).setRightt(11);
        positions.get(10).setLeftt(9);
        positions.get(10).setUpp(3);
        positions.get(10).setDownn(18);

        positions.get(11).setLeftt(10);
        positions.get(11).setUpp(6);
        positions.get(11).setDownn(15);

        positions.get(12).setRightt(13);
        positions.get(12).setUpp(8);
        positions.get(12).setDownn(17);

        positions.get(13).setRightt(14);
        positions.get(13).setLeftt(12);
        positions.get(13).setUpp(5);
        positions.get(13).setDownn(20);

        positions.get(14).setLeftt(13);
        positions.get(14).setUpp(2);
        positions.get(14).setDownn(23);

        positions.get(15).setRightt(16);
        positions.get(15).setUpp(11);

        positions.get(16).setLeftt(15);
        positions.get(16).setRightt(17);
        positions.get(16).setDownn(19);

        positions.get(17).setLeftt(16);
        positions.get(17).setUpp(12);

        positions.get(18).setRightt(19);
        positions.get(18).setUpp(10);

        positions.get(19).setRightt(20);
        positions.get(19).setLeftt(18);
        positions.get(19).setUpp(16);
        positions.get(19).setDownn(22);

        positions.get(20).setLeftt(19);
        positions.get(20).setUpp(23);

        positions.get(21).setRightt(22);
        positions.get(21).setUpp(9);

        positions.get(22).setRightt(23);
        positions.get(22).setLeftt(21);
        positions.get(22).setUpp(19);

        positions.get(23).setLeftt(22);
        positions.get(23).setUpp(14);*/
    }

    public Player getPlayerOnTurn() {
        return playerOnTurn;
    }

    public void setPlayerOnTurn(Player playerOnTurn) {
        this.playerOnTurn = playerOnTurn;
    }

    public FieldState getState() {
        return state;
    }


    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }


    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void minusActualPlayerCountBlue(){
            actualPlayerCountBlue--;
    }
    public void minusActualPlayerCountRed(){
        actualPlayerCountRed--;
    }

    public void setUp(){
        int startingPos = 0;
        int endingPos = 23;
        for (int i = startingPos; i<= endingPos; i++){
            positions.add(new Position());
            positions.get(i).setId(i);          //zadavanie ideciek pre kazdu poziciu
            positions.get(i).setPlayer(null);
        }
        positions.get(0).setRight(positions.get(1));  //zadavanie susedov pre konkretne pozicie
        positions.get(0).setDown(positions.get(9));

        positions.get(1).setRight(positions.get(2));
        positions.get(1).setLeft(positions.get(0));
        positions.get(1).setDown(positions.get(4));

        positions.get(2).setLeft(positions.get(1));
        positions.get(2).setDown(positions.get(14));

        positions.get(3).setRight(positions.get(4));
        positions.get(3).setDown(positions.get(10));

        positions.get(4).setLeft(positions.get(3));
        positions.get(4).setRight(positions.get(5));
        positions.get(4).setUp(positions.get(1));
        positions.get(4).setDown(positions.get(7));

        positions.get(5).setLeft(positions.get(4));
        positions.get(5).setDown(positions.get(13));

        positions.get(6).setRight(positions.get(7));
        positions.get(6).setDown(positions.get(11));

        positions.get(7).setLeft(positions.get(6));
        positions.get(7).setRight(positions.get(8));
        positions.get(7).setUp(positions.get(4));

        positions.get(8).setLeft(positions.get(7));
        positions.get(8).setDown(positions.get(12));

        positions.get(9).setRight(positions.get(10));
        positions.get(9).setUp(positions.get(0));
        positions.get(9).setDown(positions.get(21));

        positions.get(10).setRight(positions.get(11));
        positions.get(10).setLeft(positions.get(9));
        positions.get(10).setUp(positions.get(3));
        positions.get(10).setDown(positions.get(18));

        positions.get(11).setLeft(positions.get(10));
        positions.get(11).setUp(positions.get(6));
        positions.get(11).setDown(positions.get(15));

        positions.get(12).setRight(positions.get(13));
        positions.get(12).setUp(positions.get(8));
        positions.get(12).setDown(positions.get(17));

        positions.get(13).setRight(positions.get(14));
        positions.get(13).setLeft(positions.get(12));
        positions.get(13).setUp(positions.get(5));
        positions.get(13).setDown(positions.get(20));

        positions.get(14).setLeft(positions.get(13));
        positions.get(14).setUp(positions.get(2));
        positions.get(14).setDown(positions.get(23));

        positions.get(15).setRight(positions.get(16));
        positions.get(15).setUp(positions.get(11));

        positions.get(16).setLeft(positions.get(15));
        positions.get(16).setRight(positions.get(17));
        positions.get(16).setDown(positions.get(19));

        positions.get(17).setLeft(positions.get(16));
        positions.get(17).setUp(positions.get(12));

        positions.get(18).setRight(positions.get(19));
        positions.get(18).setUp(positions.get(10));

        positions.get(19).setRight(positions.get(20));
        positions.get(19).setLeft(positions.get(18));
        positions.get(19).setUp(positions.get(16));
        positions.get(19).setDown(positions.get(22));

        positions.get(20).setLeft(positions.get(19));
        positions.get(20).setUp(positions.get(13));

        positions.get(21).setRight(positions.get(22));
        positions.get(21).setUp(positions.get(9));

        positions.get(22).setRight(positions.get(23));
        positions.get(22).setLeft(positions.get(21));
        positions.get(22).setUp(positions.get(19));

        positions.get(23).setLeft(positions.get(22));
        positions.get(23).setUp(positions.get(14));
    }

    public void placement(){  // Prva faza hry
        ConsoleUI consoleUI = new ConsoleUI(this);
        int i,x;
        Mark mark = new Mark();
        while(startingPlayerCountBlue > 0 || startingPlayerCountRed > 0 ){ //check na to ci este maju hraci nejakych zvysnych panacikov
            System.out.println("Zadaj číslo pozície na ktorú chceš uložiť panáčika");
            System.out.println("Červeny je na rade");
            i= consoleUI.handeInput();
            while(!mark.exec(i - 1, player1, this)){
                i= consoleUI.handeInput();
            }
            consoleUI.show();
            if(mill.check(i-1,this)){       //check mlynu
                System.out.println("Odstran jedneho z druheho teamu");
                x= consoleUI.handeInput();
                remove.remove(x-1,this,player1);
            }
            startingPlayerCountRed--;
            System.out.println("Modry je na rade");
            System.out.println("Zadaj číslo pozície na ktorú chceš uložiť panáčika");
            x= consoleUI.handeInput();
            while(!mark.exec(x - 1, player2, this)){        // oznacovanie pozicie
                x= consoleUI.handeInput();
            }

            startingPlayerCountBlue--;
            consoleUI.show();
            //System.out.println(z);
            if(mill.check(x-1,this)){
                System.out.println("Odstran jedneho z druheho teamu");
                x= consoleUI.handeInput();
                remove.remove(x-1,this,player2);
            }
        }
    }


    public void movement(){
        ConsoleUI consoleUI = new ConsoleUI(this);
        Move move = new Move();
        int i,x;
        while((actualPlayerCountRed>2 && actualPlayerCountBlue>2)) {
            System.out.println("Červeny je na rade");
            Turn(consoleUI, move, player1);
            if(actualPlayerCountBlue<3) {
                System.out.println("Modry má menej ako tri pozicie! Prehral!");
                break;
            }
            if((!move.checkIfCanAnyoneMove(this,player2))){
                System.out.println("MODRY SA NEVIE POHNUT CERVENY VYHRAVA");
                break;
            }
            System.out.println("Modrý je na rade");
            Turn(consoleUI, move, player2);
            if(actualPlayerCountRed<3) {
                System.out.println("Cerveny má menej ako tri pozicie! Prehral!");
                break;
            }
            if((!move.checkIfCanAnyoneMove(this,player1))){
                System.out.println("CERVENY SA NEVIE POHNUT MODRY VYHRAVA");
                break;
            }
        }

    }

    private void Turn(ConsoleUI consoleUI, Move move, Player player2) { //jeden tah hraca pre movement fazu
        int i;
        int x;
        System.out.println("Zadaj číslo pozície svojho panacika co chces pohnut");
        i = consoleUI.handeInput();
        System.out.println("Zadaj číslo pozície kam chces svojho panacika pohnut");
        x = consoleUI.handeInput();
        while (!move.check(i - 1, x - 1, this, player2)) {
            System.out.println("Zly input, skus znova");
            System.out.println("Zadaj číslo pozície svojho panacika co chces pohnut");
            i = consoleUI.handeInput();
            System.out.println("Zadaj číslo pozície kam chces svojho panacika pohnut");
            x = consoleUI.handeInput();
        }
        if(mill.check(x-1,this)){
            System.out.println("Odstran jedneho z druheho teamu");
            x= consoleUI.handeInput();
            remove.remove(x-1,this, player2);
        }
    }
}
