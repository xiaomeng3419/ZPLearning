package com.example.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangpan on 2019/1/15.
 * �ڼ����õ���������Ԫ�ص�ͬʱ���ñ����������remove����ɾ��Ԫ�ز������juc�쳣��
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
