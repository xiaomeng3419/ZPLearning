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
        System.out.println("�ͻ�1Ҫ�Ļ�����" + customer.getEnvironment());



        ServerProduct customer2 = new ServerProduct();
        customer2.setOs("Ubuntu");
        customer2.setLanguage("Java");;
        customer2.setDatabase("Mysql");
        customer2.setServer("Tomcat");
        System.out.println("�ͻ�2Ҫ�Ļ�����" + customer2.getEnvironment());



        Director director = new Director();
        ServerProduct classicCentOSEnvironment1 = director.createClassicCentOSEnvironment();
        System.out.println("������һ��������" + classicCentOSEnvironment1.getEnvironment());
        ServerProduct classicCentOSEnvironment2 = director.createClassicUbuntuEnvironment();
        System.out.println("�����ڶ���������" + classicCentOSEnvironment2.getEnvironment());
    }
}
