package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/21.
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *解决方式是，在每一位上出现的次数相加
 */
public class niuke31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0){
            return 0;
        }
        int count1=0;
        int round = n;
        int base = 1;
        while (round>0){
            int weight = round%10;
            round /=10;
            count1+=round*base;
            if(weight==1){
                count1+=(n%base)+1;
            }else if (weight>1){
                count1+=base;
            }
            base *=10;
        }
return count1;

    }

    public static void main(String[] args) {
        niuke31 niuke31 = new niuke31();
        System.out.println(niuke31.NumberOf1Between1AndN_Solution(16));
    }
}
