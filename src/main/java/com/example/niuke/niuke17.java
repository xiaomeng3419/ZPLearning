package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
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

    if (root2==null) {        //������������һ�������ӽṹ
        return false;
    }
    if (root1==null) {        //���AΪ�գ��ǿ϶�����false
        return false;
    }
    if(root2.val==root1.val){        //A��B�Ƚϵĸ��ڵ��ֵ��ͬ

        if (root2.left==null&&root2.right==null) {        //�ȽϵĽڵ���B��β�ڵ㣬�ݹ��ֹ
            return true;
        }
        //�������ֱȽϵ��ǱȽϵĽڵ���ȫ��ͬ�����
        if ((root2.left!=null&&root2.right!=null)&&(root1.left!=null&&root1.right!=null)&&root2.left.val==root1.left.val&&root2.right.val==root1.right.val) {
            return HasSubtree(root1.left,root2.left)&& HasSubtree(root1.right,root2.right);
        }else if ((root2.left!=null&&root2.right==null)&&(root1.left!=null&&root1.right==null)&&root2.left.val==root1.left.val) {
            return HasSubtree(root1.left,root2.left);
        }else if ((root2.left==null&&root2.right!=null)&&(root1.left==null&&root1.right!=null)&&root2.right.val==root1.right.val) {
            return HasSubtree(root1.right,root2.right);
        }else{        //�ȽϵĽڵ㲻ͬ��A�������ӽڵ��ƶ�һ���ٱȽ�
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
        //�Ƚϵĸ��ڵ��ֵ����ͬ��ֱ���������ӽڵ㻬��
    }else if(root1.left!=null&&root1.right==null){
        return HasSubtree(root1.left,root2);
    }else if(root1.left==null&&root1.right!=null){
        return HasSubtree(root1.right,root2);
    }else{
        return false;
    }
}
 */
