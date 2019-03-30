package com.example.design.style.factorystyle.store;

import com.example.design.style.factorystyle.Pizza;
import com.example.design.style.factorystyle.ingredient.NYPizzaIngredientFactory;
import com.example.design.style.factorystyle.ingredient.PizzaIngredientFactory;
import com.example.design.style.factorystyle.pizzastyle.NYStyleCheesePizza;
import com.example.design.style.factorystyle.pizzastyle.NYStyleClamPizza;
import com.example.design.style.factorystyle.pizzastyle.NYStylePepperonPizza;
import com.example.design.style.factorystyle.pizzastyle.NYStyleVeggiePizza;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza =  null;

        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();


        if(type.equals("cheese")){
            pizza = new NYStyleCheesePizza(ingredientFactory);
            pizza.setName("new york Style Cheese Pizza");
        }else if( type .equals("veggie")){
            pizza = new NYStyleVeggiePizza(ingredientFactory);
            pizza.setName("new york Style NYStyleVeggiePizza  Pizza");
        }else if(type.equals("clam")){
            pizza = new NYStyleClamPizza(ingredientFactory);
            pizza.setName("new york Style NYStyleClamPizza  Pizza");
        }else if(type.equals("pepperon")){
            pizza = new NYStylePepperonPizza(ingredientFactory);
            pizza.setName("new york Style NYStylePepperonPizza  Pizza");
        }else {
        }
        return pizza;
    }
}
