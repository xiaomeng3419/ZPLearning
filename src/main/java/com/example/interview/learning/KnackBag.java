package com.example.interview.learning;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月29日 16:33
 * @ModificationHistory:https://www.bilibili.com/video/av36136952?from=search&seid=7772750809944001062
 */
public class KnackBag {
    private static int N = 6;
    private static int V = 21;

    private static int[] w = {0,2,3,4,5,9};//重量
    private static int[] v = {0,3,4,5,8,10};//价值

    private static int[][] kanck = new int[6][21];//数组


    private static int calcKanck(){
        int capacity = 0;
        for (int K = 1; K < N; K++) {
            for (capacity= 1; capacity < V; capacity++) {
                if(w[K]>capacity){
                    kanck[K][capacity] = kanck[K-1][capacity];
                }else {
                    int value1 =  kanck[K-1][capacity - w[K]] + v[K];
                    int value2 = kanck[K-1][capacity];
                    kanck[K][capacity] = kanck[K-1][capacity - w[K]]+v[K] > kanck[K-1][capacity]?kanck[K-1][capacity - w[K]]+v[K]:kanck[K-1][capacity];
                }
            }
        }

        return kanck[5][20];

    }

    public static void main(String[] args) {
        System.out.println(calcKanck());
    }

}
