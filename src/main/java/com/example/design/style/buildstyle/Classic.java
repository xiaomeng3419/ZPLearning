package com.example.design.style.buildstyle;

/**
 * Created by zhangpan on 2019/1/20.
 */
public class Classic implements Builder {
    private ServerProduct serverProduct = new ServerProduct();

    @Override
    public Builder installOS(String OS) {
        serverProduct.os = OS;
        return this;
    }

    @Override
    public Builder installServer(String server) {
        serverProduct.server = server;
        return this;
    }

    @Override
    public Builder installLanguage(String language) {
        serverProduct.language = language;
        return this;
    }

    @Override
    public Builder installDatabase(String database) {
        serverProduct.database = database;
        return this;
    }

    @Override
    public ServerProduct getProduct() {
        return serverProduct;
    }
}
