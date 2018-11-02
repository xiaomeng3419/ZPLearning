package com.example.leetcode;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhangpan
 * @date 18-10-24 下午8:39
 * @package com.example.leetcode
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int minRoad = 0;
        int[][] road = new int[grid.length][grid[0].length];
        int temp=0;
        for (int i = 0; i < grid.length;i++){
            if (i==0)
               road[i][0] = grid[i][0]+temp;
            else
                road[i][0] = grid[i][0]+road[i-1][0];
        }
        temp = 0;
        for (int i = 0; i < grid[0].length;i++){
            if (i==0)
                road[0][i] = grid[0][i]+temp;
            else
                road[0][i] = grid[0][i]+road[0][i-1];
        }
        for(int i = 1 ; i <grid.length;i++)
            for (int j = 1; j <grid[0].length;j++){
                road[i][j] = (road[i-1][j] < road[i][j-1]?road[i-1][j]:road[i][j-1])+grid[i][j];
            }
        return road[grid.length-1][grid[0].length-1];
    }
}

public class Leetcode64 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        int[][] grid = {{1,3,1},{1,5,1},  {4,2,1}};
        int ret = new Solution().minPathSum(grid);
//
            String out = String.valueOf(ret);

            System.out.print(out);

//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[][] grid = stringToInt2dArray(line);
//
//            int ret = new Solution().minPathSum(grid);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
    }
}