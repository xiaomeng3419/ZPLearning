package com.example.niuke;

import java.util.Stack;

/**
 * Created by zhangpan on 2019/3/11.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class niuke36 {
    public static Stack<Integer> var1 = new Stack<>();
    public static Stack<Integer> var2 = new Stack<>();

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode result = null;
        ListNode ln1 = pHead1;
        ListNode ln2 = pHead2;
        if (pHead1==null||pHead2==null){
            return result;
        }
        while (ln1!=null){
            var1.push(ln1.val);
            ln1=ln1.next;
        }
        while (ln2!=null){
            var2.push(ln2.val);
            ln2=ln2.next;
        }
        while (var1.peek()==var2.peek()){
            ListNode v = new ListNode(var1.peek());

            v.next=result;
            result = v;
            var1.pop();
            var2.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
         node3.next = node4;
         node4.next = node5;
         node5.next = node6;

        ListNode lode1 = new ListNode(7);
        ListNode lode2 = new ListNode(8);
        ListNode lode3 = new ListNode(1);
        ListNode lode4 = new ListNode(4);
        ListNode lode5 = new ListNode(5);
        ListNode lode6 = new ListNode(6);
        lode1.next=lode2;
        lode2.next= lode3;
        lode3.next=lode4;
        lode4.next=lode5;
        lode5.next=lode6;
        ListNode result = new niuke36().FindFirstCommonNode(node1,lode1);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
