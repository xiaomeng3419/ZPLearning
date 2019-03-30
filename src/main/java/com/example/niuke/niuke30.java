package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/21.
 */
public class niuke30 {
    int value = 0;

    public static void main(String[] args) {
        System.out.println(new niuke30().FindGreatestSumOfSubArray(new int[]{-2,-8,-1,-5,-9}));
    }
    public int FindGreatestSumOfSubArray(int[] array) {
            if(array.length==0){
                return 0;
            }
            int max = array[0];
            int tempsum = array[0];
            int start = 0;
            for (int i=1;i<array.length;i++){
                if(tempsum+array[i]>max){
                    start = i;
                    max = tempsum+array[i]>array[i]?tempsum+array[i]:array[i];
                    tempsum = max;
                }else {
                    if(max<array[i]){
                        max = array[i];
                    }else {
                        tempsum = tempsum+array[i];
                    }

                }

            }
            return max;
    }
}
