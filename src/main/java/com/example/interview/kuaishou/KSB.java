package com.example.interview.kuaishou;

import java.util.*;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月16日 21:49
 * @ModificationHistory:
 */
public class KSB {
//    private static List<String> list = new ArrayList<>();
private static Set<String> list = new HashSet<>();



    public static void buildStr(int index,char[] chs,String temp){
        int num = (int) chs[index]-48;
        for (int i = 0; i < strs[num].length(); i++) {
            if(index!= chs.length-1){
                buildStr(index+1,chs,temp+strs[num].charAt(i));
            }else {
                list.add(temp+strs[num].charAt(i));
            }
        }
    }



    private static String[] strs = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String strNum = scanner.nextLine();
        char[] chs =strNum.toCharArray();
        Arrays.sort(chs);
        buildStr(0,chs,"");
        System.out.println(list.toString());
    }
}
