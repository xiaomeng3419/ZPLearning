package com.example.interview.qianxin;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月12日 20:13
 * @ModificationHistory:
 */
public class QiAnXinA {
    static String[] str = {"","十","百","千","万"};
    static String[] express = {"零","一","二","三","四","五","六","七","八","九"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        System.out.println(func(line));

    }

    private static String func(String line) {
      char[] chs = line.toCharArray();
      String result = "";
      for (int i = chs.length-1; i >=0 ; i--) {
           if(chs[i]<'0'&& chs[i]>'9'){
                return "错误输入";
           }
           int index = Integer.valueOf(chs[i]+"");
           if(0==index&&i>0){
               if(result.substring(result.length()-1).equals("零")){
                   continue;
               }else {
                   result = result+"零";
               }
           }else {
               String unit  = str[i];
               result = express[index] + unit;
           }

        }
        return result;
    }
}
