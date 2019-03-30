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
        String s = "";                //可以改为StringBuffer,减少额外空间
        //StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;                                    //求数组长度
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);                            //将数组中数放入集合list中
        }
		/*Comparator接口，两个对象要使用compareTo方法比较大小，就必须实现Comparator接口的compare方法，
		比如String就实现了这个方法，所以可以直接使用compareTo进行比较。sort(List,Comparator):
		根据指定的Comparable产生顺序对List集合元素进行排序*/
		/*在基本数据中，compareTo()是比较两个Character 对象；
		在 Boolean中，是用boolean的实例于其它实例进行比较；
		在String 中，则是按照字典顺序进行比较，返回的值是一个int 型。*/
        Collections.sort(list, new Comparator<Integer>() {            //根据Comparable指定顺序对list集合排序
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;                //str1和str2都是整数，用 str1 +"" + str2即将整数转化为了字符串，强！
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);                    //在String中，compareTo是按照字典顺序进行比较，返回的值是一个int型，返回0，-1,1三个数字。
            }
        });
        for (int j : list) {                                //foreach语句
            s += j;
        }
        return s;
    }




}
