package com.example.design.style.factorystyle.pizzastyle;

import com.example.design.style.factorystyle.Pizza;
import com.example.design.style.factorystyle.ingredient.PizzaIngredientFactory;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class NYStyleClamPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;
    public NYStyleClamPizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }


    @Override
    public void prepare() {
        System.out.println("preparing "+name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
