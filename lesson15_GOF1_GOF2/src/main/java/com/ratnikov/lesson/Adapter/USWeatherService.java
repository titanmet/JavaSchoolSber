package com.ratnikov.lesson.Adapter;

public class USWeatherService {
    /**
     * Возвращает температуру
     * @param latitude - широта
     * @param longtitude - долгота
     * @return температура в градусах Фаренгейта
     */
    public double getTemperature(double latitude, double longtitude) {
        if (latitude == 38.53 && longtitude == 77.02) // Washington
            return 86;
        else
        if (latitude == 40.43 && longtitude == 73.59) // New York
            return 95;
        else
            return 80;
    }

    /**
     * Возвращает скорость ветра
     * @param latitude - широта
     * @param longtitude - долгота
     * @return скорость ветра в ft/min
     */
    public double getWind(double latitude, double longtitude) {
        if (latitude == 38.53 && longtitude == 77.02) // Washington
            return 1000;
        else
        if (latitude == 40.43 && longtitude == 73.59) // New York
            return 2000;
        else
            return 1500;
    }
}
