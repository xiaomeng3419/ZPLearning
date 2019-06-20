package com.example.tencent;

import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/8.
 */
public class XC1 {
    public static boolean isCyc(Node root){
        Node p =root;
        Node q = root.next.next;
        while (q != null){
            if(p.val == q.val){
                return true;
            }else {
                p = p.next;
                q = q.next.next;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] chs = str.split(",");
        if(chs.length == 0||chs.length == 1){
            System.out.println(false);
        }
        Node root = new Node(chs[0].charAt(0));
        Node temp = root;
        for (int i = 1 ;i<chs.length;i++){
            Node node = new Node(chs[i].charAt(0));
            temp.next = node;
            temp = node;

        }
        System.out.println(  isCyc(root));
    }
}
class Node {
    char val ;
    Node next;
    public Node(char ch){

    }
}
