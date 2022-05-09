package sk.tuke.kpi.kp.ninemensmorris.server.webservice;
import org.springframework.web.bind.annotation.*;
import sk.tuke.kpi.kp.ninemensmorris.core.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/nine_mens_morris/field")
public class Nine_Mens_Morris_RestService {
    private Field field = new Field();
    private Mark mark = new Mark();
    private Remove remove = new Remove();
    private Move move = new Move();

    @GetMapping()
    public Field getField(){
        return field;
    }


    @GetMapping("/newGame")
    public Field newGame(){
        return new Field();
    }

    @GetMapping("/markPos")
    public Field markPos(@RequestParam int position, @RequestParam String color){
        System.out.println(color);
        System.out.println("aaaaaaaaa");
        if(mark.exec(position, field.getPlayer1(), field)){
            if(Objects.equals(color, "RED"))
            field.setPlayerOnTurn(field.getPlayer2());
        }
        return field;
    }

    @GetMapping("/removePos")
    public Field removePos(@RequestParam int position, @RequestParam Player player){
        remove.remove(position,field,player);
        return field;
    }

    @GetMapping("/movePos")
    public Field movePos(@RequestParam int positionX, @RequestParam int positionY, @RequestParam Player player){
        move.check(positionX,positionY,field,player);
        return field;
    }
}
