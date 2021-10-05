package com.ratnikov.lesson.Adapter;

public class Main {
    public static void main(String[] args) {
        WeatherService service = new RussianWeather();
        service.setPosition("Москва");
        //service.setPosition("Санкт-Петербург");

        System.out.println("Москва");
        System.out.printf("Температура (C)          : %4.1f\n",
                service.getTemperature());
        System.out.printf("Скорость ветра (м/с)     : %4.1f\n",
                service.getWind());
        System.out.printf("Ощущаемая температура (C): %4.1f\n",
                service.getFeelsLikeTemperature());

        //не работает - не совместимы интерфейсы
        //service = new USWeatherService();

        // используем адаптер
        service = new USWeatherAdapter(new USWeatherService());
        service.setPosition("Нью-Йорк");
        //service.setPosition("Вашингтон");

        System.out.println("Нью-Йорк");
        System.out.printf("Температура (C)          : %4.1f\n",
                service.getTemperature());
        System.out.printf("Скорость ветра (м/с)     : %4.1f\n",
                service.getWind());
        System.out.printf("Ощущаемая температура (C): %4.1f\n",
                service.getFeelsLikeTemperature());
    }
}
