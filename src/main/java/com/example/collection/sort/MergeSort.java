package com.example.collection.sort;

/**
 * Created by zhangpan on 2019/2/22.
 */
public class MergeSort {
    public static void main(String[] args) {
        int a[] = {3,1,5,7,2,4,9,6};
        sortMergeRecursion(a);
        SimpleSelectSort.printResult(a,a.length);
    }



    public static void sortMergeRecursion(int[] nums) {
        sortMergeRecursionHelper(nums,0,nums.length-1);
    }

    // �鲢���򣬷ǵݹ�ʵ��(����)
    public void sortMergeIteration(int[] nums) {
        int len = 1;  // ��ʼ��������ĳ���
        while (len < nums.length) {
            for (int i = 0; i < nums.length; i += len * 2) {
                sortMergeIterationHelper(nums, i, len);
            }
            len *= 2;  // ÿ�ν���������ĳ���*2
        }
    }

    public static void sortMergeRecursionHelper(int[] nums, int left, int right) {
        if(left==right) return;

        int mid =left+ ((right-left))/2;
        sortMergeRecursionHelper(nums,left,mid );
        sortMergeRecursionHelper(nums,mid+1,right );
        mergeArr(nums,left,mid,right);
    }

    public static void mergeArr(int[] nums,int left,int mid,int right){
        int[] tem  = new int[right-left+1];
        int i = left,j=mid+1,k=0;
        while (i<=mid&&j<=right){
            tem[k++]=nums[i]<nums[j]?nums[i++]:nums[j++];
        }
        while (i<=mid){
            tem[k++] = nums[i++];
        }
        while (j<=right){
            tem[k++]=nums[j++];
        }
        int index=0;
        while (left<=right){
            nums[left++]=tem[index++];
        }
    }
    /**
     * ��������
     *
     * @param nums  ԭ����
     * @param start ��startλ�ÿ�ʼ
     * @param len   ���κϲ������鳤��
     */
    public void sortMergeIterationHelper(int[] nums, int start, int len) {
        int[] tem = new int[len * 2];
        int i = start;
        int j = start + len;
        int k = 0;
        while (i < start + len && (j < start + len + len && j < nums.length)) {
            tem[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i < start + len && i < nums.length) {  // ע�⣺����iҲ���ܳ�������
            tem[k++] = nums[i++];
        }
        while (j < start + len + len && j < nums.length) {
            tem[k++] = nums[j++];
        }
        int right = start + len + len;
        int index = 0;
        while (start < nums.length && start < right) {
            nums[start++] = tem[index++];
        }
    }
}
