package com.example.utils;

import com.alibaba.fastjson.JSON;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: git
 * @Creation Date : 2020年07月25日 23:03
 * @ModificationHistory:
 */
public class ValidateTest {

    public static void main(String[] args) {
        ValidateTestVO vo = new ValidateTestVO();

        String validres = ValidateBeanUtil.validate(vo, "id", "name", "code");
        System.out.println(validres);
    }
}
