package com.ratnikov.lesson.builder;

public class House {
    private boolean base = false;
    private boolean building = false;
    private boolean serviceLines = false;
    private boolean finish = false;

    public boolean isBase() {
        return base;
    }
    public void setBase(boolean base) {
        this.base = base;
    }
    public boolean isBuilding() {
        return building;
    }
    public void setBuilding(boolean building) {
        this.building = building;
    }
    public boolean isServiceLines() {
        return serviceLines;
    }
    public void setServiceLines(boolean serviceLines) {
        this.serviceLines = serviceLines;
    }
    public boolean isFinish() {
        return finish;
    }
    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public String YN(boolean r) {
        return r ? "Да" : "Нет";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Фундамент : ").append(YN(isBase())).append('\n').
                append("Строение : ").append(YN(isBuilding())).append('\n').
                append("Коммуникации : ").append(YN(isServiceLines())).append('\n').
                append("Отделка : ").append(YN(isFinish())).append('\n');
        return sb.toString();
    }
}
