package com.example.niuke;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Created by zhangpan on 2019/2/15.
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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
     * @param pre ǰ��˳��
     * @param in ����˳��
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

        // ȡǰ������ĵ�һ�����־��Ǹ��ڵ�
        int value = pre[ps];
        // �������������Ѱ�Ҹ��ڵ�
        int index =is;
        while(index <= ie && value != in[index]) {
            index ++;
        }
        // ������������������������û���ҵ���˵������Ĳ����ǲ��Ϸ��ģ��׳��쳣
        if(index > ie)
            throw new RuntimeException("Invalid Iuput!");

        // ������ǰ���ڵ㣬��Ϊ���ڵ㸳ֵ
        TreeNode node = new TreeNode(value);
        // �ݹ���ù�����ǰ�ڵ��������
        node.left = construct(pre, ps+1, ps+index-is, in, is, index-1);
        // �ݹ���ù�����ǰ�ڵ��������
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
            new RuntimeException("���ܹ���һ����");
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
