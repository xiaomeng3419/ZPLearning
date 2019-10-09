package com.example.interview.wy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月27日 19:09
 * @ModificationHistory:
 */
public class WYE {
    static  Map<Integer,Integer> view = new HashMap<>();
    static {
        for (int i = 1; i < 10; i++) {
            view.put(i,0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N-->0){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Map<Integer,Integer> vas = luckNum(x,y);
            for (Map.Entry<Integer,Integer> entry:vas.entrySet()){
                System.out.print(entry.getValue()+" ");
            }
            System.out.println();

        }
        int lucknum = -1;
        int temp = -1;
        for (Map.Entry<Integer,Integer> entry:view.entrySet()){
            if(temp == -1){
                lucknum = entry.getKey();
                temp = entry.getValue();
            }else{
                if(temp> entry.getValue()){
                    continue;
                }else {
                    temp = entry.getValue();
                    lucknum = lucknum< entry.getKey()?lucknum:entry.getKey();
                }
            }
        }
        System.out.println(lucknum);
    }

    private static  Map<Integer,Integer> luckNum(int x, int y) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            map.put(i,0);
        }
        int tempy = y;
        int tempx = x;
        long varresult = 1l*x*y;
        while (y!=0){
            int var = y %10;
            int temp = x * var;
            while (temp!=0){
                int index = temp %10;
                if(index == 0){
                    temp = temp/10;
                    continue;
                }
                map.put(index,map.get(index)+1);
                view.put(index,map.get(index)+1);
                temp = temp/10;
            }
            y=y/10;
        }
        while (tempy!=0){
            int index = tempy %10;
            if(index == 0){
                tempy = tempy/10;
                continue;
            }
            map.put(index,map.get(index)+1);
            view.put(index,map.get(index)+1);
            tempy = tempy/10;
        }
        while (tempx!=0){
            int index = tempx %10;
            if(index == 0){
                tempx = tempx/10;
                continue;
            }
            map.put(index,map.get(index)+1);
            view.put(index,map.get(index)+1);
            tempx = tempx/10;
        }

        while (varresult!=0){
            int index = (int) varresult %10;
            if(index == 0){
                varresult = varresult/10;
                continue;
            }
            map.put(index,map.get(index)+1);
            view.put(index,map.get(index)+1);
            varresult = varresult/10;
        }
        return map;
    }


}
