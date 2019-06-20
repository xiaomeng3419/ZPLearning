package com.example.collection.binary.tree;

import java.util.ArrayDeque;

/**
 * Created by zhangpan on 2019/4/1.
 */
public class BreadPrint {
    public void levelOrderTraversal(BinaryTree root){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<BinaryTree> queue=new ArrayDeque<BinaryTree>();
        queue.add(root);
        while(queue.isEmpty()==false){
            BinaryTree node=queue.remove();
            System.out.print(node.var+"    ");
            if(node.lchild!=null){
                queue.add(node.lchild);
            }
            if(node.rchild!=null){
                queue.add(node.rchild);
            }
        }
        System.out.print("\n");
    }
}
