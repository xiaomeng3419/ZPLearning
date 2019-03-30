package com.example.design.style.buildstyle;

/**
 * Created by zhangpan on 2019/1/20.
 * https://blog.csdn.net/niunai112/article/details/79633492
 */
public class Customer {
    public static void main(String[] args) {
        ServerProduct customer = new ServerProduct();
        customer.setOs("Ubuntu");
        customer.setLanguage("Java");;
        customer.setDatabase("Mysql");
        customer.setServer("Tomcat");
        System.out.println("客户1要的环境：" + customer.getEnvironment());



        ServerProduct customer2 = new ServerProduct();
        customer2.setOs("Ubuntu");
        customer2.setLanguage("Java");;
        customer2.setDatabase("Mysql");
        customer2.setServer("Tomcat");
        System.out.println("客户2要的环境：" + customer2.getEnvironment());



        Director director = new Director();
        ServerProduct classicCentOSEnvironment1 = director.createClassicCentOSEnvironment();
        System.out.println("创建第一个环境：" + classicCentOSEnvironment1.getEnvironment());
        ServerProduct classicCentOSEnvironment2 = director.createClassicUbuntuEnvironment();
        System.out.println("创建第二个环境：" + classicCentOSEnvironment2.getEnvironment());
    }
}
