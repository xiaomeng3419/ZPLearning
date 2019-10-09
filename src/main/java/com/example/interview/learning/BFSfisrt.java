package com.example.interview.learning;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月28日 19:53
 * @ModificationHistory:https://blog.csdn.net/carson0408/article/details/78634650
 */
public class BFSfisrt {

    private Queue q;
    private Queue<Integer> visited;
    public BFSfisrt() {
        q=new LinkedList();
        visited=new LinkedList<>();
    }

    public static void main(String[] args) {
        int[][] matrix= {{0,1,1,0,0,0,0,0},{1,0,0,1,1,0,0,0},
                {1,0,0,0,0,1,1,0},{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},
                {0,0,1,0,0,0,1,0},{0,0,1,0,0,1,0,0},{0,0,1,1,0,0,0,0}};
        char[] str= {'A','B','C','D','E','F','G','H'};
        BFSfisrt bfs=new BFSfisrt();
        bfs.bfs(matrix, 'A', str);

    }

    private void bfs(int[][] matrix, char v, char[] str) {
        int i=getIndex(v,str);
        if(i==-1) return;
        q.add(i);
        visited.add(i);
        System.out.print(str[i]+" ");
        while (!q.isEmpty()){
            int u=(int)q.remove();
            for(int j=0;j<str.length;j++)            {
                if(matrix[u][j]==1 && (!visited.contains(j)))
                {

                    q.add(j);
                    visited.add(j);
                    System.out.print(str[j]+" ");
                }
            }

        }
                


    }

    private int getIndex(char v,char[] str)
    {
        for(int i=0;i<str.length;i++)
        {
            if(v==str[i])
                return i;
        }
        return -1;
    }

}
