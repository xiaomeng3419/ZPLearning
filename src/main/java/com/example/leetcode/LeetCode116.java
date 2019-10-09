package com.example.leetcode;

import java.util.Deque;
import java.util.*;

/**
 * Created by zhangpan on 2019/7/25.
 */
public class LeetCode116 {
    public Node connect(Node root) {

        if(root==null){
            return root;
        }
        Deque<Node> queue=new LinkedList<>();
        List<Node> list=new ArrayList<>();
        Node lastNode=null;
        int size;
        queue.offerLast(root);
        while(queue.size()!=0){
            size=queue.size();
            for(int i=0;i<size;i++){
                list.add(queue.pollFirst());
            }
            for(int i=0;i<list.size();i++){
                Node temp=list.get(i);
                if(temp.right!=null){
                    queue.offerLast(temp.right);
                }
                if(temp.left!=null){
                    queue.offerLast(temp.left);
                }
                if(i==0){
                    lastNode=temp;
                }
                else{
                    temp.next=lastNode;
                    lastNode=temp;
                }
            }
            lastNode=null;
            list.clear();
        }
        return root;

    }

    public static void main(String[] args) {
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}