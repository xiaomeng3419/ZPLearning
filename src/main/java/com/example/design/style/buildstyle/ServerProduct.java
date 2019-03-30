package com.example.design.style.buildstyle;

import lombok.Data;

/**
 * Created by zhangpan on 2019/1/20.
 */
@Data
public class ServerProduct {
    String os;
    String language;
    String server;
    String database;

    public String getEnvironment() {
        return "ServerProduct{" +
                "os='" + os + '\'' +
                ", language='" + language + '\'' +
                ", server='" + server + '\'' +
                ", database='" + database + '\'' +
                '}';
    }
}
