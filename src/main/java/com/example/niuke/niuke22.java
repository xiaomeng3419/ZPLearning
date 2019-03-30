package com.example.niuke;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by zhangpan on 2019/2/18.
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 二叉树的层次遍历
 */
public class niuke22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        LinkedList   queue = new LinkedList();
        if(root == null){
            return new ArrayList<Integer>();
        }
        TreeNode temp= root;
        queue.add(temp);
        while (!queue.isEmpty()){
            TreeNode var = (TreeNode)queue.poll();
            list.add(var.val);
            if(var.left!=null){
                queue.add(var.left);
            }
            if(var.right!=null){
                queue.add(var.right);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(3);
        TreeNode node4= new TreeNode(4);
        TreeNode node5= new TreeNode(5);
        TreeNode node6= new TreeNode(6);
        //first tree
        node1.left = node2;
        node2.left = node3;
        node2.right = node5;
        node3.right = node4;
        node3.left = node6;
        System.out.println(new niuke22().PrintFromTopToBottom(node1).toString());
    }
}
