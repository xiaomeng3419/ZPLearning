package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/22.
 */
public class niuke48 {
    public int Add(int a,int b) {
//        return num2==0 ? Add((num1&num2)<<1,num1^num2): num2;
        int ans;
        while(b!=0)
        {   //ֱ��û�н�λ
            ans = a^b;        //������λ�ӷ�
            b = ((a&b)<<1);   //��λ
            a = ans;
        }
        return a;
//        return num2 == 0 ? Add(num1^num2,(num1&num2)<<1) : num2;
    }

    public static void main(String[] args) {
        System.out.println(new niuke48().Add(1,3));
    }
}
