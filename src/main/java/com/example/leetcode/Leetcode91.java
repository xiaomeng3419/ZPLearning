package com.example.leetcode;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangpan on 2019/1/3.
 */
public class Leetcode91 {
        public static   String stringToString(String input) {
            if (input == null) {
                return "null";
            }
            return Json.value(input).toString();
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                String s = stringToString(line);

                int ret = new Solution911().numDecodings(s);

                String out = String.valueOf(ret);

                System.out.print(out);
            }
        }
}
class Solution911 {
    public int numDecodings(String s) {
        String str = "";
        for (int i = 0; i<s.length();i++){
            if (s.charAt(i) != '"')
                str+=s.charAt(i);
        }
        int[] chs = new int[str.length()];
        for (int i = 0;i<str.length();i++){
            chs[i] = str.charAt(i)- '0';
        }
        int[] len = new int[str.length()];
        if (chs.length<=0||chs[0]<=0){
            return 0;
        }

        len[0] = 1;
//        长度仅为1
        if(chs.length == 1){
            return len[0];
        }
        for(int i = 1 ; i < str.length();i++){
            int key = chs[i-1]*10+chs[i];
            if(key ==0){
                return 0;
            }
            if(key>10&&key<27&&key%10!=0){
                if(i==1){
                    len[i]=len[i-1]+1;
                }else {
                    len[i]=len[i-1]+len[i-2];
                }
            }else if(key%10==0){
                if(key==0||key>=30){
                    return 0;
                }else {
                    if(i==1){
                        len[i]=len[i-1];
                    }else {
                        len[i]=len[i-2];
                    }
                }
            }else if(key>0 ) {
                len[i]=len[i-1];

            }
        }
        return len[str.length()-1];
    }
}