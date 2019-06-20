package com.example.collection;

import com.example.collection.reflect.String;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangpan on 2019/3/26.
 * bigdecimal https://www.cnblogs.com/LeoBoy/p/6056394.html
 * 抽象被观察者角色：也就是一个抽象主题，它把所有对观察者对象的引用保存在一个集合中，每个主题都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
 抽象观察者角色：为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
 具体被观察者角色：也就是一个具体的主题，在集体主题的内部状态改变时，所有登记过的观察者发出通知。
 具体观察者角色：实现抽象观察者角色所需要的更新接口，一边使本身的状态与制图的状态相协调。
 */
public class CDemo4 {
    public static void main(String[] args) {
        Map<String ,Object> map = new HashMap<>();
        Map<String,Object> map1 = new ConcurrentHashMap<>();
//        Arrays.sort();
//        BigDecimal
    }

}
