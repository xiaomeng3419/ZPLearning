package com.example.collection.binary.tree;

import lombok.Data;

/**
 * Created by zhangpan on 2019/3/28.
 */
@Data
public class BinaryTree {
    public int  var ;
    public  BinaryTree rchild;
    public  BinaryTree lchild;

    BinaryTree(int var){
        rchild = null;
        lchild = null;
        this.var = var;
    }
}
