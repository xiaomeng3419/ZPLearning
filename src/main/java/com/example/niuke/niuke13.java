package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class niuke13 {
    /**
     * 这种用两个奇数数组、偶数数组，最后拼接更简单
     * @param array
     */
    public void reOrderArray(int [] array) {
        int pos = 0;
        for (int i = 0 ; i < array.length;i++){
            if(array[i]%2==0){
                pos++;
            }
        }
        int  temp;
        for (int i = 0;i<array.length;i++){
            int j=i+1;
            if (array[i]%2==0){
                if(array.length-i==pos){
                    j=array.length-1;
                }
                if(j==array.length-1){
                    break;
                }
                temp= array[i];

                for ( ;j< array.length;j++){
//                    System.out.println(temp);
                    if (array[j]%2==1){
                        array[i]=array[j];
                        array[j] = temp;
                        break;
                    }else {
                        int t= array[j];
                        array[j]=temp;
                        temp = t;
//                        System.out.println(temp);
                    }
                }

            }

            if(j==array.length-1){
                break;
            }
        }
        for (int num : array){
            System.out.println(num);
        }

    }

    public static void main(String[] args) {
        new niuke13().reOrderArray(new int[]{2,4,6});

    }
}
