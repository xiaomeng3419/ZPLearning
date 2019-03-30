package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 */
public class niuke15 {
    public static void main(String[] args) {
        ListNode var1 = new ListNode(1);
        ListNode temp = new ListNode(1);
        ListNode var2 = new ListNode(2);
        ListNode var3 = new ListNode(3);
        var1.next = var2;
        var2.next = var3;
       temp =  new niuke15().ReverseList(var1);
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode temp = null;
        ListNode t3 = null;
        if (head.next == null){
            return head;
        }
        temp = head;
        t3 = head;
        head = head.next;
        while (head!= null){
            ListNode tem = head.next;
            ListNode cur = head;
            head.next = temp;
            temp = head;
            head = tem;
        }
        t3.next=null;
        return temp;

    }
}
