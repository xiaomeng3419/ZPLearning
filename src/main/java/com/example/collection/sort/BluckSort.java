package com.example.collection.sort;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 桶排序算法，时间复杂度为O（n）
 参考地址：https://blog.csdn.net/afei__/article/details/82965834
 * Created by zhangpan on 2019/3/29.
 */
public class BluckSort {

    public static void main(String[] args) {
        int a[] = {2,1,3,6,5,3,5,4};
        bucketSort(a);
        printArray(a);
    }



    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void bucketSort(int[] arr) {
        // 新建一个桶的集合
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < 10; i++) {
            // 新建一个桶，并将其添加到桶的集合中去。
            // 由于桶内元素会频繁的插入，所以选择 LinkedList 作为桶的数据结构
            buckets.add(new LinkedList<Integer>());
        }
        // 将输入数据全部放入桶中并完成排序
        for (int data : arr) {
            int index = getBucketIndex(data);
            insertSort(buckets.get(index), data);
        }
        // 将桶中元素全部取出来并放入 arr 中输出
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            for (Integer data : bucket) {
                arr[index++] = data;
            }
        }
    }

    /**
     * 计算得到输入元素应该放到哪个桶内
     */
    public static int getBucketIndex(float data) {
        // 这里例子写的比较简单，仅使用浮点数的整数部分作为其桶的索引值
        // 实际开发中需要根据场景具体设计
        return (int) data;
    }

    /**
     * 我们选择插入排序作为桶内元素排序的方法 每当有一个新元素到来时，我们都调用该方法将其插入到恰当的位置
     */
    public static void insertSort(List<Integer> bucket, Integer data) {
        ListIterator<Integer> it = bucket.listIterator();
        boolean insertFlag = true;
        while (it.hasNext()) {
            if (data <= it.next()) {
                it.previous(); // 把迭代器的位置偏移回上一个位置
                it.add(data); // 把数据插入到迭代器的当前位置
                insertFlag = false;
                break;
            }
        }
        if (insertFlag) {
            bucket.add(data); // 否则把数据插入到链表末端
        }
    }

}
