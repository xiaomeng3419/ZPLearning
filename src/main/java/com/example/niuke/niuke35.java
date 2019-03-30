package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/11.
 */
public class niuke35 {
    static  Integer count = 0;
    private int result;
    static int[] temp;
//  ClassLoader
    void mergearray(int a[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] > a[j]) {
                // ��������������
                temp[k++] = a[j++];
                // ��Ϊ���a[i]��ʱ��������ĵ�ǰԪ��a[j]��
                // ��ô��������a[i]�����Ԫ�ؾͶ���a[j]��
                // ����Ϊ�����ʱ���������顿
                count += mid - i + 1;
            } else {
                temp[k++] = a[i++];
            }
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }



     void mergesort(int a[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp); // �������
            mergesort(a, mid + 1, last, temp); // �ұ�����
            mergearray(a, first, mid, last, temp); // �ٽ������������кϲ�
        }
    }
    public int InversePairs(int [] array) {
        // ������Ч����
        if (array == null || array.length <= 0) {
            return 0;
        }
        // ע�⣺��Ϊresult����Ϊ��Ա����������ÿһ�ε��ø÷�����Ҫ��ʼ��Ϊ0��
        result = 0;
        temp = new int[array.length];
        sort(array, 0, array.length - 1);
        return result;
    }
    public void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public void merge(int[] array, int left, int middle, int right) {
        int i = middle;
        int j = right;
        int index = right;

        //�ѱ���ѭ���õ������ֿ�����temp
        for (int k = left; k <= right; k++) {
            temp[k] = array[k];
        }
        while (i >= left && j >= middle + 1) {
            if (temp[i] > temp[j]) {
                array[index--] = temp[i--];
                //�������ĿΪ�ڶ�����������ʣ�������
                result += j - middle;
                // ��ֵ����Ҫ��������
                if (result > 1000000007)
                {
                    result %= 1000000007;
                }
            } else
                array[index--] = temp[j--];
        }
        while (i >= left)
            array[index--] = temp[i--];
        while (j >= middle + 1)
            array[index--] = temp[j--];

    }
    public static void main(String[] args) {
        System.out.println(new niuke35().InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}
