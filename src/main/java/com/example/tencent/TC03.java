package com.example.tencent;

/**
 * Created by zhangpan on 2019/3/18.
 * BST转成双向链表
 */
public class TC03 {

    public class Solution {
        public TreeNode Convert(TreeNode pRootOfTree) {
            // 根节点为空
            if(pRootOfTree == null) return null;

            if(pRootOfTree.left != null){
                // 先转换左子树，获得转换后的头指针
                TreeNode left = Convert(pRootOfTree.left);

                // 获得指向左子树的最后一个元素的指针
                while(left.right != null) left = left.right;

                // 与root链接，注意双向
                pRootOfTree.left = left;
                left.right = pRootOfTree;
            }

            if(pRootOfTree.right != null){
                // 同理，转换右子树
                TreeNode right = Convert(pRootOfTree.right);

                // 获得指向右子树的第一个元素的指针，这里直接就是right，与root双向链接
                pRootOfTree.right = right;
                right.left = pRootOfTree;
            }

            // 最后把pRootOfTree指向双向链表的第一个元素再返回
            while(pRootOfTree.left != null){
                pRootOfTree = pRootOfTree.left;
            }

            return pRootOfTree;
        }
    }
}

class TreeNode {
    int val;
    com.example.tencent.TreeNode left;
    com.example.tencent.TreeNode right;
    TreeNode(int x) { val = x; }
}