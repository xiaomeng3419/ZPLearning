package com.example.niuke;

import java.util.Stack;

/**
 * Created by zhangpan on 2019/2/15.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class niuke5 {
    public static void main(String[] args) {
        Solutionniuke5 link = new Solutionniuke5();
        link.push(1);
        link.push(2);
        link.push(3);
        System.out.println(link.pop());
        link.push(4);
        System.out.println(link.pop());
        System.out.println(link.pop());
        System.out.println(link.pop());
        System.out.println(link.pop());
        System.out.println(link.pop());
        link.push(5);
    }
}
class Solutionniuke5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int flag = 1;
//    int popflag = 1;

    /**
     * 进栈
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;

    }
}
