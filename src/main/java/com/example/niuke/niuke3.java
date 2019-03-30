package com.example.niuke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhangpan on 2019/2/15.
 */
public class niuke3 {
    public static void main(String[] args) {

        ListNode var1 = new ListNode(1);
        ListNode var2 = new ListNode(2);
        ListNode var3 = new ListNode(3);
        var1.next = var2;
        var2.next = var3;
        new niuke3().printListFromTailToHead(var1);

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode !=  null){
            list.add(listNode.val);
            if(listNode.next == null){
                break;
            }
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }


}
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

