package com.example.niuke;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Created by zhangpan on 2019/3/4.
 */
public class niuke33 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));
    }
    public static int GetUglyNumber_Solution(int index) {
       /* if(index==0){
            return 0;
        }
        if(index==1){
            return 1;
        }
        int num=2;
        for (int i = 2;i<=index;num++){
            if( isF(num)){
                i++;
            }
            if (i== index+1){

                break;
            }
        }
        return num;
        */
        if(index==0)
            return 0;
        int[] a = new int[index];
        int count = 1;
        a[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(count<index){
            int min = min(a[index2]*2,a[index3]*3,a[index5]*5);
            a[count] = min;
            while(a[index2]*2<=a[count]) index2++;
            while(a[index3]*3<=a[count]) index3++;
            while(a[index5]*5<=a[count]) index5++;
            count++;
        }
        int result = a[index-1];
        return result;
    }
    public static int min(int a,int b,int c){
        int temp = a>b?b:a;
        return temp>c?c:temp;
    }
    public  static  boolean isF(int key){
        int i =2;
        boolean flag = true;
        while (i<=key/2){
            if(key%i == 0){
                if(i!=2&&i!=3&&i!=5){
                    flag=false;
                    break;
                }
            }
            i++;

        }
        if(flag){
            if(key%2==0||key%3==0||key%5==0){
                flag=true;
            }else {
                flag=false;
            }
        }
        return flag;
    }


    public static int GetUglyNumber_Solution1(int index) {
        int count = 0;
        int i;
        for(i=1;count<=index;i++){
            if(isUgly(i))
                count++;
        }
        return i;
    }

    public static boolean isUgly(int n){
        while(n%3==0)
            n = n/3;
        while(n%2==0)
            n = n/2;
        while(n%5==0)
            n = n/5;
        if(n==1)
            return true;
        else
            return false;
    }

}
