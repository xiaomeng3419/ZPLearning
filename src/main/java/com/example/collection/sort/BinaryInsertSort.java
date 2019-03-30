package com.example.collection.sort;

/**
 * Created by zhangpan on 2019/2/20.
 * �۰��������
 * �۰�����㷨�Ƕ�ֱ�Ӳ��������㷨�ĸĽ�������ԭ��ֱͬ�Ӳ����㷨��

 ������n���������Ԫ�ؿ���һ��������һ���������ʼʱ�������ֻ��һ��Ԫ�أ�
 ���������n-1��Ԫ�أ�������̼�ÿ�δ��������ȡ����һ��Ԫ�أ�
 �������뵽������У�ʹ֮��Ϊ�µ�������ظ�n-1���������������̡�
��ֱ�Ӳ����㷨���������ڣ����������Ѱ�Ҵ��������ݵ���ȷλ��ʱ��ʹ�����۰����/���ֲ��ҡ�
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
             * tempΪ����ѭ�������������б��е���
             */
            int temp = a[i];
            int low=0;
            int high=i-1;
            /**
             * Ѱ��temp���������б����ȷλ�ã�ʹ�ö��ֲ��ҷ�
             */
            while(low <= high){
                /**
                 * ����������м����꣬��ʱ���ڶ��ֲ��ң����ٲ��Ҵ���
                 */
                int mid = (low+high)/2;
                /**
                 * ������������м�Ԫ�ش��ڴ�����Ԫ�أ��������������м�Ԫ��֮ǰ�����������������
                 */
                if(a[mid]>temp){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            for(j=i-1;j>=low;j--){
                /**
                 * Ԫ�غ��ƣ�Ϊ����temp��׼��
                 */
                a[j+1] = a[j];
            }

            a[low] = temp;

            /**
             * ��ӡÿ��ѭ���Ľ��
             */
            print(a,n,i);
        }
        /**
         * ��ӡ������
         */
        printResult(a,n);

    }
    /**
     * ��ӡ��������ս��
     * @param a
     * @param n
     */
    private void printResult(int[] a, int n){
        System.out.print("������������");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }
    /**
     * ��ӡ�����ÿ��ѭ���Ľ��
     * @param a
     * @param n
     * @param i
     */
    private void print(int[] a, int n, int i) {
        // TODO Auto-generated method stub
        System.out.print("��"+i+"�Σ�");
        for(int j=0;j<n;j++){
            System.out.print(" "+a[j]);
        }
        System.out.println();
    }
}
