package com.example.interview.xiaomi;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月06日 19:56
 * @ModificationHistory:
 */
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class XiaomiB {

//    static String solution(String input) {
//
//
//    }
/*
    static XMNode buildNode(StringBuffer input){
       while (input.length()!=0){
           XMNode xmNode = new XMNode(Integer.valueOf(input.charAt(0)+""));

       }
    }
*/



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

//        res = solution(_input);
//        System.out.println(res);
    }
}
class  XMNode {
    int val;
    XMNode left;
    XMNode right;

    public XMNode(int val) {
        this.val = val;
    }
}
