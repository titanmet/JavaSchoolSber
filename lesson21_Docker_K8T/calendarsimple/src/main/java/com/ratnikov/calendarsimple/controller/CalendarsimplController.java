package com.ratnikov.calendarsimple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CalendarsimplController {

    @GetMapping("getDate")
    public LocalDate getDate() {
        return LocalDate.now();
    }
}
