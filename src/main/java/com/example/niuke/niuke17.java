package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class niuke17 {
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
        //second tree
        TreeNode node7= new TreeNode(3);
        TreeNode node8= new TreeNode(4);
        TreeNode node9= new TreeNode(6);
        node7.left = node9;
        node7.right = node8;
        System.out.println(HasSubtree(node1,node7));
    }

    public static boolean HasSubtreeequal(TreeNode root1,TreeNode root2) {
      boolean var1 = root1.val == root2.val? true:false;

      boolean var2 = HasSubtreeequal(root1.left,root2.left);
      boolean var3 =HasSubtreeequal (root1.right,root2.right);
      if(var1&&(var2&&var3)){
          return true;
      }
      return false;

    }
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;
        if (root2 == null){
            return false;
        }
        if (root1 == null){
            return false;
        }
        if(root1.val==root2.val){
            if(root2.left==null&&root2.right==null){
                return true;
            }
            if((root2.left!=null&&root2.right!=null)&&(root1.left!=null&&root1.right!=null)&&(root1.left.val==root2.left.val)&&(root1.right.val==root2.right.val)){
                return HasSubtree(root1.left,root2.left)&&HasSubtree(root1.right,root2.right);
            }else if((root2.left!=null&&root2.right==null)&&(root1.left!=null&&root1.right==null)&&(root1.left.val==root2.left.val)){
                return HasSubtree(root1.left,root2.left);
            }else if((root2.left==null&&root2.right!=null)&&(root1.left==null&&root1.right!=null)&&(root1.right.val==root2.right.val)){
                return HasSubtree(root1.right,root2.right);
            }else {
                    if(root1.left!=null&&root1.right!=null){
                        return HasSubtree(root1.left,root2)|| HasSubtree(root1.right,root2);
                    }else if(root1.left==null&&root1.right!=null){
                        return HasSubtree(root1.right,root2);
                    }else if(root1.left!=null&&root1.right==null){
                        return  HasSubtree(root1.left,root2);
                    }else {
                        return false;
                    }
            }
        }else if(root1.left!=null&&root1.right==null){
                return HasSubtree(root1.left,root2);
            }else if(root1.left==null&&root1.right!=null){
                return HasSubtree(root1.right,root2);
            }else{
                return false;
            }
//            if(HasSubtree(root1.right,root2)||HasSubtree(root1.left,root2)){
//                return true;
//            }
//            return false;
    }



}

/**

public static boolean HasSubtree(TreeNode root1,TreeNode root2) {

    if (root2==null) {        //空树不是任意一个树的子结构
        return false;
    }
    if (root1==null) {        //如果A为空，那肯定返回false
        return false;
    }
    if(root2.val==root1.val){        //A和B比较的根节点的值相同

        if (root2.left==null&&root2.right==null) {        //比较的节点是B的尾节点，递归截止
            return true;
        }
        //下面三种比较的是比较的节点完全相同的情况
        if ((root2.left!=null&&root2.right!=null)&&(root1.left!=null&&root1.right!=null)&&root2.left.val==root1.left.val&&root2.right.val==root1.right.val) {
            return HasSubtree(root1.left,root2.left)&& HasSubtree(root1.right,root2.right);
        }else if ((root2.left!=null&&root2.right==null)&&(root1.left!=null&&root1.right==null)&&root2.left.val==root1.left.val) {
            return HasSubtree(root1.left,root2.left);
        }else if ((root2.left==null&&root2.right!=null)&&(root1.left==null&&root1.right!=null)&&root2.right.val==root1.right.val) {
            return HasSubtree(root1.right,root2.right);
        }else{        //比较的节点不同，A向左右子节点移动一个再比较
            if (root1.left!=null&&root1.right!=null) {
                return  HasSubtree(root1.left,root2)|| HasSubtree(root1.right,root2);
            }else if(root1.left==null&&root1.right!=null){
                return  HasSubtree(root1.right,root2);
            }else if(root1.left!=null&&root1.right==null){
                return  HasSubtree(root1.left,root2);
            }else {
                return false;
            }
        }
        //比较的根节点的值不相同，直接向左右子节点滑动
    }else if(root1.left!=null&&root1.right==null){
        return HasSubtree(root1.left,root2);
    }else if(root1.left==null&&root1.right!=null){
        return HasSubtree(root1.right,root2);
    }else{
        return false;
    }
}
 */
