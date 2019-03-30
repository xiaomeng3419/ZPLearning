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
                // 左数组比右数组大
                temp[k++] = a[j++];
                // 因为如果a[i]此时比右数组的当前元素a[j]大，
                // 那么左数组中a[i]后面的元素就都比a[j]大
                // 【因为数组此时是有序数组】
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
            mergesort(a, first, mid, temp); // 左边有序
            mergesort(a, mid + 1, last, temp); // 右边有序
            mergearray(a, first, mid, last, temp); // 再将二个有序数列合并
        }
    }
    public int InversePairs(int [] array) {
        // 考虑无效输入
        if (array == null || array.length <= 0) {
            return 0;
        }
        // 注意：因为result设置为成员变量，所以每一次调用该方法都要初始化为0！
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

        //把本次循环用到的数字拷贝进temp
        for (int k = left; k <= right; k++) {
            temp[k] = array[k];
        }
        while (i >= left && j >= middle + 1) {
            if (temp[i] > temp[j]) {
                array[index--] = temp[i--];
                //逆序对数目为第二个子数组中剩余的数字
                result += j - middle;
                // 数值过大要进行求余
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
