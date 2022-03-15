package sk.tuke.kpi.kp.ninemensmorris.core;
import sk.tuke.kpi.kp.ninemensmorris.consoleui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        ConsoleUI consoleUI = new ConsoleUI(field);
        consoleUI.play();
    }

}
