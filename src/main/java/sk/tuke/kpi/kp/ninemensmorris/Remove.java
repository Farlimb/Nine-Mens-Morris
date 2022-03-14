package sk.tuke.kpi.kp.ninemensmorris;

import java.util.Scanner;

import static sk.tuke.kpi.kp.ninemensmorris.Field.Color.RED;

public class Remove {
    public void remove(int i, Field field,Player player){
        Position position = field.getPositions().get(i);
            if(position.getPlayer()==player || position.getPlayer()==null){
                System.out.println("Nezadal si nepriatelov domcek! Skús znova");
                Scanner sc= new Scanner(System.in);
                i = sc.nextInt();
                remove(i-1,field,player);
            }
            else {
                position.setPlayer(null);
                position.setColor("\u001B[0m");
                field.update();
                if(player.getColor()==RED){
                    field.minusActualPlayerCountBlue();
                }
                else
                    field.minusActualPlayerCountRed();
            }
    }
}
