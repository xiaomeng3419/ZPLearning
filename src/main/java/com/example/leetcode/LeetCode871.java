package com.example.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zhangpan on 2019/4/3.
 */
public class LeetCode871 {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer>  queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int retdata = 0 ;
        int currentPosition=0;
        int currentfuel = startFuel;

        while (true){
            while (currentPosition<stations.length&&stations[currentPosition][0]<=currentfuel){
                queue.add(stations[currentPosition][1]);
                currentPosition++;
            }
            if(currentfuel>=target){
                return retdata;
            }
            if(queue.isEmpty()){
                return -1;
            }
            currentfuel+=queue.poll();
            retdata++;
        }


    }

    public static void main(String[] args) {
        System.out.println(minRefuelStops(100,10,new int[][]{{10,60},{20,30},{30,30},{60,40}}));
    }
}
