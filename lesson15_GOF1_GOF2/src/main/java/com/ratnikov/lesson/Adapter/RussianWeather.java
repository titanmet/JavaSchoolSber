package com.ratnikov.lesson.Adapter;

public class RussianWeather implements WeatherService {

    String city;

    /**
     * Возвращает температуру
     * @return температура в градусах Цельсия
     */
    @Override
    public double getTemperature() {
        switch(city) {
            case "Москва"  : return 25;
            case "Санкт-Петербург" : return 18;
            default : return 20;
        }
    }

    /**
     * Возвращает скорость ветра
     * @return скорость ветра в м/с
     */
    @Override
    public double getWind() {
        switch(city) {
            case "Москва"  : return 5;
            case "Санкт-Петербург" : return 13;
            default : return 1;
        }
    }

    /**
     * Возвращает ощущаемую температуру
     * @return температура в градусах Цельсия
     */
    @Override
    public double getFeelsLikeTemperature() {
        switch(city) {
            case "Москва"  : return 23;
            case "Санкт-Петербург" : return 16;
            default : return 20;
        }
    }

    @Override
    public void setPosition(String city) {
        this.city = city;
    }

}