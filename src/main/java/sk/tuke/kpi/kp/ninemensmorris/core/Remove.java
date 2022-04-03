package sk.tuke.kpi.kp.ninemensmorris.core;

import sk.tuke.kpi.kp.ninemensmorris.consoleui.ConsoleUI;

import java.util.Scanner;

import static sk.tuke.kpi.kp.ninemensmorris.core.Field.Color.RED;

public class Remove {
    public void remove(int i, Field field,Player player){
        ConsoleUI consoleUI = new ConsoleUI(field);
        Position position = field.getPositions().get(i);
            if(position.getPlayer()==player || position.getPlayer()==null){   //check ci je ta pozicia nepriatelova
                System.out.println("Nezadal si nepriatelov domcek! Skús znova");
                Scanner sc= new Scanner(System.in);
                i = consoleUI.handeInput();
                remove(i-1,field,player);
            }
            else {
                position.setPlayer(null);
                position.setColor("\u001B[0m");
                consoleUI.show();
                var score = player.getScore().getPoints();
                player.getScore().setPoints(score+100);   //pridavanie skore
                if(player.getColor()==RED){       //check ze koho to je a potom zoberie druhemu hracovi z celkoveho poctu
                    field.minusActualPlayerCountBlue();
                }
                else
                    field.minusActualPlayerCountRed();
            }
    }
}
