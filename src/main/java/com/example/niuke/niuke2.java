package com.example.niuke;

/**
 * Created by zhangpan on 2018/11/25.
 */
public class niuke2 {
    public static String replaceSpace(StringBuffer str) {
            StringBuffer temp =new StringBuffer();
            String string  = str.toString();
            char[] chars = string.toCharArray();

         for (int i = 0 ; i < chars.length;i++){
                if(' ' == chars[i]){
                   temp.append("%20");
                }else {
                    temp.append(chars[i]);
                }
            }
                return  String.valueOf(temp);
    }

    public static void main(String[] args) {
        replaceSpace(new StringBuffer("we are family"));
    }
}
