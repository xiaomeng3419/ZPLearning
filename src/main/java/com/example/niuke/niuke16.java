package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/17.
 */
public class niuke16 {
    public static void main(String[] args) {

        ListNode var1 = new ListNode(1);
        ListNode var2 = new ListNode(3);
        ListNode var3 = new ListNode(4);
        var1.next = var2;
        var2.next = var3;

        ListNode var4 = new ListNode(2);
        ListNode var5 = new ListNode(4);
        ListNode var6 = new ListNode(5);
        var4.next = var5;
        var5.next = var6;

        ListNode ln = new niuke16().Merge(var1,var4);
        while (ln!=null){
            System.out.println(ln.val);
            ln = ln.next;
        }

    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode ln = new ListNode(2333);
        ListNode ls = ln;
        while (list1!=null&&list2!=null){
            if(list1.val>list2.val){
                ln.next = new ListNode(list2.val);
                list2 = list2.next;
                ln = ln.next;
            }else {
                    ln.next = new ListNode(list1.val);
                list1 = list1.next;
                ln = ln.next;
            }
        }
        if(list1 == null){
            ln.next = list2;
        }else {
            ln.next = list1;
        }
        return ls.next;
    }

}
