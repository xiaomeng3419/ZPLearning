package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/21.
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S��
 * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 */
public class niuke43 {
    public String LeftRotateString(String str,int n) {
            if (str.length()==0){
                return str;
            }
        StringBuffer sb = new StringBuffer(str) ;
        int len = str.length()-1;
        for (int i = 0;i<n;i++){
            char c= sb.charAt(0);
            sb = sb.deleteCharAt(0);
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new niuke43().LeftRotateString("abcdefg",2));
    }
}
