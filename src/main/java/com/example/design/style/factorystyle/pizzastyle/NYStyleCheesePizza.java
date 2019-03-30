package com.example.design.style.factorystyle.pizzastyle;

import com.example.design.style.factorystyle.Pizza;
import com.example.design.style.factorystyle.ingredient.Dough;
import com.example.design.style.factorystyle.ingredient.PizzaIngredientFactory;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class NYStyleCheesePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public NYStyleCheesePizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
//        name = " NYStyleCheesePizza sauce and cheese pizza";
//        dough = "Thin crust dough";
//        sauce = " Marinara sauce";
//        toppings.add("Grated Reggiano cheese");
    }

    @Override
    public void prepare() {
        System.out.println("preparing "+name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
