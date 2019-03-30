package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/18.
 * 输入两个整数序列，
 * 第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 解决方法是当前降序后升序开始不能出现比最后降序数小的升序
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
        int drect = 1;//1升序，2降序
        int pos = re[0];
        for (int i = 1;i<re.length;i++){
            if(re[i]>re[i-1]){
                //升序里面如果升的那个比降序开始的还小，就说明不是出站顺序，但是第一次升序不算
                drect = 1;
                if(pos>re[i]){
                    return false;
                }
                pos=re[i];
            }else {
                //一旦出现降序
                drect=2;
                flag = flag==0?1:-1;
            }

        }
        return true;
    }
}
