package com.example.niuke;

/**
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * Created by zhangpan on 2019/3/23.
 */
public class niuke49 {
    //字符 0 的ASCII码为48,则字符 9 的ASCII码为57。
    public int StrToInt(String str) {
        char[] chs = str.toCharArray();
        if (chs.length == 0 || chs[0] == '0') {
            return 0;
        }
        int var  = 1;
        int i = 0;
        if(chs[0] == '-' ){
            i++;
            var = -1;
        }else if(chs[0] == '+'){
            i++;
        }

        int sum =0;
        int flag = 1;
        for (;i<chs.length;i++){
            if((int)chs[i]>=48&&(int)chs[i]<=57){
                sum = flag*sum +  ((int)chs[i]-48);
                flag =10;
            }else {
                return 0;
            }
        }
        return sum*var;
    }
    public static void main(String[] args) {
        System.out.println(new niuke49().StrToInt("-123"));
    }
}
