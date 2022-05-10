package sk.tuke.kpi.kp.ninemensmorris.server.webservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.kpi.kp.ninemensmorris.core.*;
import sk.tuke.kpi.kp.ninemensmorris.entity.Score;
import sk.tuke.kpi.kp.ninemensmorris.service.ScoreService;

import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping("/api/nine_mens_morris/field")
public class Nine_Mens_Morris_RestService {
    private Field field = new Field();
    private final Mark mark = new Mark();
    private final Remove remove = new Remove();
    private final Move move = new Move();
    private final Mill mill = new Mill();
    private int x=-1;
    private int y=-1;
    private int z=-1;

    @Autowired
    private ScoreService scoreService;

    @GetMapping()
    public Field getField(){
        return field;
    }

    @GetMapping("/newGame")
    public Field newGame(){
        this.field = new Field();
        return field;
    }

    @GetMapping("/markPos")
    public Field markPos(@RequestParam int position, @RequestParam String string){
        if(field.getState()== FieldState.PLAYING) {
            System.out.println("hellou");
            if (field.getStartingPlayerCountRed() > 0) {
                if (!mill.check(z, field)) {
                    System.out.println("CERVENY");
                    if (Objects.equals(string, "RED")) {
                        System.out.println("CERVENY");
                        if (mark.exec(position, field.getPlayer1(), field)) {
                            field.setStartingPlayerCountRed(field.getStartingPlayerCountRed() - 1);
                            if (!mill.check(position, field)) {
                                if (Objects.equals(string, "RED"))
                                    field.setPlayerOnTurn(field.getPlayer2());
                            } else {
                                z = position;
                            }
                        }
                    }
                }
            }

            if (field.getStartingPlayerCountBlue() > 0) {
                if (Objects.equals(string, "BLUE")) {
                    if (!mill.check(z, field)) {
                        if (mark.exec(position, field.getPlayer2(), field)) {
                            field.setStartingPlayerCountBlue(field.getStartingPlayerCountBlue() - 1);
                            if (!mill.check(position, field)) {
                                if (Objects.equals(string, "BLUE"))
                                    field.setPlayerOnTurn(field.getPlayer1());
                            } else {
                                z = position;
                            }
                        }
                    }

                }
            }

            System.out.println(field.getStartingPlayerCountBlue());
            System.out.println(field.getStartingPlayerCountRed());
            if (field.getStartingPlayerCountBlue() == 0 && field.getStartingPlayerCountRed() == 0) {
                System.out.println("tu sa dostal");
                if (x == -1) {
                    System.out.println("tu sa dostal XXX");
                    x = position;
                } else if (y == -1) {
                    System.out.println("tu sa dostal yyy");
                    y = position;
                    z = y;

                    if (move.check(x, y, field, field.getPlayerOnTurn())) {
                        if (!mill.check(z, field)) {
                            if (field.getPlayerOnTurn() == field.getPlayer2()) {
                                field.setPlayerOnTurn(field.getPlayer1());
                            } else {
                                field.setPlayerOnTurn(field.getPlayer2());
                            }
                        }
                    }


                    System.out.println("RESET");
                    y = -1;
                    x = -1;
                }

                System.out.println(x);
                System.out.println(y);
            }
        }
        return field;
    }

    @GetMapping("/removePos")
    public Field removePos(@RequestParam int position, @RequestParam String string){
        if(field.getState()== FieldState.PLAYING) {
            System.out.println("hovno");
            System.out.println(z);
            if (z != -1) {
                if (mill.check(z, field)) {
                    System.out.println("hovno1");
                    remove.remove(position, field, field.getPlayerOnTurn());
                    if (field.getPlayerOnTurn() == field.getPlayer2()) {
                        field.setPlayerOnTurn(field.getPlayer1());
                    } else {
                        field.setPlayerOnTurn(field.getPlayer2());
                    }
                }
                z = -1;
            }

            if (field.getActualPlayerCountRed() < 3 || field.getActualPlayerCountBlue() < 3) {
                field.setState(FieldState.DONE);
                scoreService.addScore(new Score("Jozo", "nine_mens_morris" , field.getPlayer1().getScore().getPoints(),new Date()));
            }
        }
        return field;
    }

}
