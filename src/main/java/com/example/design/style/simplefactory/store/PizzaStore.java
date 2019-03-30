package com.example.design.style.simplefactory.store;

import com.example.design.style.simplefactory.Pizza;

import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/1/20.
 */
public abstract class PizzaStore {


    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }


    protected abstract Pizza createPizza(String type);

}
