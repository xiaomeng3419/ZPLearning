package com.example.niuke;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * Created by zhangpan on 2019/3/22.
 */
public class niuke47 {
    public static void main(String[] args) {

    }


    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum>>1;
         /**逻辑与短路的特性，优秀
         int ans = n;
         ans && (ans += Sum_Solution(n - 1));
         return ans;
         */
    }

}
