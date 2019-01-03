package com.example.leetcode;

/**
 * @author zhangpan
 * @date 18-10-24 下午9:20
 * @package com.example.leetcode
 */
class Solution351 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0){
            return 0;
        }
        if (envelopes.length == 1){
            return 1;
        }
//        int[] arr = new int[];
        int[][] vars = new int[envelopes.length][envelopes[0].length];
        for(int i = 0 ; i < envelopes.length-1;i++) {
            for (int j = i+1; j < envelopes.length; j++) {
                if (envelopes[i][0]> envelopes[j][0]) {
                    int[] arr = new int[2];
                    arr = envelopes[i];
                    envelopes[i]=envelopes[j];
                    envelopes[j] = arr;
                }
            }
        }
        int sum =1;
        int row = envelopes[0][0];
        for (int i = 1;i<envelopes.length;i++){
//            if (envelopes[i][1]>row)
        }
        return 0;
    }
}

public class Leetcode351 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},  {4,2,1}};
        int ret = new Solution351().maxEnvelopes(grid);
        //
        String out = String.valueOf(ret);

        System.out.print(out);
    }
}
