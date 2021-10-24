package com.ratnikov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class ControllerExample {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return "control/helloPage";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String GoodBye() {
        return "Goodbye!";
    }
}
