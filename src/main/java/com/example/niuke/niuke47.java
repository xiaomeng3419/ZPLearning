package com.example.niuke;

/**
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 * Created by zhangpan on 2019/3/22.
 */
public class niuke47 {
    public static void main(String[] args) {

    }


    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum>>1;
         /**�߼����·�����ԣ�����
         int ans = n;
         ans && (ans += Sum_Solution(n - 1));
         return ans;
         */
    }

}
