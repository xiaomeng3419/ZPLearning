package com.example.design.style.simplefactory.pizzastyle;

import com.example.design.style.simplefactory.Pizza;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class ChicagoStyleCheesePizza extends Pizza {
     public ChicagoStyleCheesePizza(){
         name = " ChicagoStyleCheesePizza deep dish   cheese pizza";
         dough = "extra thick crust dough";
         sauce = " plum tomato sauce";
         toppings.add("Shredded Mozzarella cheese");
     }

    @Override
    public void cut() {
        System.out.println("cutting the pizza into square slices");
    }
}
