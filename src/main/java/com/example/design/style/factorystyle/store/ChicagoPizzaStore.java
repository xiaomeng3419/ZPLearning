package com.example.design.style.factorystyle.store;

import com.example.design.style.factorystyle.Pizza;
import com.example.design.style.simplefactory.pizzastyle.ChicagoStyleCheesePizza;
import com.example.design.style.simplefactory.pizzastyle.ChicagoStyleClamPizza;
import com.example.design.style.simplefactory.pizzastyle.ChicagoStylePepperonPizza;
import com.example.design.style.simplefactory.pizzastyle.ChicagoStyleVeggiePizza;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        return null;
//        if(type.equals("cheese")){
//            return  new ChicagoStyleCheesePizza();
//        }else if( type .equals("veggie")){
//            return new ChicagoStyleVeggiePizza();
//        }else if(type.equals("clam")){
//            return new ChicagoStyleClamPizza();
//        }else if(type.equals("pepperon")){
//            return new ChicagoStylePepperonPizza();
//        }else {
//            return null;
//        }
    }
}
