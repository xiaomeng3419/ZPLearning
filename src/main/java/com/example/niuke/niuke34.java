package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/5.
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 */
public class niuke34 {
    public static void main(String[] args) {
//        System.out.println(FirstNotRepeatingChar("asdfkadfl;afgvnmcx,vnhpqwerofsaj"));
        System.out.println(FirstNotRepeatingChar("google"));
    }
    public static int FirstNotRepeatingChar(String str) {
        char[] chs = str.toCharArray();
        int[] chsFlag = new int[chs.length];
        for (int i = 0; i<chs.length;i++){
            int j = i+1;
            for (;j<chs.length;j++){
                if(chsFlag[j]==1){
                    continue;
                }
                if(chs[i]==chs[j]){
                    chsFlag[i]=chsFlag[j]=1;
                    break;
                }
            }
            if (chsFlag[i]==0){
                return i;
            }
            if(j==chs.length-1){
                if (chsFlag[i]==0&&chs[i]!=chs[j-1]){
//                System.out.println(chs[i]);
                    return i;
                }else {
                    return -1;
                }
            }else if (chsFlag[i]==0&&j<chs.length-1&&chs[i]!=chs[j]){
//                System.out.println(chs[i]);
                return i;
            }
        }
        return -1;
    }
}
