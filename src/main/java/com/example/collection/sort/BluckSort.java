package com.example.collection.sort;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Ͱ�����㷨��ʱ�临�Ӷ�ΪO��n��
 �ο���ַ��https://blog.csdn.net/afei__/article/details/82965834
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
        // �½�һ��Ͱ�ļ���
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < 10; i++) {
            // �½�һ��Ͱ����������ӵ�Ͱ�ļ�����ȥ��
            // ����Ͱ��Ԫ�ػ�Ƶ���Ĳ��룬����ѡ�� LinkedList ��ΪͰ�����ݽṹ
            buckets.add(new LinkedList<Integer>());
        }
        // ����������ȫ������Ͱ�в��������
        for (int data : arr) {
            int index = getBucketIndex(data);
            insertSort(buckets.get(index), data);
        }
        // ��Ͱ��Ԫ��ȫ��ȡ���������� arr �����
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            for (Integer data : bucket) {
                arr[index++] = data;
            }
        }
    }

    /**
     * ����õ�����Ԫ��Ӧ�÷ŵ��ĸ�Ͱ��
     */
    public static int getBucketIndex(float data) {
        // ��������д�ıȽϼ򵥣���ʹ�ø�����������������Ϊ��Ͱ������ֵ
        // ʵ�ʿ�������Ҫ���ݳ����������
        return (int) data;
    }

    /**
     * ����ѡ�����������ΪͰ��Ԫ������ķ��� ÿ����һ����Ԫ�ص���ʱ�����Ƕ����ø÷���������뵽ǡ����λ��
     */
    public static void insertSort(List<Integer> bucket, Integer data) {
        ListIterator<Integer> it = bucket.listIterator();
        boolean insertFlag = true;
        while (it.hasNext()) {
            if (data <= it.next()) {
                it.previous(); // �ѵ�������λ��ƫ�ƻ���һ��λ��
                it.add(data); // �����ݲ��뵽�������ĵ�ǰλ��
                insertFlag = false;
                break;
            }
        }
        if (insertFlag) {
            bucket.add(data); // ��������ݲ��뵽����ĩ��
        }
    }

}
