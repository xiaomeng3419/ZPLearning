package com.example.niuke;
import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/3/21.
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 *
 */
public class niuke41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            if(sum<2){
                return lists;
            }
        System.out.println(sum);
        int temp = 0;
        for (int x = 1;x<=sum/2+1;x++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int y = x;y<=sum/2+1;y++){
                list.add(y);
                temp += y;
                if(temp == sum){
                    lists.add(list);
//                    System.out.println(list);
                    temp = 0;
                    break;
                }else if(temp>sum){
//                    System.out.println(temp);
                    temp=0;
                    break;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new niuke41().FindContinuousSequence(100));
    }

}
