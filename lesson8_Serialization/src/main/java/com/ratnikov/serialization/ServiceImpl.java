package com.ratnikov.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ServiceImpl implements Service, Serializable {
    private static final long serialVersionID = 1L;
    private String work;
    private double i;
    private Date date;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ServiceImpl{" +
                "work='" + work + '\'' +
                ", i=" + i +
                ", date=" + date +
                '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject("Work23");
        out.writeDouble(769);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        setWork((String) in.readObject());
        setI(in.readDouble());
    }

    public void doHardWork() {
        System.out.println(work + " - Квадратный корень - " + i + " = " + Math.sqrt(i) + " Дата: " + date);
        System.out.println(run(work, i, date));
        System.out.println(work(work));
    }

    @Override
    public double doHardWork(String item, double value, Date date) {
        Service service = new ServiceImpl();
        return service.doHardWork(work, i, date);
    }

    public List<String> run(String item, double value, Date date) {
        List<String> list = new ArrayList<>();
        for (int j = 0; j < 9; j++) {
            String str = item + value + (date.toString() + j);
            list.add(str);
        }
        return list;
    }

    @Override
    public List<String> work(String item) {
        List<String> list = new ArrayList<>();
        for (int j = 0; j < 9; j++) {
            String str = item + j;
            list.add(str);
        }
        return list;
    }

    @Override
    public double calc(double n, double n1) {
        return n * n1;
    }
}
