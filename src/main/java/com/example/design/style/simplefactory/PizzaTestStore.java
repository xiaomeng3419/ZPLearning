package com.example.design.style.simplefactory;

import com.example.design.style.simplefactory.store.ChicagoPizzaStore;
import com.example.design.style.simplefactory.store.NYPizzaStore;
import com.example.design.style.simplefactory.store.PizzaStore;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class PizzaTestStore {
    public static void main(String[] args) {
        PizzaStore nystore = new NYPizzaStore();
        PizzaStore chstore = new ChicagoPizzaStore();
        Pizza pizza = nystore.orderPizza("cheese");
        System.out.println(" zhangpan order a "+ pizza.getName() +"\n");


        pizza = chstore.orderPizza("cheese");
        System.out.println(" lisi order a "+ pizza.getName() +"\n");

    }
}
