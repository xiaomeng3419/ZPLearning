package com.example.niuke;

/**
 * Created by zhangpan on 2019/3/13.
 */
public class niuke39 {
    private static boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
      return isAvl(root);
    }

     public  boolean isAvl(TreeNode treeNode){
         if (treeNode==null){
             return true;
         }
         if(treeNode.left!=null && treeNode.right== null){
                if(isAvl(treeNode.left)){
                    if(getDeapth(treeNode.left)-0>1){
                        return false;
                    }else {
                        return true;
                    }
                }else {
                    return false;
                }
         }else if(treeNode.right != null && treeNode.left == null){
             if(isAvl(treeNode.right)){
                 if(getDeapth(treeNode.right)>1){
                     return false;
                 }else {
                     return true;
                 }
             }else {
                 return false;
             }
         }else {
             if(isAvl(treeNode.left) && isAvl(treeNode.right)){
                 if(Math.abs(getDeapth(treeNode.left) - getDeapth(treeNode.right))<2){
                     return true;
                 }else {
                     return false;
                 }
             }else {
                 return false;
             }
         }

     }





    public int getDeapth(TreeNode root){
       if(root == null){
           return 0;
       }
        if(root.left==null&&root.right==null){
            return 0;
        }
        int temp=1;
        if (root.right!=null&&root.left!=null){
            int lc = temp+getDeapth(root.left);
            int rc = temp+getDeapth(root.right);
//            System.out.println("dob :"+(lc>rc?lc:rc));
            temp=lc>rc?lc:rc;
        }else if(root.right!=null&&root.left==null){
            temp = temp+getDeapth(root.right);
//            System.out.println("right:"+root.val);
        }else {
//            System.out.println("left :"+root.val);
            temp = temp+getDeapth(root.left);
        }
        return temp;
    }



    public static void main(String[] args) {
        TreeNode treeNode1 =  new TreeNode(1);
        TreeNode treeNode2 =  new TreeNode(2);
        TreeNode treeNode3 =  new TreeNode(3);
        TreeNode treeNode4 =  new TreeNode(4);
        TreeNode treeNode5 =  new TreeNode(5);
        TreeNode treeNode6 =  new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.left = treeNode6;
        System.out.println(new niuke39().IsBalanced_Solution(treeNode1));
    }
}
