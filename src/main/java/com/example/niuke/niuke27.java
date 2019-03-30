package com.example.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangpan on 2019/2/21.
 */
public class niuke27 {

    ArrayList<String> lists = new ArrayList<>();
    Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        String str = "aab";
        niuke27 niuke27 = new niuke27();
        ArrayList<String> list = new ArrayList<>();
        list = niuke27.Permutation(str);
        for (String strs:list){
            System.out.println(strs);
        }

    }

    public ArrayList<String> Permutation(String str) {

        if (str.length()==0){
            return lists;
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0;i<length;i++){
            for (int j = i+1;j<length;j++){
                    if(chars[j]<chars[i]){
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }
            }
        }
        fullsort(chars,0,length-1);
//        lists.addAll(set);
        lists.addAll(set);
        lists.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.compareTo(o2);
            }
        });

        return lists;
    }

        public void fullsort(char[] chars,int start,int end){
            if(start==end){
//                lists.add(String.valueOf(chars));
                set.add(String.valueOf(chars));
//                System.out.println(String.valueOf(chars));
                return;
            }else {
                for (int i = start;i<=end;i++){
                    swapchar(chars,i,start);
                    fullsort(chars,start+1,end);
                    swapchar(chars,i,start);
                }
            }
        }

        public void swapchar(char[] chars,int var1,int var2){
            char temp = chars[var1];
            chars[var1]= chars[var2];
            chars[var2] = temp;
        }

}
