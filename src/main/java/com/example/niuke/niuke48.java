package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/22.
 */
public class niuke48 {
    public int Add(int a,int b) {
//        return num2==0 ? Add((num1&num2)<<1,num1^num2): num2;
        int ans;
        while(b!=0)
        {   //直到没有进位
            ans = a^b;        //不带进位加法
            b = ((a&b)<<1);   //进位
            a = ans;
        }
        return a;
//        return num2 == 0 ? Add(num1^num2,(num1&num2)<<1) : num2;
    }

    public static void main(String[] args) {
        System.out.println(new niuke48().Add(1,3));
    }
}
