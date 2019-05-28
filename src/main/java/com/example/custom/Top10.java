package com.example.custom;

import java.util.*;

/**
 * Created by zhangpan on 2019/4/1.
 */
public class Top10 {

    public static void main(String[] args) {
        fin_10_max();
    }

    private static void fin_10_max() {
        //把100000个数放进ArrayList类型的容器
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        //随机插入十万个数据
        for(int i = 0;i < 100000;i++) {
            int val = random.nextInt(10000)+1;
            arrayList.add(val);
        }

        //重写比较器，目的是为了比较的hashmap中的value
        Comparator<Map.Entry<Integer,Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        };

        //创建一个优先级队列的对象。自定义构造函数，则比较器需要重写，大小设为10
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(20,comparator);

        //创建一个hashmap对象，（需要记录数以及他的出现次数）
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        //迭代器迭代arraylist，记录每个值出现的次数
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if(hashMap.containsKey(next)) {
                //记录数据
                hashMap.put(next,hashMap.get(next)+1);
            }else {
                //这个值第一次出现
                hashMap.put(next,1);
            }
        }

        //迭代器迭代hashmap
        Iterator<Map.Entry<Integer,Integer>> iterator1 = hashMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer,Integer> next = iterator1.next();
            int value = next.getValue();  //得到每一次遍历时的value值
            //如果优先级队列里的数据长度小于10，就往进添加
            if(priorityQueue.size() < 20) {
                priorityQueue.add(next);
            }else {
                //如果数据超过10，比较队顶的元素和要进入的元素
                if(priorityQueue.peek().getValue() < value) {
                    //如果要进入的元素大于队顶的元素，就移除队顶本来的元素，加入新的元素
                    priorityQueue.remove();
                    priorityQueue.add(next);
                }
            }
        }

        //迭代器遍历优先级队列，得出结果
        Iterator<Map.Entry<Integer,Integer>> iterator2 = priorityQueue.iterator();
        System.out.println("数字 出现次数");
        while(iterator2.hasNext()) {
            Map.Entry<Integer,Integer> next = iterator2.next();
            int key = next.getKey();
            int value = next.getValue();
            System.out.println(key+"   "+value);
        }
    }//最长不重复子串
    //搜索二维矩阵
    //二叉树的层次遍历
}