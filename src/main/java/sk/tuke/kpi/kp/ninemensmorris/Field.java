package sk.tuke.kpi.kp.ninemensmorris;
import java.util.ArrayList;
import java.util.*;
public class Field {
    private static String reset = "\u001B[0m";
    private ArrayList<Position> positions = new ArrayList<Position>();
    private ArrayList<Player> red = new ArrayList<Player>();
    private ArrayList<Player> blue = new ArrayList<Player>();
    private int endingPos = 23;
    private int startingPos = 0;
    private int startingPlayerCountRed = 9;
    private int startingPlayerCountBlue = 9;
    public enum Color {RED, BLUE};
    Player player1 = new Player(Field.Color.RED);
    Player player2 = new Player(Field.Color.BLUE);

    public ArrayList<Position> getPositions() {
        return positions;
    }
    public int getEndingPos() {
        return endingPos;
    }
    public int getStartingPlayerCountRed(){
        return startingPlayerCountRed;
    }
    public int getStartingPlayerCountBlue(){
        return startingPlayerCountBlue;
    }


    public void setUp(){
        for (int i=startingPos;i<=endingPos;i++){
            positions.add(new Position());
            positions.get(i).setId(i);
            positions.get(i).setPlayer(null);
        }
        positions.get(0).setRight(positions.get(1));
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
    public void placement(){
        Scanner sc= new Scanner(System.in);
        int i,x;
        Mark mark = new Mark();
        while(startingPlayerCountBlue > 0 || startingPlayerCountRed > 0 ){
            System.out.println("Zadaj kde to chces dat");
            System.out.println("Ide cerveny");
            i= sc.nextInt();
            while(i>24 || i<1 || !mark.exec(i - 1, player1, this)){
                System.out.println("Zly input, Skus znova");
                i= sc.nextInt();
            }
            update();
            System.out.println("Ide modry");
            x= sc.nextInt();
            while(x>24 || x<1 || !mark.exec(x - 1, player2, this)){
                System.out.println("Zly input, Skus znova");
                x= sc.nextInt();
            }
            startingPlayerCountBlue--;
            update();
        }
    }
    public void update(){
        ArrayList<Position> positions = this.getPositions();
        System.out.println(positions.get(0).getColor()+"01"+reset+"-----------"+positions.get(1).getColor()+"02"+reset+"-----------"+positions.get(2).getColor()+"03");
        System.out.println(reset+"|            |             |");
        System.out.println("|    "+positions.get(3).getColor()+"04"+reset+"------"+positions.get(4).getColor()+"05"+reset+"------"+positions.get(5).getColor()+"06"+reset+"    |");
        System.out.println("|    |       |        |    |");
        System.out.println("|    |  "+positions.get(6).getColor()+"07"+reset+"---"+positions.get(7).getColor()+"08"+reset+"---"+positions.get(8).getColor()+"09"+reset+"  |    |");
        System.out.println("|    |  |          |  |    |");
        System.out.println(positions.get(9).getColor()+"10"+reset+"--"+positions.get(10).getColor()+"11"+reset+"--"+positions.get(11).getColor()+"12        "+positions.get(12).getColor()+"13"+reset+"--"+positions.get(13).getColor()+"14"+reset+"--"+positions.get(14).getColor()+"15");
        System.out.println(reset+"|    |  |          |  |    |");
        System.out.println("|    |  "+positions.get(15).getColor()+"16"+reset+"---"+positions.get(16).getColor()+"17"+reset+"---"+positions.get(17).getColor()+"18"+reset+"  |    |");
        System.out.println("|    |       |        |    |");
        System.out.println("|    "+positions.get(18).getColor()+"19"+reset+"------"+positions.get(19).getColor()+"20"+reset+"------"+positions.get(20).getColor()+"21"+reset+"    |");
        System.out.println("|            |             |");
        System.out.println(positions.get(21).getColor()+"22"+reset+"-----------"+positions.get(22).getColor()+"23"+reset+"-----------"+positions.get(23).getColor()+"24"+reset);
    }
}
