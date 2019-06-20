package com.example.custom.bitcompute;

/**
 *
 * ���ڼӼ��˳���λ����
 *
 * Created by zhangpan on 2019/3/30.
 */
public class BitCompute {

    /**
     * �ӷ���λ����
     * @param a
     * @param b
     * ������b������ǽ�λ
     * @return
     */
    public static int add(int a,int b) {
//        return num2==0 ? Add((num1&num2)<<1,num1^num2): num2;
        int ans;
        while(b!=0) {   //ֱ��û�н�λ
            ans = a^b;        //������λ�ӷ�
            b = ((a&b)<<1);   //��λ
            a = ans;
        }
        return a;
    }

    /**
     * ����a+��-b��
     * @param a
     * @param b
     * @return
     */
    public  static  int sub(int a,int b){
    return add(a, unum(b));
}

    /**
     * ȡ����
     * @param a
     * @return
     */
    public static int unum(int a){
        return  ~(a-1);
}

    /**
     * java�ĳ˷�λ����
     * @param a
     * @param b
     * @return
     */

    public int multi(int a,int b){
        int i=0;
        int res=0;
        while(b!=0){//����Ϊ0�����
            //���������ǰλ
            if((b&1)==1){
                res+=(a<<i);
                b=b>>1;
                ++i;//i��¼��ǰλ�ǵڼ�λ
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
     * a/b��˼��
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
