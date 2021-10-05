package com.ratnikov.lesson.builder;

public class Documentation {
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
        return r ? "Получено" : "Нет";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Разрешение на строительство : ").append(YN(isBase())).append('\n').
                append("Утверждение сметы: ").append(YN(isBuilding())).append('\n').
                append("Разрешение на подключение коммуникаций : ").append(YN(isServiceLines())).append('\n').
                append("Ввод в эксплуатацию : ").append(YN(isFinish())).append('\n');
        return sb.toString();
    }


}