package com.ratnikov.lesson.Adapter;

public class USWeatherAdapter implements WeatherService {

    private double latitude;
    private double longtitude;
    private USWeatherService service;

    public USWeatherAdapter(USWeatherService service) {
        this.service = service;
    }

    @Override
    public double getTemperature() {
        double tf = service.getTemperature(latitude, longtitude);
        return (tf-32)*5/9; // F -> C
    }

    @Override
    public double getWind() {
        double windFtMin = service.getWind(latitude, longtitude);
        return windFtMin / 196.85; // ft/min -> m/s
    }

    @Override
    public double getFeelsLikeTemperature() {
        return 1.04*getTemperature()-getWind()*0.65-0.9; // высока¤ влажность
    }

    @Override
    public void setPosition(String city) {
        switch(city) {
            case "Вашингтон" :
                latitude = 38.53;
                longtitude = 77.02;
                break;
            case "Нью-Йорк" :
                latitude = 40.43;
                longtitude = 73.59;
                break;
        }
    }

}