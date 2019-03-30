package com.example.design.style.iteratorStyle;

import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/2/25.
 */
public class IteratorTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList s  = new ArrayList();
        List list=new ConcreteAggregate();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}