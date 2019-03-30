package com.example.design.style.simplefactory.pizzastyle;

import com.example.design.style.simplefactory.Pizza;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class NYStyleCheesePizza extends Pizza {

//    PizzaIngredientFactory ingredientFactory;

    public NYStyleCheesePizza(){
        name = " NYStyleCheesePizza sauce and cheese pizza";
        dough = "Thin crust dough";
        sauce = " Marinara sauce";
        toppings.add("Grated Reggiano cheese");
    }
}
