package com.example.custom;

import com.mchange.v2.beans.BeansUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by zhangpan on 2018/12/19.
 * 查看integer类型的数据是否在-128·127范围内的数据进行包装类型的对象复用
 */
public class custom1 {

    {
        System.out.println("class init!!!!");
    }
    public static void sd(){
        System.out.println("sdfsdf");
    }


    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(custom1.class);
        Map<String,Object> in = new HashMap<String,Object>(1000);
        Integer integer1 = new Integer(1333);
        int integer3 = 1333;
        Integer integer2 = new Integer(1333);
        System.out.println(integer1.equals(integer2));
        System.out.println(integer1.equals(integer3));
        System.out.println();
//        logger.info("result:{}",integer1.equals(integer2));
//        Object
        short sh  = 1;sh+=1;
        PriorityQueue<custom1> s = new PriorityQueue<>();
        new Domain("string");
    }

}
