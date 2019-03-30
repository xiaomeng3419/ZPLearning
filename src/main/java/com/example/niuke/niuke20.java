package com.example.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zhangpan on 2019/2/18.
 */
public class niuke20 {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        niuke20 niuke20 = new niuke20();
        niuke20.push(3);
        System.out.println(niuke20.min());
        niuke20.push(4);
        System.out.println(niuke20.min());
        niuke20.push(2);
        System.out.println(niuke20.min());
        niuke20.push(3);
        System.out.println(niuke20.min());
        niuke20.pop();
        System.out.println(niuke20.min());
        niuke20.pop();
        System.out.println(niuke20.min());
        niuke20.pop();
        System.out.println(niuke20.min());
        niuke20.push(0);
        System.out.println(niuke20.min());
    }

    public void push(int node) {
        stack1.push(node);
        Stack<Integer> temp  =  new Stack<>();
        if(stack2.empty()){
            stack2.push(node);
            return;
        }
        while (true){
            if(stack2.empty()||stack2.peek()>=node){
                stack2.push(node);
                while (!temp.empty()){
                    stack2.push(temp.pop());
                }
                break;
            }else {
                temp.push(stack2.pop());
//                stack2.push(node);
//                while (!temp.empty()){
//                    stack2.push(temp.pop());
//                }
            }
        }


    }

    public void pop() {
       int value =  stack1.pop();
       Stack<Integer> s = new Stack<>();
        while (!stack2.empty()){
            if(value == stack2.peek()){
                stack2.pop();
                while (!s.empty()){
                    stack2.push(s.pop());
                }
                return;
            }
            s.push(stack2.pop());
        }
        stack2 = s;

    }

    public int top() {
        return stack1.peek();//top()对应到java中就是peek()
    }

    public int min() {
        return stack2.peek();
    }
}
