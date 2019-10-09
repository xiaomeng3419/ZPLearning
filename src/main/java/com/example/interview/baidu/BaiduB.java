package com.example.interview.baidu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月17日 20:35
 * @ModificationHistory:
 */
public class BaiduB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while ((k--)>0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] arr = new int[n+1][n+1];
            Map<Integer,List<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                int y  = scanner.nextInt();
                if(map.containsKey(x)){
                    map.get(x).add(y);
                }else {
                    List<Integer> list= new ArrayList<Integer>();
                    list.add(y);
                    map.put(x,list);
                }
            }
            if (findPass(map,n)){
                System.out.println("POSSIBLE");
            }else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean findPass( Map<Integer,List<Integer>> map,int n) {
        List<Integer> list1 =  map.get(1);
        if ( list1.contains(n)){
            return true;
        }
        for (int i = 0 ; i < list1.size();i++){
            if ( map.get(list1.get(i)).contains(n)){
                return true;
            }
        }
        return false;
    }
}
