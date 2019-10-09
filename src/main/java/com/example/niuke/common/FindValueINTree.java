package com.example.niuke.common;

import com.example.leetcode.common.TreeNode;

import java.util.*;
/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月08日 22:42
 * @ModificationHistory:
 */
public class FindValueINTree {
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
        System.out.println(new FindValueINTree().FindPath(treeNode1,14));
    }


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target)
    {
        ArrayList<ArrayList<Integer>> pathlist = new ArrayList<ArrayList<Integer>>();
        if(root == null || root.val > target)
            return pathlist;
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPath(root,target,pathlist,path);
        return pathlist;
    }
    private void findPath(TreeNode root,int target,ArrayList<ArrayList<Integer>> pathlist,ArrayList<Integer> path)
    {
        //如果节点为空，或者值小于target此条路径清空
        if(root == null || root.val > target)
        {
            path.clear();
        }
        else if(root.val == target)//如果当前节点等于target且为叶子节点则直接将它添加到path中，否则这条路径清空
        {
            if(root.left == null && root.right==null)
            {
                path.add(root.val);
                pathlist.add(path);
            }
            else
            {
                path.clear();
            }
        }
        else  //当根节点的值小于target，则递归去寻找它的左右子树
        {
            path.add(root.val);
            ArrayList<Integer> path2 = new ArrayList<Integer>();
            path2.addAll(path);
            target -= root.val;
            findPath(root.left,target,pathlist,path);
            findPath(root.right,target,pathlist,path2);
        }
    }



}
