package com.example.interview.learning.repeat;

import com.alibaba.fastjson.JSON;
import com.eclipsesource.json.Json;
import com.google.common.collect.Maps;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月17日 20:47
 * @ModificationHistory:
 */
public class ZPMapSearch {
    private Queue<Integer> queue;
    private int[] distance;


    public ZPMapSearch(int len) {
        queue = new LinkedList();
        distance = new int[len];
    }

    private void mapSearch(int[][] weight, String[] str, int v) {
        Map<Integer,String> path = Maps.newHashMap();
        for (int i = 0; i < str.length; i++) {
            if(v==i){
                continue;
            }else {
                path.put(i,str[v]);
            }
        }

        for (int j = 0; j < str.length; j++) {
            if(j==v){
                distance[j]=0;
            }else if(weight[v][j] == -1){
               distance[j] = Integer.MAX_VALUE;
            }else {
                distance[j] = weight[v][j];
                path.put(j, path.get(j)+"-->"+str[j]);
            }
        }//初始化距离

        queue.add(v);
        while (queue.size()<str.length){
            int k  = getIndex(queue,distance);
            queue.add(k);
            if (k!=-1){

                for (int i = 0; i < distance.length; i++) {
                    if(weight[k][i]!=-1){
                        if(distance[i]>distance[k]+weight[k][i]){
                            distance[i] = distance[k]+weight[k][i];
                            path.put(i,path.get(k)+"---->"+str[i]);
                        }
                    }

                }
            }

        }

        System.out.println(JSON.toJSONString(path));


    }

    private int getIndex(Queue<Integer> queue, int[] distance) {
        int k  = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if(!queue.contains(i)){
                if(distance[i]!=Integer.MAX_VALUE){
                    if (distance[i]<minDis){
                        minDis = distance[i];
                        k = i;
                    }
                }
            }
        }
        return k;       
    }


    public static void main(String[] args) {

        int[][] weight= {{0,-1,10,-1,30,100},{-1,0,5,-1,-1,-1},{-1,-1,0,50,-1,-1},{-1,-1,-1,0,-1,10},
                {-1,-1,-1,20,0,60},{-1,-1,-1,-1,-1,0}};
        String[] str= {"V1","V2","V3","V4","V5","V6"};
        int len=str.length;
        ZPMapSearch dijkstra=new ZPMapSearch(len);
        ////依次让各点当源点，并调用dijkstra函数
//        for(int i=0;i<str.length;i++)
//        {
//            dijkstra.mapSearch(weight, str, i);
//        }
        dijkstra.mapSearch(weight, str, 0);
    }

}
