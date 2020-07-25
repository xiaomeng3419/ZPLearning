package com.example.interview.learning;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Project: ZpBgo
 * @Description??
 * @Author: zhangpan
 * @Creation Date : 2019??09??28?? 19:59
 * @ModificationHistory:https://blog.csdn.net/carson0408/article/details/78634650
 * �����㣺1���Ƿ���ʹ����ڶ�������Ŀ��ƺͱȽ� �����κ��㷨��Ҫ����ʽ����Ҫ�ѹ�ʽ�۳���
 */
public class Dijkstra {

    private Queue visited;
    int[] distance;

    public Dijkstra(int len) {
        // TODO Auto-generated constructor stub
        visited=new LinkedList();
        distance=new int[len];

    }

    private int getIndex(Queue q,int[] dis)
    {
        int k=-1;
        int min_num=Integer.MAX_VALUE;
        for(int i=0;i<dis.length;i++)
        {
            if(!q.contains(i))
            {
                if(dis[i]<min_num)
                {
                    min_num=dis[i];
                    k=i;
                }
            }
        }
        return k;
    }


    public void dijkstra(int[][] weight,Object[] str,int v)
    {
        HashMap path;
        path=new HashMap();
        for(int i=0;i<str.length;i++)
            path.put(i, "");

        //��ʼ��·����������distance
        for(int i=0;i<str.length;i++)
        {
            path.put(i, path.get(i)+""+str[v]);
            if(i==v)
                distance[i]=0;
            else if(weight[v][i]!=-1)
            {
                distance[i]=weight[v][i];
                path.put(i, path.get(i)+"-->"+str[i]);
            }

            else
                distance[i]=Integer.MAX_VALUE;
        }
        visited.add(v);
        while(visited.size()<str.length)
        {
            int k=getIndex(visited,distance);//��ȡδ���ʵ��о���Դ������ĵ�
            visited.add(k);
            if(k!=-1)
            {

                for(int j=0;j<str.length;j++)
                {
                    if(weight[k][j]!=-1)//�ж�k���ܹ�ֱ�ӵ���ĵ�
                    {
                        //ͨ���������㣬�Ƚ��Ƿ��бȵ�ǰ���̵�·�����еĻ��������distance��������path��
                        if(distance[j]>distance[k]+weight[k][j])
                        {
                            distance[j]=distance[k]+weight[k][j];
                            path.put(j, path.get(k)+" -->"+str[j]);
                        }
                    }

                }
            }
        }
        for(int h=0;h<str.length;h++)
        {
            System.out.printf(str[v]+"-->"+str[h]+":"+distance[h]+" ");
            if(distance[h]==Integer.MAX_VALUE)
                System.out.print(str[v]+"-->"+str[h]+"֮��û�п�ͨ��·��");
            else
                System.out.print(str[v]+"-"+str[h]+"֮�������·��������·��Ϊ��"+path.get(h).toString());
            System.out.println();
        }
        visited.clear();

    }

    public static void main(String[] args) {
        int[][] weight= {{0,-1,10,-1,30,100},{-1,0,5,-1,-1,-1},{-1,-1,0,50,-1,-1},{-1,-1,-1,0,-1,10},
                {-1,-1,-1,20,0,60},{-1,-1,-1,-1,-1,0}};
        String[] str= {"V1","V2","V3","V4","V5","V6"};
        int len=str.length;
        Dijkstra dijkstra=new Dijkstra(len);
        ////�����ø��㵱Դ�㣬������dijkstra����
        for(int i=0;i<str.length;i++)
        {
            dijkstra.dijkstra(weight, str, i);
        }
    }
}
