package com.example.niuke;
import java.util.Random;
/**
 * Created by zhangpan on 2019/3/22.
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,
 * ��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
 * ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ� ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0
 */
public class niuke45 {
   private  static int[]  ks = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13};
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0){
            return false;
        }
        int flag = 0;
        int j=0;
        int[] temp = new int[numbers.length];
        for (int i = 0;i<numbers.length;i++){
            if(numbers[i] == 0 ){
                flag++;
            }else {
             temp[j] = numbers[i];
             j++;
            }
        }
        if(flag==4){
            return true;
        }

        for (int i = 0;i<numbers.length-flag;i++){
            for (int x = i+1;x<numbers.length-flag;x++){
                if(temp[i]>temp[x]){
                    int va = temp[i];
                    temp[i] = temp[x];
                    temp[x] = va;
                }
            }
        }
        int key  = temp[0];
        int kex = key;
        for (int i = 1 ; i< numbers.length-flag;i++){
            if(temp[i] -key == 0){
                return false;
            }
            if(temp[i]-key==1){
                key = temp[i];
                continue;
            }else {
                int t  = temp[i] - key-1;
                if(t>flag){
                    return false;
                }else {
                    flag = flag-t;
                    key = temp[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ower = new int[5];
        for (int i = 0 ;i<5 ;i++){
            ower[i] = ks[new Random().nextInt(14)];
//            System.out.println(ower[i]);
        }
//        System.out.println(new niuke45().isContinuous(ower));
        System.out.println(new niuke45().isContinuous(new int[]{1,3,0,5,0}));
    }
}
