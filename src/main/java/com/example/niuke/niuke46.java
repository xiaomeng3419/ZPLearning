package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/22.
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 * ����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 * ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,
 * ����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����, * ���Բ��ñ���,
 * �����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 */
public class niuke46 {
    public int LastRemaining_Solution(int n, int m) {
       int step = 1;
       int count = 0 ;
       int index = 0;
       int[] flag = new int[n];
       int[] people = new int[n];
       int[] var = new int[n];
       while (count!=n-1){
           if(step == m){
               step = 0;
               people[index] = 1;
               flag[index] = 1;
               var[count++] =index;
               System.out.println(index);
           }
           index=(++index)%n;
           if(people[index]== 0){
               step++;
           }
       }
       return index;
    }
    public int LastRemaining_Solution1(int n, int m) {

        if(n<=0 ||m<=0)
            return -1;
        int last = 0;  //N=1ʱʣ��С���������һ����0
        //���ƻ�ȥ
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
            System.out.println(last);
        }


        return last;
    }
    public static void main(String[] args) {
        System.out.println(new niuke46().LastRemaining_Solution1(5,2));
    }
}
