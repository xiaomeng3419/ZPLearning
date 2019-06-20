package com.example.maoyanwork.utils;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Location:com.example.maoyanwork.utils
 * Created by zhangpan
 * Date: 2019-05-22
 * Time: 10:28
 * Description:
 */
public class BoxUnitConvertUtils {

    @Test
    public void testConvert(){
        System.out.println(boxUnitConvert("1.22"));
        System.out.println(boxUnitConvert("0.22"));
        System.out.println(boxUnitConvert("1.00"));
        System.out.println(boxUnitConvert("0.00"));
        System.out.println(boxUnitConvert("0.1"));
    }

    /**
     * 万元精确到分
     * @param var
     * @return
     */
    public BigDecimal boxUnitConvert(String var){
        BigDecimal wUnit = new BigDecimal(var);
        return wUnit.multiply(new BigDecimal(1000000)).setScale(0);
    }
}
