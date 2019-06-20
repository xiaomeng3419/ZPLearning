package com.example.design.style.observer;
import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/3/31.
 */
public class WeatherData implements Subject {
    private ArrayList observers;
    private float humidity;
    private float temperature;
    private float pressure;
    public WeatherData(){
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
     observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i =0;i<observers.size();i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }
    public  void  measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.humidity = humidity;
        this.temperature = temperature;
        this.pressure = pressure;

        measurementsChanged();
    }

}
