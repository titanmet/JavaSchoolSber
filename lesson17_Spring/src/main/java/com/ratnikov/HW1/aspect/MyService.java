package com.ratnikov.HW1.aspect;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    //    Advice, Before, PointerCut - срез точек соединения
    public void callMyService(String s) {
        System.out.println("MyService.callMyService UNDER ASPECT J " + s);
    }

    public void execute(String st) {
        System.out.println("execute");
    }
}
