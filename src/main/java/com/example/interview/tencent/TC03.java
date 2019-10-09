package com.example.interview.tencent;

/**
 * Created by zhangpan on 2019/3/18.
 * BSTת��˫������
 */
public class TC03 {

    public class Solution {
        public TreeNode Convert(TreeNode pRootOfTree) {
            // ���ڵ�Ϊ��
            if(pRootOfTree == null) return null;

            if(pRootOfTree.left != null){
                // ��ת�������������ת�����ͷָ��
                TreeNode left = Convert(pRootOfTree.left);

                // ���ָ�������������һ��Ԫ�ص�ָ��
                while(left.right != null) left = left.right;

                // ��root���ӣ�ע��˫��
                pRootOfTree.left = left;
                left.right = pRootOfTree;
            }

            if(pRootOfTree.right != null){
                // ͬ��ת��������
                TreeNode right = Convert(pRootOfTree.right);

                // ���ָ���������ĵ�һ��Ԫ�ص�ָ�룬����ֱ�Ӿ���right����root˫������
                pRootOfTree.right = right;
                right.left = pRootOfTree;
            }

            // ����pRootOfTreeָ��˫������ĵ�һ��Ԫ���ٷ���
            while(pRootOfTree.left != null){
                pRootOfTree = pRootOfTree.left;
            }

            return pRootOfTree;
        }
    }
}

class TreeNode {
    int val;
    com.example.interview.tencent.TreeNode left;
    com.example.interview.tencent.TreeNode right;
    TreeNode(int x) { val = x; }
}