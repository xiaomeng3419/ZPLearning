package com.example.niuke;

/**
     * ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�
 * ����string����������Ҫ��ʱ����0)��Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 * Created by zhangpan on 2019/3/23.
 */
public class niuke49 {
    //�ַ� 0 ��ASCII��Ϊ48,���ַ� 9 ��ASCII��Ϊ57��
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
