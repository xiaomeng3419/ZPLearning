package com.example.niuke;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhangpan on 2019/2/18.
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class niuke24 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        Stack<Integer> stack = new Stack();
        findPathByFST(lists, root, target, stack);
        return lists;
    }

    /**
     * 寻找路径
     * @param lists
     * @param root
     * @param target
     * @param stack
     */
    public void findPathByFST(ArrayList<ArrayList<Integer>> lists,TreeNode root,int target,Stack<Integer> stack){

        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> array = new ArrayList();//只有在获取满足条件的路径下才会新建数组
                for (Integer data : stack) {
                    array.add(data);
                }
                lists.add(array);
            }

            return;
        }

        if (root.left != null) {
            findPathByFST(lists, root.left, target-root.val, stack);
            stack.pop();
        }

        if (root.right != null) {
            findPathByFST(lists, root.right, target-root.val, stack);
            stack.pop();
        }

    }

}
