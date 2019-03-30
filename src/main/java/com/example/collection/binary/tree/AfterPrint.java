package com.example.collection.binary.tree;

import java.util.LinkedList;

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


}
