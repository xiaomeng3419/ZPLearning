package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 */
public class niuke12 {
    public static void main(String[] args) {
        System.out.println(new niuke12().Power(2.0,-1));
    }
    public double Power(double base, int exponent) {
            double result = 1.0;
            if (base == 0.0){
                return 0.0;
            }
            if(exponent == 0){
                return 1.0;
            }
            if(exponent>0){
                for (int i = 0; i < exponent;i++){
                    result*=base;
                }
            }else {
                for (int i = 0; i < Math.abs(exponent);i++){
                    result*=base;
                }
                result = 1.0/result;
            }
            return result;
    }
}
