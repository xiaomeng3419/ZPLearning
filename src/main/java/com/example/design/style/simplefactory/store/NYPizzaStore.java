package com.example.design.style.simplefactory.store;

import com.example.design.style.simplefactory.Pizza;
import com.example.design.style.simplefactory.pizzastyle.NYStyleCheesePizza;
import com.example.design.style.simplefactory.pizzastyle.NYStyleClamPizza;
import com.example.design.style.simplefactory.pizzastyle.NYStylePepperonPizza;
import com.example.design.style.simplefactory.pizzastyle.NYStyleVeggiePizza;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class NYPizzaStore extends  PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return  new NYStyleCheesePizza();
        }else if( type .equals("veggie")){
            return new NYStyleVeggiePizza();
        }else if(type.equals("clam")){
            return new NYStyleClamPizza();
        }else if(type.equals("pepperon")){
            return new NYStylePepperonPizza();
        }else {
            return null;
        }
    }
}
