package com.ratnikov.serialization;

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
        if (this == o) {
            return true;
        }
        if (!(o instanceof Key)) {
            return false;
        }
        Key that = (Key) o;
        return Objects.equals(methodName, that.methodName) &&
                Objects.equals(args, that.args);
    }

    @Override
    public int hashCode() {

        return Objects.hash(methodName, args);
    }

    @Override
    public String toString() {
        return "KeyForMap{" +
                "methodName='" + methodName + '\'' +
                ", args=" + args +
                '}';
    }
}
