package com.example.design.style.observer;

/**
 * Created by zhangpan on 2019/3/31.
 */
public class WeatherStation {
    public static void main(String[] args) {
                WeatherData weatherData = new WeatherData();
                CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);
                weatherData.setMeasurements(10,23,30.5f);
                weatherData.setMeasurements(10,22,30.9f);
                weatherData.setMeasurements(10,21,30.1f);
                weatherData.setMeasurements(90,23,32.4f);
    }
}
