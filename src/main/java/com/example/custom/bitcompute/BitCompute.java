package com.example.custom.bitcompute;

/**
 *
 * 关于加减乘除的位运算
 *
 * Created by zhangpan on 2019/3/30.
 */
public class BitCompute {

    /**
     * 加法的位运算
     * @param a
     * @param b
     * 后续中b代表的是进位
     * @return
     */
    public static int add(int a,int b) {
//        return num2==0 ? Add((num1&num2)<<1,num1^num2): num2;
        int ans;
        while(b!=0) {   //直到没有进位
            ans = a^b;        //不带进位加法
            b = ((a&b)<<1);   //进位
            a = ans;
        }
        return a;
    }

    /**
     * 等于a+（-b）
     * @param a
     * @param b
     * @return
     */
    public  static  int sub(int a,int b){
    return add(a, unum(b));
}

    /**
     * 取负数
     * @param a
     * @return
     */
    public static int unum(int a){
        return  ~(a-1);
}

    /**
     * java的乘法位运算
     * @param a
     * @param b
     * @return
     */

    public int multi(int a,int b){
        int i=0;
        int res=0;
        while(b!=0){//乘数为0则结束
            //处理乘数当前位
            if((b&1)==1){
                res+=(a<<i);
                b=b>>1;
                ++i;//i记录当前位是第几位
            }else{
                b=b>>1;
                ++i;
            }
        }
        return res;
    }

/*    mutis(int a,int b){
        int i = 0 ;
        int res  = 0;
        while (b!=0){
            if(b&1 ==1){
                i++;
                res = res+(a<<i);
                b= b>>i;
            }else {
                i++;
               b= b>>i;
            }
        }
    }*/

    /**
     * a/b的思想
     * @param a
     * @param b
     * @return
     */
    public static int division(int a,int b) {
        int res=-1;
        if(a<b){
            return 0;
        }else{
            res=division(sub(a,b), b)+1;
        }
        return res;
    }


}
