package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/16.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
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
