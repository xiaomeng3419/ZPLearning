package com.example.Functional.utils.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by zhangpan on 2018/11/23.
 */
@Data
public class Request001 {
    public Request001(String username, Integer age, List<String> skills) {
        this.username = username;
        this.age = age;
        this.skills = skills;
    }

    private String username;
    private Integer age;
    private List<String> skills;
}
