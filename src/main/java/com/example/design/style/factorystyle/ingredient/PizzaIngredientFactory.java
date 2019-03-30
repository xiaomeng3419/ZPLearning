package com.example.design.style.factorystyle.ingredient;

/**
 * Created by zhangpan on 2019/1/20.
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperon createPepperon();
    public Clams createClam();

}
