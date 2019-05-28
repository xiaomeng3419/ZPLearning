package com.example.leetcode;

import com.example.design.style.factorystyle.ingredient.Sauce;
import com.example.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhangpan on 2019/4/3.
 */
public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
      /*  if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tn = root;
        int base = 10;
        int temp = root.val;
        stack.add(root);
        Integer sum  = 0 ;
        int deep = 0;
        while (tn!=null&& !stack.isEmpty()){
            if(tn.left ==null&& tn.right == null){
                deep++;
                sum+=temp;
                if (!stack.isEmpty()){
                    temp /=(int)Math.pow(base,deep);
                }
                tn = stack.pop();
                temp = temp*base + tn.val;
            }else {
                deep=0;
                if(tn.right!=null){
                    stack.push(tn.right);
                }
                if(tn.left!=null){
                    stack.push(tn.left);
//                temp = temp*base+tn.left.val;
//                tn = stack.pop();
                }
//                deep++;
                tn = stack.pop();
                temp = temp*base+tn.val;
            }

        }
        return sum;*/
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)
            queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.left==null&&root.right==null){
                result += root.val;
            }
            if(root.left!=null){
                root.left.val += root.val*10;
                queue.offer(root.left);
            }
            if(root.right!=null){
                root.right.val += root.val*10;
                queue.offer(root.right);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(0);
//        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right =treeNode3;
//        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        System.out.println(new LeetCode129().sumNumbers(treeNode1));

    }
}
