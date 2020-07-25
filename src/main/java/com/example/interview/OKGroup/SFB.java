package com.example.interview.OKGroup;
import java.util.*;
/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年10月24日 17:00
 * @ModificationHistory:
 */
public class SFB {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        ListNode result =  lists[0];

        for (int i = 1; i < lists.length; i++) {
            ListNode var1 =  result;
            ListNode var2 =  lists[i];
            ListNode preVar1 =  null;
            while (var1!=null&&var2!=null){
                if(var1.val<var2.val){
                    preVar1 = var1;
                    var1 = var1.next;
                }else {
                    if(preVar1 == null){
                        preVar1 = var2;
                        var2 = var2.next;
                        preVar1.next = var1;
                        result = preVar1;
                    }else {
                        ListNode temp =  var2;
                         var2=var2.next;
                         temp.next = var1;
                         preVar1.next = temp;
                        preVar1 = temp;
                    }
                }
            }
            if(var2!=null){
                preVar1.next = var2;
            }
        }
        return result;
    }

    static ListNode string2ListNode(String str) {
        StringTokenizer token = new StringTokenizer(str, ",");
        ListNode head, foot;
        head = foot = new ListNode(0);
        while(token.hasMoreTokens()) {
            int val = Integer.parseInt(token.nextToken());
            foot = foot.next = new ListNode(val);
        }
        return head.next;
    }

    static String listNode2String(ListNode listNode) {
        StringBuilder result = new StringBuilder();
        while (listNode != null) {
            result.append(listNode.val).append(",");
            listNode = listNode.next;
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ListNode listNode1= new ListNode(1);
        ListNode listNode2= new ListNode(2);
        ListNode listNode3= new ListNode(3);
        ListNode listNode4= new ListNode(4);
        ListNode listNode5= new ListNode(5);
        listNode1.next = listNode3;
        listNode3.next = listNode5;

        listNode2.next = listNode4;
        List<ListNode> list= new ArrayList<>();
        list.add(listNode2);
        list.add(listNode1);
        ListNode[] listNode = list.toArray(new ListNode[list.size()]);
        System.out.print(listNode2String(mergeKLists(listNode)));
    }
}
