package com.ratnikov.lesson.fabric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondServiceHandler implements IHandler {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() {
        return name;
    }
}
