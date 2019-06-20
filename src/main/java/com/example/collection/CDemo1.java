package com.example.collection;

import com.example.collection.reflect.String;

import java.util.*;

/**
 * Created by zhangpan on 2019/1/15.
 * 在集合用迭代器遍历元素的同时。用本身迭代器的remove方法删除元素不会出现juc异常。
 */
public class CDemo1 {
    public static void main(String[] args) {
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        ArrayList<Integer> list = new ArrayList<>();
        Integer s = 12;
        assert s >= 127;
//        Map<String,Object> map = new HashMap<String,Object>();

      ArrayList<Integer> list = new ArrayList<>();
      list.add(12);
      list.add(123);
      list.add(12323);
      Iterator<Integer> iterator =  list.iterator();

      while (iterator.hasNext()){
          System.out.println(iterator.next());
          list.remove(0);
//          iterator.remove();
      }
    }
}
