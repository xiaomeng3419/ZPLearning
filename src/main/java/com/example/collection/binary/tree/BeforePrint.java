package com.example.collection.binary.tree;


import  com.example.collection.binary.tree.BinaryTree;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的先序遍历的非递归算法
 *
 * Created by zhangpan on 2019/3/28.
 */
public class BeforePrint {
    public static void preOrder(BinaryTree x)
    {
        System.out.println();
        if(x!=null)
        {
            LinkedList<BinaryTree> stack=new LinkedList<BinaryTree>();

            stack.addLast(x);
            while(!stack.isEmpty())
            {
                BinaryTree temp=stack.removeLast();
                System.out.print(temp.var+" ");

                if(temp.rchild!=null)
                {
                    stack.addLast(temp.rchild);
                }

                if(temp.lchild!=null)
                {
                    stack.addLast(temp.lchild);
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree node7 = new BinaryTree(7);
        node1.lchild = node2;
        node1.rchild = node3;
        node3.lchild = node4;
        node4.rchild = node7;
        node3.rchild = node5;
        node5.lchild = node6;
        preOrder(node1);
        MidPrint.midOrder(node1);
      AfterPrint.afterOrder(node1);
    }
}
