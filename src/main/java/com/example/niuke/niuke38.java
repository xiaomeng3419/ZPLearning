package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/13.
 */
public class niuke38 {
    static  int deapth=0;

    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return getDeapth(root);
    }
    public int getDeapth(TreeNode root){
        if(root.left==null&&root.right==null){
            return 0;
        }
        int temp=1;
        if (root.right!=null&&root.left!=null){
            int lc = temp+getDeapth(root.left);
            int rc = temp+getDeapth(root.right);
            System.out.println("dob :"+(lc>rc?lc:rc));
            temp=lc>rc?lc:rc;

        }else if(root.right!=null&&root.left==null){
            temp = temp+getDeapth(root.right);
            System.out.println("right:"+root.val);
        }else {
            System.out.println("left :"+root.val);
            temp = temp+getDeapth(root.left);
        }
        return temp;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;
        node5.left=node7;
//        node1.left=node2;
//        node2.left=node3;
//        node3.right=node4;
//        node1.right=node5;
        System.out.println(new niuke38().TreeDepth(node1));
    }
}
