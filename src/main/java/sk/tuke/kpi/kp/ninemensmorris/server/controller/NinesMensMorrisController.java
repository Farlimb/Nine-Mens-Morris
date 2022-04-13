package sk.tuke.kpi.kp.ninemensmorris.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nine_mens_morris")
public class NinesMensMorrisController {

    @RequestMapping
    public String morris(){
        return "nine_mens_morris";
    }
}
