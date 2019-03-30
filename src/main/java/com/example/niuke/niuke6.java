package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/15.
 * °üº¬niuke7
 */
public class niuke6 {
    public static void main(String[] args) {
        System.out.println(new Solutionniuke6().minNumberInRotateArray(new int[]{3,4,5,1,2}));
        System.out.println(new Solutionniuke7().Fibonacci(10));
        System.out.println(new Solutionniuke8().JumpFloor(3));
        System.out.println(new Solutionniuke9().JumpFloorII(3));

    }
}
class Solutionniuke6 {
    public int minNumberInRotateArray(int [] array) {
        int result = 0;
        int flag = 0;
        for (int i = 0 ; i < array.length;i++){
            if(flag == 1){
                if(result>array[i]){
                    result=array[i];
                }
            }
            if (flag == 0){
                if(i>0&&array[i]<array[i-1]){
                    flag=1;
                    result = array[i];
                }
            }
        }
        return result;
    }
}

class Solutionniuke7 {
    public int Fibonacci(int n) {
        int var1 = 1;
        int var2 = 1;
        for (int i = 3;i<= n ;i++){
            int temp = var2;
            var2 = var1+var2;
            var1 = temp;
        }
        return var2  ;
    }
}


class Solutionniuke8 {
    public int JumpFloor(int target) {

        int var1 = 1;
        int var2 = 2;
        if(target == 0)
            return 0;
        if(target==1)
            return var1;
        if(target == 2)
            return var2;
        for (int i = 3;i<=target;i++){
            int temp = var2;
            var2 = var1+var2;
            var1 = temp;
        }
        return var2;
    }
}


class Solutionniuke9 {
    public int JumpFloorII(int target) {
        int arr[] = new int[target];

        int var1 = 1;
        int var2 = 2;
        if(target == 0)
            return 0;
        if(target==1)
            return var1;
        if(target == 2)
            return var2;
        for (int i = 3;i<=target;i++){
            int temp = var2;
            var2 = var2*2;
        }
        return var2;
    }
}