package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 */
public class niuke11 {
    private String binary2(int n){
            StringBuffer stringBuffer = new StringBuffer();
            char sum ;
        for (int i = n; i >= 1; i /= 2) {
            if (i % 2 == 0) {
                sum = '0';
            } else {
                sum = '1';
            }
            stringBuffer.append(sum);
        }
        return  stringBuffer.toString();
    }
    public void Binary3(int num) {
        for (int i = 8; i > 0; i--) {
            System.out.print(num >> i & 1);
        }
    }
    public  void getComplement(int value) {
        for (int i = 0; i < 32; i++) {
            int t = (value & 0x80000000 >>> i) >>> (31 - i);

            System.out.print(t);
        }
    }
    private String binary1(int n){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            byte j = (byte) (n & (1 << 8 - i));
            char c = j == 0 ? '0' : '1';
            stringBuffer.append(c);
            System.out.print(c);
        }
        System.out.println();
        System.out.println(stringBuffer);
        return  stringBuffer.toString();
    }

    private String binaryNeg(int n){
        n = Math.abs(n);
        for (int i = 8; i > 0; i--) {
            System.out.print(n >> i & 1);
        }

        System.out.println(n);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('1');
        for (int i = 0; i < 7; i++) {
            byte j = (byte) (n & (1 << 8 - i));
            char c = j == 0 ? '0' : '1';
            stringBuffer.append(c);
            System.out.print(c);
        }
        System.out.println();
        System.out.println(stringBuffer);

        return  stringBuffer.toString();
    }




    public static void main(String[] args) {
        int number = -12;

        System.out.println(Integer.toBinaryString(number));
        String s = Integer.toBinaryString(number);
        int sum = 0;
        char[] chars = s.toCharArray();
        for (char ch:chars){
            if(ch == '1'){
                sum++;
            }
        }
        System.out.println(sum);
        if(number<0){
            new niuke11().binary1(8);
            new niuke11().binary2(8);
            new niuke11().Binary3(8);
        }else {
            new niuke11().getComplement(-1);
        }


    }
}
