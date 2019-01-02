package com.example.Thread.style;

import com.sun.xml.internal.ws.model.WrapperBeanGenerator;

import java.beans.BeanDescriptor;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangpan on 2018/12/10.
 */
public class Demo7 {
    public static int add(List<Integer> lsit ){
        return lsit.parallelStream().mapToInt(a -> a).sum();
    }
    
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10,20,30);
        System.out.println(add(values));
    }
}
