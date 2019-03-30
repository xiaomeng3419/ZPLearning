package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/20.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class niuke26 {
    private TreeNode leftHead = null;
    private TreeNode rightHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree ==null){
            return null;
        }
        if (pRootOfTree == null) return  null;

        Convert(pRootOfTree.left);

        if (leftHead == null) {
            leftHead = pRootOfTree;
            rightHead = pRootOfTree;
        }
        else {
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }

        Convert(pRootOfTree.right);

        return leftHead;
    }




    public static void main(String[] args) {

    }
}
