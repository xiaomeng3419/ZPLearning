package com.example.interview.bytedance;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.LinkedList;
import java.util.*;

/**
 * Created by zhangpan on 2019/7/14.
 */
public class ByteDance1 {

    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayList<ArrayList<Integer>> FindPath(Node root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(4 );
        Node node3 = new Node(3);
        Node node4= new Node(4);
        Node node5= new Node(5);
        Node node6= new Node(6);
        Node node7= new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(FindPath(node1, 10).toString());

    }

    private static Queue<Node>  getPath(int value,Node node){
        Node root = node;
        Node temp = node.left;
        int sum  = 0;
        LinkedList<Node> stack = Lists.newLinkedList();
        stack.addLast(root);
        while (!stack.isEmpty()){
                Node var = stack.removeLast();
                if (value == sum){
                    stack.stream().forEach(item ->{System.out.println(item.val);});
                    return  stack;
                }
                if(value < sum){
                    sum  = sum  - var.val;
                    continue;
                }
                sum  = sum + var.val;
                if(sum<value && var.left == null && var.right == null){
                    sum  = sum  - var.val;
                    continue;
                }
                if(var.right!=null)
                {
                    stack.addLast(var.right);
                }
                if(var.left!=null)
                {
                 stack.addLast(var.left);
                }


        }
        System.out.println("failed");
        return stack;
    }
}
class Node{
    public int val;
    public Node left;
    public Node right;
    Node(int val){
        this.val = val;
    }
}

