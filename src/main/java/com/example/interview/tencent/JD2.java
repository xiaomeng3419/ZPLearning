package com.example.interview.tencent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zhangpan on 2019/4/13.
 */
public class JD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] strs = new String[n];
        for (int i = 0;i<strs.length;i++){
            strs[i] = in.nextLine();
        }
        String s = in.nextLine();
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int t = -1;
        for (int i=0;i<n;i++ ){
            int c =s.indexOf(strs[i]);
            while (c>=0){
                if(c>=0){
                    if(set.contains(c)||set.contains(c+strs[i].length()-1)){

                    }else {
                        set.add(c);
                        set.add(c+strs[i].length()-1);
//                        System.out.println(c);
//                        System.out.println(c+strs[i].length()-1);
                        count++;
                    }
                    t = c;
                    c = s.indexOf(strs[i],c+strs[i].length());
                }else {
                    continue;
                }
            }
        }
        System.out.println(count);
    }
}
