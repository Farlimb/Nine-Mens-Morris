package sk.tuke.kpi.kp.ninemensmorris;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Nine Men's Morris");
        Field field = new Field();
        field.setUp();
        field.update();
        Player player = new Player(Field.Color.RED);
        Mark mark = new Mark();
        System.out.println("Zadaj kde to chces dat");
        int i= sc.nextInt();
        mark.exec(i-1,player,field);
        field.update();
        i= sc.nextInt();
        mark.exec(i-1,player,field);
        field.update();
    }

}
