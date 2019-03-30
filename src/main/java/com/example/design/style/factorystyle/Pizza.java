package com.example.design.style.factorystyle;


import com.example.design.style.factorystyle.ingredient.*;

import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/1/20.
 */
public abstract class Pizza {

    public String name;
    public Dough dough;
    public Sauce sauce;
    public Cheese cheese;
    public Pepperon pepperon;
    public Clams clams;

    public ArrayList toppings = new ArrayList();

    public abstract void prepare() ;
  /*  public void ;prepare(){
        System.out.println("prepare..."+ name);
        System.out.println("tossing dough...");
        System.out.println("add sauce...");
        System.out.println("add toppings:");
        for (int i = 0 ; i < toppings.size();i++){
            System.out.println("   "+toppings.get(i));
        }
    }*/
    public void bake(){ System.out.println("bake...");}
    public void cut(){ System.out.println("cut...");}
    public void box(){ System.out.println("box...");}
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
