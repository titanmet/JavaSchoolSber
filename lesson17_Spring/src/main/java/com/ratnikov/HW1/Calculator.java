package com.ratnikov.HW1;

import com.ratnikov.HW1.service.H2DB;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
    @SneakyThrows
    @Cachable(H2DB.class)
    public List<Integer> fibonachi(int n) {
        Method method = this.getClass().getDeclaredMethod("fibonachiList", int.class);
        if (!method.isAnnotationPresent(Cachable.class)) {
            return fibonachiList(n);
        }
        Cachable cachable = method.getAnnotation(Cachable.class);
        Source source = cachable.value().newInstance();
        List list = source.getFibonachi(n);
        if (list == null) {
            source.saveFibonachi(list);
        }
        return list;
    }

    private List<Integer> fibonachiList(int n) {
        List<Integer> list = new LinkedList<>();
        int res = 0;
        int count = 0;
        while (count != n) {
            if (count == 0 || count == 1) {
                list.add(1);
                count++;
            } else {
                res = list.get(count - 1) + list.get(count - 2);
                list.add(res);
                count++;
            }
        }
        return list;
    }
}
