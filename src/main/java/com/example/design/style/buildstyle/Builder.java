package com.example.design.style.buildstyle;

/**
 * Created by zhangpan on 2019/1/20.
 */
public interface Builder {
    Builder installOS(String OS);
    Builder installLanguage(String language);
    Builder installServer(String server);
    Builder installDatabase(String database);
    ServerProduct getProduct();
}
