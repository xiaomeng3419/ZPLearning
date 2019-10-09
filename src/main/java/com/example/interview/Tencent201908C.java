    package com.example.interview;

    import com.alibaba.fastjson.JSON;

    import java.util.Arrays;
    import java.util.Scanner;

    /**
     * @Project: ZpBgo
     * @Description：
     * @Author: zhangpan
     * @Creation Date : 2019年08月17日 21:02
     * @ModificationHistory:
     */
    public class Tencent201908C {

        public static void quickSort(int[][] arr,int low,int high){
            if(arr.length==0){
                return;
            }
            int[] temp = arr[low];
            int end = high;
            int start = low;

            while (end>start){
                //从后往前
                while (end>start&&arr[end][0]>=temp[0]){
                    end--;
                }
                if(arr[end][0]<temp[0]){
                    int[] t = arr[end];
                    arr[end] = arr[start];
                    arr[start] = t;

                }
                //从前往后
                while (end>start&&arr[start][0]<=temp[0]){
                    start++;
                }
                if(arr[start][0]>temp[0]){
                    int[] t = arr[start];
                    arr[start] = arr[end];
                    arr[end] = t;
                }
                if(start>low) quickSort(arr,low,start-1);//左边序列。第一个索引位置到关键值索引-1
                if(end<high) quickSort(arr,end+1,high);//右边序列。从关键值索引+1到最后一个

            }

        }
        public static void main(String[] args) {
            Scanner sc  = new Scanner(System.in);
            int n = sc.nextInt();
            int l  = sc.nextInt();
            int[][] view = new int[n][2];
            int[] flag = new int[n];
            for (int i = 0; i < n; i++) {
                view[i][0] = sc.nextInt();
                view[i][1] = sc.nextInt();
            }
            quickSort(view,0,n-1);

            System.out.println(getMinView(view,l));
        }

        public static int getMinView(int[][] view,int l ){
            int sum  = 0 ;
            int low = 0;
            int kMax = -1;

            for (int i = 0; i < view.length;) {
                int  lowi = view[i][0];
                if(lowi>low){
                    return -1;
                }
                for (; i<view.length&&view[i][0] == lowi ;) {
                    if(view[i][0] <= low){
                        if(kMax == -1){
                            kMax = view[i][1];
                        }else {
                            kMax = kMax > view[i][1]?kMax:view[i][1];

                        }
                        i++;
                    }else {
                        return  -1;
                    }
                }
                sum++;
                low = kMax;
                if(kMax>= l){
                    return sum;
                }
            }
            return sum;
        }
    }
