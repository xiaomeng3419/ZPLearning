package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/18.
 * ���������������������κνڵ㶼�ȸ��ڵ�����������κνڵ㶼�ȸ��ڵ�С��
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 */
public class niuke23 {
    public static void main(String[] args) {
        System.out.println(new niuke23().VerifySquenceOfBST(new int[]{1,7,2,4,5}));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        int var = sequence[sequence.length-1];
        int flag = -1;
        for (int i = sequence.length-2;i>=0;i--){
            if(sequence[i]<var&&flag==-1){
                flag=0;
            }else if(sequence[i]>var&&flag==0){
                return false;
            } else {
                continue;
            }
        }
        return true;
    }
}
