package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/18.
 * ¾µÏñÊ÷
 */
public class niuke18 {
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
//        node2.right = node5;
//        node3.right = node4;
//        node3.left = node6;
        new niuke4().presout(node1);
        new niuke18().Mirror(node1);
        new niuke4().presout(node1);
    }
    public void Mirror(TreeNode root) {
            if(root==null){
                return ;
            }
            TreeNode hc;
            hc = root.left;
            root.left = root.right;
            root.right = hc;
            Mirror(root.left);
            Mirror(root.right);
    }
}
