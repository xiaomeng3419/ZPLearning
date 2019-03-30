package com.example.design.style.factorystyle;


import com.example.design.style.factorystyle.store.NYPizzaStore;
import com.example.design.style.factorystyle.store.PizzaStore;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class PizzaTestStore {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.orderPizza("cheese");
       /* PizzaStore nystore = new NYPizzaStore();
        PizzaStore chstore = new ChicagoPizzaStore();
        Pizza pizza = nystore.orderPizza("cheese");
        System.out.println(" zhangpan order a "+ pizza.getName() +"\n");


        pizza = chstore.orderPizza("cheese");
        System.out.println(" lisi order a "+ pizza.getName() +"\n");
*/
    }
}
