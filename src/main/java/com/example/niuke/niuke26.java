package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/20.
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
