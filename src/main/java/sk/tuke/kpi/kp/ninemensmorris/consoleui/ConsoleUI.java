package sk.tuke.kpi.kp.ninemensmorris.consoleui;

import sk.tuke.kpi.kp.ninemensmorris.core.Field;
import sk.tuke.kpi.kp.ninemensmorris.core.Position;
import sk.tuke.kpi.kp.ninemensmorris.core.FieldState;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleUI {
    private Scanner scanner= new Scanner(System.in);
    private Field field;
    public ConsoleUI(Field field){
    this.field=field;
    }
    private static final Pattern INPUT_PATTERN = Pattern.compile("([0-24])([0-24])");
    public void show(){
        ArrayList<Position> positions = field.getPositions();
        String reset = "\u001B[0m";
        System.out.println(positions.get(0).getColor()+"01"+ reset +"-----------"+positions.get(1).getColor()+"02"+ reset +"-----------"+positions.get(2).getColor()+"03");
        System.out.println(reset +"|            |             |");
        System.out.println("|    "+positions.get(3).getColor()+"04"+ reset +"------"+positions.get(4).getColor()+"05"+ reset +"------"+positions.get(5).getColor()+"06"+ reset +"    |");
        System.out.println("|    |       |        |    |");
        System.out.println("|    |  "+positions.get(6).getColor()+"07"+ reset +"---"+positions.get(7).getColor()+"08"+ reset +"---"+positions.get(8).getColor()+"09"+ reset +"  |    |");
        System.out.println("|    |  |          |  |    |");
        System.out.println(positions.get(9).getColor()+"10"+ reset +"--"+positions.get(10).getColor()+"11"+ reset +"--"+positions.get(11).getColor()+"12        "+positions.get(12).getColor()+"13"+ reset +"--"+positions.get(13).getColor()+"14"+ reset +"--"+positions.get(14).getColor()+"15");
        System.out.println(reset +"|    |  |          |  |    |");
        System.out.println("|    |  "+positions.get(15).getColor()+"16"+ reset +"---"+positions.get(16).getColor()+"17"+ reset +"---"+positions.get(17).getColor()+"18"+ reset +"  |    |");
        System.out.println("|    |       |        |    |");
        System.out.println("|    "+positions.get(18).getColor()+"19"+ reset +"------"+positions.get(19).getColor()+"20"+ reset +"------"+positions.get(20).getColor()+"21"+ reset +"    |");
        System.out.println("|            |             |");
        System.out.println(positions.get(21).getColor()+"22"+ reset +"-----------"+positions.get(22).getColor()+"23"+ reset +"-----------"+positions.get(23).getColor()+"24"+ reset);
    }
    public void play(){
        var playing = FieldState.PLAYING;
        while(playing==FieldState.PLAYING) {
            System.out.println("Welcome to Nine Men's Morris");
            field.setUp();
            show();
            field.placement();
            field.movement();
            char str = 0;
            while (str!='N' && str!='n' && str!='a' && str!='A'){
                System.out.println("Do you want to play again? A/N");
                str = scanner.next().charAt(0);
                if(str=='N' || str=='n')
                    playing = FieldState.DONE;
                else
                    field = new Field();
            }
        }
    }
    public int handeInput() {
        System.out.println("Enter command (X - exit, Position number): ");
        String line = scanner.nextLine().toUpperCase();
        if ("X".equals(line)) {
            System.exit(0);
        }
        try {
            if (Integer.parseInt(line) < 24 || Integer.parseInt(line) > 1) {
                return Integer.parseInt(line);
            }

        }
        catch (Exception e){
        System.out.println("Wrong input.");
        return handeInput();
        }

        System.out.println("Wrong input");
        return handeInput();

    }
}
