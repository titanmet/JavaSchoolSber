package com.ratnikov.lesson.fabric;

import org.springframework.stereotype.Service;

@Service
public class FirstServiceHandler implements IHandler {
    @Override
    public String execute() {
        return "First";
    }
}
