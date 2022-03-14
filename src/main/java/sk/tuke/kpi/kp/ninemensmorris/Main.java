package sk.tuke.kpi.kp.ninemensmorris;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Nine Men's Morris");
        Field field = new Field();
        field.setUp();
        field.update();
        field.placement();
        field.movement();
    }

}
