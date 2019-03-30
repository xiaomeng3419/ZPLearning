package com.example.design.style.factorystyle.store;

import com.example.design.style.factorystyle.Pizza;

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
