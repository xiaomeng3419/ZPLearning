package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */
public class niuke13 {
    /**
     * �����������������顢ż�����飬���ƴ�Ӹ���
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
