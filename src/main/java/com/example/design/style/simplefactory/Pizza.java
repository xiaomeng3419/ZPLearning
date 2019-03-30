package com.example.design.style.simplefactory;


import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/1/20.
 */
public abstract class Pizza {

    public String name;
    public String dough;
    public String sauce;

    public ArrayList toppings = new ArrayList();

   public void prepare(){
        System.out.println("prepare..."+ name);
        System.out.println("tossing dough...");
        System.out.println("add sauce...");
        System.out.println("add toppings:");
        for (int i = 0 ; i < toppings.size();i++){
            System.out.println("   "+toppings.get(i));
        }
    }
    public void bake(){ System.out.println("bake...");}
    public void cut(){ System.out.println("cut...");}
    public void box(){ System.out.println("box...");}
    
    public String getName(){
        return name;
    }
}
