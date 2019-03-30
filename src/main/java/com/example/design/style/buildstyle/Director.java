package com.example.design.style.buildstyle;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class Director {

    private Builder builder = new Classic();
    public ServerProduct createClassicUbuntuEnvironment(){
        builder.installOS("Ubuntu").installLanguage("Java").installServer("Tomcat").installDatabase("Mysql");
        return builder.getProduct();
    }

    public ServerProduct createClassicCentOSEnvironment(){
        builder.installOS("CentOS").installLanguage("Java").installServer("Tomcat").installDatabase("Mysql");
        return builder.getProduct();
    }
}
