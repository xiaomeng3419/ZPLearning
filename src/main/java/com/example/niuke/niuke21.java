package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/18.
 * ���������������У�
 * ��һ�����б�ʾջ��ѹ��˳��
 * ���жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * ��������ǵ�ǰ���������ʼ���ܳ��ֱ��������С������
 */
public class niuke21 {
    public static void main(String[] args) {
        System.out.println(new niuke21().IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
        System.out.println(new niuke21().IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(new niuke21().IsPopOrder(new int[]{1},new int[]{2}));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(popA.length!=pushA.length){
            return false;
        }
//        if(popA.length<3){
//            return true;
//        }
        int[] pre = new int[pushA.length];
        int[] re = new int[pushA.length];
        for (int i = 0;i<pushA.length;i++){
             pre[i]=i+1;
        }
        for (int i = 0;i<popA.length;i++){
            boolean var = false;
            for (int j = 0 ;j<pushA.length;j++){
                if (popA[i]==pushA[j]){
                    re[i]=j+1;
                    var = true;
                }
            }
            if(!var){
                return false;
            }
        }
        int flag = 0;
        int drect = 1;//1����2����
        int pos = re[0];
        for (int i = 1;i<re.length;i++){
            if(re[i]>re[i-1]){
                //����������������Ǹ��Ƚ���ʼ�Ļ�С����˵�����ǳ�վ˳�򣬵��ǵ�һ��������
                drect = 1;
                if(pos>re[i]){
                    return false;
                }
                pos=re[i];
            }else {
                //һ�����ֽ���
                drect=2;
                flag = flag==0?1:-1;
            }

        }
        return true;
    }
}
