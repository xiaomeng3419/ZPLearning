package com.example.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by zhangpan on 2019/2/25.
 */
public class niuke32 {
    public static void main(String[] args) {
        String var1= "33";
        String var2 = "321";
        System.out.println(var1.compareTo(var2));
        System.out.println(new niuke32().PrintMinNumber(new int[]{3,32,312}));
    }
    public String PrintMinNumber(int [] numbers) {
        int n;
        String s = "";                //���Ը�ΪStringBuffer,���ٶ���ռ�
        //StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;                                    //�����鳤��
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);                            //�������������뼯��list��
        }
		/*Comparator�ӿڣ���������Ҫʹ��compareTo�����Ƚϴ�С���ͱ���ʵ��Comparator�ӿڵ�compare������
		����String��ʵ����������������Կ���ֱ��ʹ��compareTo���бȽϡ�sort(List,Comparator):
		����ָ����Comparable����˳���List����Ԫ�ؽ�������*/
		/*�ڻ��������У�compareTo()�ǱȽ�����Character ����
		�� Boolean�У�����boolean��ʵ��������ʵ�����бȽϣ�
		��String �У����ǰ����ֵ�˳����бȽϣ����ص�ֵ��һ��int �͡�*/
        Collections.sort(list, new Comparator<Integer>() {            //����Comparableָ��˳���list��������
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;                //str1��str2������������ str1 +"" + str2��������ת��Ϊ���ַ�����ǿ��
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);                    //��String�У�compareTo�ǰ����ֵ�˳����бȽϣ����ص�ֵ��һ��int�ͣ�����0��-1,1�������֡�
            }
        });
        for (int j : list) {                                //foreach���
            s += j;
        }
        return s;
    }




}
