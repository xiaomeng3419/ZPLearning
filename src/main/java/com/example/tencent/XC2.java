    package com.example.tencent;

    import java.util.Scanner;

    /**
     * Created by zhangpan on 2019/4/8.
     */
    public class XC2 {

        public static Node2 fun(Node2 root,int n,int len){
            if(n>len){
                return root;
            }
            Node2 temp = root;
            Node2 result = null;
            Node2 resultTail = null;
            Node2 curHead = null;
            Node2 curTail = null;
            int i = 0;
            int flag = len - len%n;
            while (temp!=null){

               if(curTail == null){
                   curHead = curTail = temp;
                   temp = temp.next;
                   curTail.next = null;
               }else {
                   Node2 var = temp;
                   temp = temp.next;
                   var.next = curHead;
                   curHead = var;
               }
                i++;
               if(i%n == 0){
                   if(result == null){
                       result = curHead;
                       resultTail = curTail;
                       curHead = curTail = null;
                   }else {
                       resultTail.next = curHead;
                       resultTail = curTail;
                       curHead = curTail = null;
                   }

                   if(i == flag){
                       resultTail.next = temp;
                       return  result;
                   }
               }
            }

            return  result;
        }



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            str = str.substring(1,str.length()-1);
            String[] chs = str.split(",");
            if(chs.length == 0||chs.length == 1){
                System.out.println(false);
            }
            Node2 root = new Node2(Integer.parseInt(chs[0]));
            Node2 temp = root;
            for (int i = 1 ;i<chs.length;i++){
                Node2 node = new Node2(Integer.parseInt(chs[i]));
                temp.next = node;
                temp = node;
            }
            int n = sc.nextInt();
            Node2  result = fun(root,n,chs.length);
            System.out.print("[");
           for (int i =0;i<chs.length-1;i++){
               System.out.print(result.val+",");
               result = result.next;
           }
           System.out.print(result.val);
            System.out.print("]");
        }
    }

    class Node2 {
        int val ;
        Node2 next;
        public Node2(int ch){
            this.val = ch;

        }
    }