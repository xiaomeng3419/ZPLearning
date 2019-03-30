package com.example.niuke;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Created by zhangpan on 2019/2/15.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class niuke4 {

    public static void main(String[] args) {
        niuke4 nu =  new niuke4();
        TreeNode t = nu.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,6,8});
//        TreeNode t = nu.reConstructBinaryTree(new int[]{1,2,3,4,5,6,7},new int[]{3,2,4,1,6,5,7});
        nu.presout(t);
    }

    /**
     *
     * @param pre 前序顺序
     * @param in 中序顺序
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0 || in.length == 0 || pre.length != in.length){
            return null;
        }

        return constructTree(pre,0,pre.length-1,in,0,in.length-1);
//        return construct(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if(ps > pe) return null;

        // 取前序遍历的第一个数字就是根节点
        int value = pre[ps];
        // 在中序遍历中中寻找根节点
        int index =is;
        while(index <= ie && value != in[index]) {
            index ++;
        }
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if(index > ie)
            throw new RuntimeException("Invalid Iuput!");

        // 创建当前根节点，并为根节点赋值
        TreeNode node = new TreeNode(value);
        // 递归调用构建当前节点的左子树
        node.left = construct(pre, ps+1, ps+index-is, in, is, index-1);
        // 递归调用构建当前节点的右子树
        node.right = construct(pre, ps+index-is+1, pe, in, index+1, ie);

        return node;
    }
    private TreeNode constructTree(int[] pre,int pstart,int pend,int[] in,int istart,int iend){
        if(pstart>pend){
            return null;
        }
        int val = pre[pstart];
        TreeNode root = new TreeNode(val);
        int index1 = istart;
        while (index1<= iend){
            if(in[index1] == val){
                break;
            }
            index1++;
        }
        if(index1>iend){
            new RuntimeException("不能构成一棵树");
        }

        root.left = constructTree(pre,pstart+1,pstart+(index1-istart),in,istart, index1-1);
        root.right = constructTree(pre,pstart+(index1-istart)+1,pend,in,index1+1, iend);
        return root;

    }
    void presout(TreeNode treeNode){
        if(treeNode.left!=null)
            presout(treeNode.left);
        System.out.println(treeNode.val);

        if(treeNode.right!=null)
            presout(treeNode.right);
    }

}

 class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
