package com.ratnikov.HW1.aspect;

import org.springframework.stereotype.Service;

@Service
public class NotMyService {
    //    Advice, Before, PointerCut - срез точек соединения
    public void call(String s) {
        System.out.println("NotMyService.call UNDER ASPECT J " + s);
    }

    public void exec(String st) {
        System.out.println("exec");
    }
}
