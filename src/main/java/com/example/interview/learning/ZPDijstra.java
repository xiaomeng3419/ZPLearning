package com.example.interview.learning;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月28日 22:38
 * @ModificationHistory:
 */
public class ZPDijstra {
    private Queue visited;
    int[] distance;

    public ZPDijstra(int len){
        visited = new LinkedList();
        distance = new int[len];
    }

    //获取当前不能访问到距离最近的点
    private int getIndex(Queue q ,int[] dis){
        int k = -1;
        int min_num = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            if(!q.contains(i)){
                if (dis[i]<min_num){
                    min_num = dis[i];
                    k = i;
                }
            }
        }
        return k;
    }

    public void zpDijstra(int[][] weight,Object[] str,int v){
        HashMap path = new HashMap();
        for (int i = 0; i < str.length; i++) {
            path.put(i,"");
        }

        for (int i = 0; i < str.length; i++) {
            path.put(i,path.get(i)+""+str[v]);
            if (i == v){
                distance[i] = 0;
            }else if(weight[v][i]!=-1){
                distance[i] = weight[v][i];
                path.put(i,path.get(i)+"--->"+str[i]);
            }else {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        visited.add(v);
        while (visited.size()<str.length){
            //获取当前未访问到距离最近的点
            int k  = getIndex(visited,distance);
            visited.add(k);
            if(k!=-1){
                for (int i = 0; i < str.length; i++) {
                    if(weight[v][i] != -1){
                        if (distance[i]>distance[k]+weight[k][i]){
                            distance[i] = distance[k]+weight[k][i];
                            path.put(i,path.get(k)+"--->" +str[i]);
                        }
                    }
                }
            }


        }

        for (int i = 0; i < str.length; i++) {
            System.out.printf(str[v]+"--->"+str[i]+":"+distance[i]+" ");
            if(distance[i]!= Integer.MAX_VALUE){
                System.out.println(str[v]+"--->"+str[i]+":"+path.get(i).toString());
            }else {
                System.out.println(str[v]+"--->"+str[i]+": 不能够到达");
            }
        }
        visited.clear();

    }
    public static void main(String[] args) {
        int[][] weight= {{0,-1,10,-1,30,100},{-1,0,5,-1,-1,-1},{-1,-1,0,50,-1,-1},{-1,-1,-1,0,-1,10},
                {-1,-1,-1,20,0,60},{-1,-1,-1,-1,-1,0}};
        String[] str= {"V1","V2","V3","V4","V5","V6"};
        int len=str.length;
        Dijkstra dijkstra=new Dijkstra(len);
        //依次让各点当源点，并调用dijkstra函数
        for(int i=0;i<str.length;i++)
        {
            dijkstra.dijkstra(weight, str, i);
        }
    }


}
