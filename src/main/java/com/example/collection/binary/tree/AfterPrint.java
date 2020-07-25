package com.example.collection.binary.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zhangpan on 2019/3/28.
 */
public class AfterPrint {

    public static void afterOrder(BinaryTree x){
        LinkedList<BinaryTree> stack = new LinkedList<>();
        BinaryTree bt = null;
        if(x!=null){
            while (x!=null || !stack.isEmpty()){
                if(x!=null){
                    stack.add(x );
                    x = x.lchild;
                }else {
                    BinaryTree tRoot = stack.getLast();
                    if(tRoot.rchild != null &&  tRoot.rchild != bt){
                        x  =  tRoot.rchild;
                    }else {
                        System.out.print(tRoot.var);
                        bt = stack.removeLast();
                    }
                }
            }
        }
    }


    public static void afterOrderBy2Stack(BinaryTree x){
        Stack<BinaryTree> stack = new Stack<>();
        Stack<BinaryTree> stackOutPut = new Stack<>();
        while (x!=null||!stack.isEmpty()){

            if(x!=null){
                stack.push(x);
                stackOutPut.push(x);
                x=x.rchild;
            }else {
                x = stack.pop();
                x= x.lchild;

            }

        }
        while (!stackOutPut.isEmpty()){
            System.out.println(stackOutPut.pop().var+" ");
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
//        preOrder(node1);
        afterOrderBy2Stack(node1);
    }
}
