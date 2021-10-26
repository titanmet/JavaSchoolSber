package com.ratnikov.hwcalendardocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;


@Controller
public class CalendarController {

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("datetime", new Date());
        return "index";
    }
}
