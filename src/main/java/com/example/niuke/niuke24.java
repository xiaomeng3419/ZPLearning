package com.example.niuke;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by zhangpan on 2019/2/18.
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 */
public class niuke24 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        Stack<Integer> stack = new Stack();
        findPathByFST(lists, root, target, stack);
        return lists;
    }

    /**
     * Ѱ��·��
     * @param lists
     * @param root
     * @param target
     * @param stack
     */
    public void findPathByFST(ArrayList<ArrayList<Integer>> lists,TreeNode root,int target,Stack<Integer> stack){

        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> array = new ArrayList();//ֻ���ڻ�ȡ����������·���²Ż��½�����
                for (Integer data : stack) {
                    array.add(data);
                }
                lists.add(array);
            }

            return;
        }

        if (root.left != null) {
            findPathByFST(lists, root.left, target-root.val, stack);
            stack.pop();
        }

        if (root.right != null) {
            findPathByFST(lists, root.right, target-root.val, stack);
            stack.pop();
        }

    }

}
