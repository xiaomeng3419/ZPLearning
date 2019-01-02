package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zhangpan on 2018/11/21.
 */
public class ListToMap {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<Map<String,Object>>  wxRequests  = new ArrayList<Map<String,Object>>();
    List<Map<String, Object>>  init(){
        for (int i = 0;i<11;i++ ){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("key1",1+"value");
            map.put("key2",2+"value");
            this.wxRequests.add(map);
        }
        return this.wxRequests;
    }

    public List<Map<String, Object>> getWxRequests() {
        return wxRequests;
    }

    public void setWxRequests(List<Map<String, Object>> wxRequests) {
        this.wxRequests = wxRequests;
    }

    public static void main(String[] args)throws Exception {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        list = new ListToMap().init();
        System.out.println("list to map result:"+ String.valueOf(listToMap(list)));

//        list.stream().forEach(map -> map.forEach((k,v) -> System.out.println("key:value = " + k + ":" + v)));
    }

private static Map<String,Object> listToMap(List<Map<String,Object>> list) throws Exception{
    Map<String,Object> kv = new HashMap<String,Object>();
//    list.stream().forEach(map -> map.forEach((k,v) -> kv.put(k,v)));
//    for (Map<String,Object> var : list){
//        String key1 = String.valueOf(var.get("key1"));
//        String key2 = String.valueOf(var.get("key2"));
//        kv.put(key1,key2);
//    }
//
//    Arrays.parallelSort();
    list.forEach(e -> kv.put(String.valueOf(e.get("key1")),String.valueOf(e.get("key2"))));
    return kv;
//    return result1;
}


}
