    package com.example.interview.tencent;

    import java.util.List;
    import java.util.ArrayList;
    import java.util.Scanner;

    /**
     * Created by zhangpan on 2019/5/29.
     */
    public class ZJTDCode1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] nums = str.split(" ");
            List<Integer> var1 = new ArrayList<Integer>(nums.length);
            List<Integer> var2 = new ArrayList<Integer>(nums.length);
            List<Integer> result = new ArrayList<Integer>(nums.length);
            for (int i = 0; i < nums.length;i++ ){
                int c =  Integer.valueOf(nums[i]);
                boolean f = c >= 0 ? var1.add(c):var2.add(c);
            }
            for (int i = 0 ; ( var1.size()>0) &&(var2.size()>0);i++){
                if(i%2 == 0 ){
                    result.add(var1.get(0));
                    var1.remove(0);
                }else {
                    result.add(var2.get(0));
                    var2.remove(0);
                }
            }
            result.addAll(var1);
           result.addAll(var2);
            System.out.println(result.toString());
        }
    }
