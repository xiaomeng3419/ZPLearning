package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class niuke14 {
    public ListNodeniuke14 FindKthToTail(ListNodeniuke14 head,int k) {
        int i =0;
        ListNodeniuke14 c = head;
        int count=0;
        while (c!=null){
            c = c.next;
            count++;
        }
        if(count<k){
            return null;
        }
        while (i!= count-k && head!=null){
            head = head.next;
            i++;
        }
            return head;

    }

    public static void main(String[] args) {
        ListNodeniuke14 listNodeniuke141 = new ListNodeniuke14(23);
        ListNodeniuke14 listNodeniuke142 = new ListNodeniuke14(232);
        ListNodeniuke14 listNodeniuke143 = new ListNodeniuke14(223);
        ListNodeniuke14 listNodeniuke144 = new ListNodeniuke14(233);
        ListNodeniuke14 listNodeniuke145 = new ListNodeniuke14(323);
        listNodeniuke141.next = listNodeniuke142;
        listNodeniuke142.next = listNodeniuke143;
        listNodeniuke143.next = listNodeniuke144;
        listNodeniuke144.next = listNodeniuke145;
        ListNodeniuke14 res = new niuke14().FindKthToTail(listNodeniuke141,3);
        if (res != null)
        System.out.println(res.val);
    }
}
class ListNodeniuke14 {
    int val;
    ListNodeniuke14 next = null;

    ListNodeniuke14(int val) {
        this.val = val;
    }
}
