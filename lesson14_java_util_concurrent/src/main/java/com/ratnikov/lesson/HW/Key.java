package com.ratnikov.lesson.HW;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Key {
    private String methodName;
    private List<Object> args;

    public Key(String methodName, Object[] args) {
        this.methodName = methodName;
        this.args = Arrays.asList(args);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (methodName != null ? !methodName.equals(key.methodName) : key.methodName != null) return false;
        return args != null ? args.equals(key.args) : key.args == null;
    }

    @Override
    public int hashCode() {
        int result = methodName != null ? methodName.hashCode() : 0;
        result = 31 * result + (args != null ? args.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Key{" +
                "methodName='" + methodName + '\'' +
                ", args=" + args +
                '}';
    }
}
