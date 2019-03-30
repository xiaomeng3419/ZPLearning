package com.example.niuke;

import javax.xml.soap.Node;

/**
 * Created by zhangpan on 2019/2/19.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 这个题个人能力有限，难想到哪儿去，所以参照的是网上的而解决方案
 */
public class niuke25 {
    public RandomListNode Clone(RandomListNode pHead){
      if(pHead == null) {
          return null;
      }
      //一、复制当前的节点，加N`到N后面
        RandomListNode pnode1 = pHead;
      while (pnode1!=null){
          RandomListNode var1 = new RandomListNode(pnode1.label);
//          RandomListNode var2 = pnode1.next;
          var1.next = pnode1.next;
          var1.random = null;
          pnode1.next = var1;
          pnode1 = var1.next;
      }
      //设置N`的random
        RandomListNode pnode2 = pHead;
      while (pnode2!=null){
          if(pnode2.random!=null){
              RandomListNode var1 = pnode2.next;
              var1.random = pnode2.random.next;
          }
          pnode2 = pnode2.next.next;
      }

      //拆分；
//        RandomListNode pnode3 = pHead;



        RandomListNode pnode3 = pHead;
        RandomListNode pCloneHead=null;
        RandomListNode pCloneNode=null;
        if(pnode3!=null){
            pCloneHead = pnode3.next;
            pCloneNode = pnode3.next;
            pnode3.next = pCloneNode.next;
            pnode3 = pnode3.next;
        }
        while (pnode3!=null){
            pCloneNode.next = pnode3.next;
            pnode3.next = pCloneNode.next;
            pnode3 = pnode3.next;

        }

return pCloneHead;
        /*RandomListNode pCloneHead=null;
        RandomListNode pCloneNode=null;

        if(pnode3!=null){
            pCloneHead=pCloneNode=pnode3.next;
            pnode3.next=pCloneNode.next;
            pnode3=pnode3.next;
        }
        while(pnode3!=null){
            pCloneNode.next=pnode3.next;
            pCloneNode=pCloneNode.next;
            pnode3.next=pCloneNode.next;
            pnode3=pnode3.next;
        }
        return pCloneHead;*/
    }


    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        node1.next = node2;
        node2.next = node3;
        node2.random = node4;
        niuke25 niuke25 = new niuke25();
        niuke25.randomPrint(node1);
        node1 = niuke25.Clone(node1);
        niuke25.randomPrint(node1);

    }

    public  void randomPrint(RandomListNode node){
        while (node!=null){
            System.out.println(node.label);
            node = node.next;
        }
    }
}
