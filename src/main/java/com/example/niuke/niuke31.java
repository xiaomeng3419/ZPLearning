package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/21.
 *
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,
 * ���Ƕ��ں�����������û���ˡ�
 * ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
 *�����ʽ�ǣ���ÿһλ�ϳ��ֵĴ������
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
