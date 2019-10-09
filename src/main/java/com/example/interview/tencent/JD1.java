package com.example.interview.tencent;

import java.util.*;

/**
 * Created by zhangpan on 2019/4/13.
 */
public class JD1 {
     public static int getMaxDeep(Map<Integer,Integer> map){
         if(map ==null||map.isEmpty()){
             return 0;
         }
         List<Integer> list = new ArrayList<>();
         for (Map.Entry<Integer,Integer> entry:map.entrySet()){
             if(entry.getValue() == 1){
                 list.add(entry.getKey());
             }
         }
         int deep = 0;
         for (int i = 0 ;i<list.size();i++){
             int key = list.get(i);
             int temp = deep(map,key);
             deep = deep>temp?deep : temp;
         }
        return deep;
     }
public static int deep(Map<Integer,Integer> map ,int key){
         int deep = 0;
         int temp = 0;
         if(map.containsKey(key)){
             for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                 if (entry.getValue() == key){
                     int c = deep(map, entry.getKey());
                     deep = deep >c ?deep:c;
                    temp++;
                 }
             }
             return deep+temp;
         }else {
             return 0;
         }

}


    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for (int i = 0 ;i < n-1;i++){
            int key = sc.nextInt();
            int value = sc.nextInt();
            map.put(key,value);
        }
       int s = getMaxDeep(map);
        System.out.println(s);
    }
}
