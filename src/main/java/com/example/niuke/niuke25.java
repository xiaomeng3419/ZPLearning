package com.example.niuke;

import javax.xml.soap.Node;

/**
 * Created by zhangpan on 2019/2/19.
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * ���������������ޣ����뵽�Ķ�ȥ�����Բ��յ������ϵĶ��������
 */
public class niuke25 {
    public RandomListNode Clone(RandomListNode pHead){
      if(pHead == null) {
          return null;
      }
      //һ�����Ƶ�ǰ�Ľڵ㣬��N`��N����
        RandomListNode pnode1 = pHead;
      while (pnode1!=null){
          RandomListNode var1 = new RandomListNode(pnode1.label);
//          RandomListNode var2 = pnode1.next;
          var1.next = pnode1.next;
          var1.random = null;
          pnode1.next = var1;
          pnode1 = var1.next;
      }
      //����N`��random
        RandomListNode pnode2 = pHead;
      while (pnode2!=null){
          if(pnode2.random!=null){
              RandomListNode var1 = pnode2.next;
              var1.random = pnode2.random.next;
          }
          pnode2 = pnode2.next.next;
      }

      //��֣�
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
