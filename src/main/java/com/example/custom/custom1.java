package com.example.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by zhangpan on 2018/12/19.
 * �鿴integer���͵������Ƿ���-128��127��Χ�ڵ����ݽ��а�װ���͵Ķ�����
 */
public class custom1 {
   static Logger logger = LoggerFactory.getLogger(custom1.class);
    public static void main(String[] args) {
        Map<String,Object> in = new HashMap<String,Object>(1000);
        Integer integer1 = new Integer(1333);
        int integer3 = 1333;
        Integer integer2 = new Integer(1333);
        System.out.println(integer1.equals(integer2));
        System.out.println(integer1.equals(integer3));
        System.out.println();
        logger.info("result:{}",integer1.equals(integer2));
    }

}
