package com.example.design.style.factorystyle.ingredient;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Dough createDough() {
        return  new ThinCrustDough();
    }

    @Override
    public Clams createClam() {
        return new FreashClams();
    }

    @Override
    public Veggies[] createVeggies() {

        Veggies[] veggies={new Garlic(),new Mushroom(),new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperon createPepperon() {
        return new SlicedPepperon();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }
}
