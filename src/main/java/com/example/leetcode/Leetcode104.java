package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

/**
 * Created by zhangpan on 2019/4/3.
 */
public class Leetcode104 {
    public static  int max = 0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int deep = 1;
        while(root!=null) {
            int deep1 = getDeep(root);
        }
        return max;
    }
public int getDeep(TreeNode node){
        if(node ==null){
            return 0;
        }
        int temp=0;
        if(node.left!=null && node.right!=null){
             int l =  getDeep(node.left);
             int r = getDeep(node.right);
             temp = l>r?l:r;
             temp ++;
        }else if(node.left!=null){
            temp =   getDeep(node.left)+1;
        }else if(node.right!=null){
            temp = getDeep(node.right)+1;
        }
        max  = max>temp?max : temp;
        return max;

}

    public static void main(String[] args) {

    }
}
