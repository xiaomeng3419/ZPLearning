package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/16.
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 */
public class niuke10 {
    public static void main(String[] args) {
        new Solutionniuke10().RectCover(10);
    }
}

class Solutionniuke10 {
    public int RectCover(int target) {
        int var1 = 1;
        int var2 = 2;
        if(target == 0)
            return 0;
        if(target==1)
            return var1;
        if(target == 2)
            return var2;
        for (int i = 3;i<=target;i++){
            int temp = var2;
            var2 = var1+var2;
            var1 = temp;
        }
        return var2;
    }
}
