package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/21.
 */
public class niuke44 {
    public static void main(String[] args) {
//        System.out.println(new niuke44().ReverseSentence("student. a am I"));
        System.out.println(new niuke44().ReverseSentence(" "));
    }
    public String ReverseSentence(String str) {
        String s = str.trim();
       if(s.length() == 0){
           return "";
       }
       String[] strings = str.split(" ");
       StringBuffer sb = new StringBuffer();
        for (int i = strings.length-1;i>=0;i--){
            sb.append(strings[i]+ " " );
        }
       sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
