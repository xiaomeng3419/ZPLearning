package com.example.design.style.observer;

/**
 * Created by zhangpan on 2019/3/31.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
