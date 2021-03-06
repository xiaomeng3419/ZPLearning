package com.example.niuke;
import java.util.ArrayList;

/**
 * Created by zhangpan on 2019/3/21.
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
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
