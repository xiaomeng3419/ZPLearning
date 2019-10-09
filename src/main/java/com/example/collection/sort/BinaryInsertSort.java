package com.example.collection.sort;

/**
 * Created by zhangpan on 2019/2/20.
 * 折半插入排序
 * 折半插入算法是对直接插入排序算法的改进，排序原理同直接插入算法：

 　　把n个待排序的元素看成一个有序表和一个无序表，开始时有序表中只有一个元素，
 无序表中有n-1个元素；排序过程即每次从无序表中取出第一个元素，
 将它插入到有序表中，使之成为新的有序表，重复n-1次完成整个排序过程。
与直接插入算法的区别在于：在有序表中寻找待排序数据的正确位置时，使用了折半查找/二分查找。
 */
public class BinaryInsertSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {3,1,5,7,2,4,9,6};
        new BinaryInsertSort().binaryInsertSort(a);
    }
    private void binaryInsertSort(int[] a) {
        int n = a.length;
        int i ,j;
        for(i=1;i<n;i++){
            /**
             * temp为本次循环待插入有序列表中的数
             */
            int temp = a[i];
            int low=0;
            int high=i-1;
            /**
             * 寻找temp插入有序列表的正确位置，使用二分查找法
             */
            while(low <= high){
                /**
                 * 有序数组的中间坐标，此时用于二分查找，减少查找次数
                 */
                int mid = (low+high)/2;
                /**
                 * 若有序数组的中间元素大于待排序元素，则有序序列向中间元素之前搜索，否则向后搜索
                 */
                if(a[mid]>temp){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            for(j=i-1;j>=low;j--){
                /**
                 * 元素后移，为插入temp做准备
                 */
                a[j+1] = a[j];
            }

            a[low] = temp;

            /**
             * 打印每次循环的结果
             */
            print(a,n,i);
        }
        /**
         * 打印排序结果
         */
        printResult(a,n);

    }
    /**
     * 打印排序的最终结果
     * @param a
     * @param n
     */
    private void printResult(int[] a, int n){
        System.out.print("最终排序结果：");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }
    /**
     * 打印排序的每次循环的结果
     * @param a
     * @param n
     * @param i
     */
    private void print(int[] a, int n, int i) {
        // TODO Auto-generated method stub
        System.out.print("第"+i+"次：");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }
}
