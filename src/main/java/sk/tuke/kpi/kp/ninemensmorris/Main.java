package sk.tuke.kpi.kp.ninemensmorris;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean playing = true;
        Scanner sc= new Scanner(System.in);
        while(playing) {
            System.out.println("Welcome to Nine Men's Morris");
            Field field = new Field();
            field.setUp();
            field.show();
            field.placement();
            field.movement();
            char str = 'x';
            while (str!='N' && str!='n' && str!='a' && str!='A'){
                System.out.println("Do you want to play again? A/N");
                str = sc.next().charAt(0);
                if(str=='N' || str=='n')
                    playing = false;
            }
        }
    }

}
