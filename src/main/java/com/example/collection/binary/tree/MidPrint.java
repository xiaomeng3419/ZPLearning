package com.example.collection.binary.tree;

import java.util.LinkedList;

/**
 * Created by zhangpan on 2019/3/28.
 */
public class MidPrint {
    public static void midOrder(BinaryTree x){
        LinkedList<BinaryTree> stack = new LinkedList<>();
        if(x !=null){
            while (x!=null || !stack.isEmpty()){
                if(x!=null){
                    stack.add(x);
                    x = x.lchild;
                }else {
                    x = stack.removeLast();
                    System.out.print(x.var);
                    x = x.rchild;
                }
            }
        }
    }
}
