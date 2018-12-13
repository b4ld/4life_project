package org.academiadecodigo.invictus.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @RequestMapping("/")
    public String home() {
        return "redirect/four_life/index";
    }
}
