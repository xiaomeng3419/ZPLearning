package com.example.niuke;

/**
 * Created by zhangpan on 2019/2/18.
 * 二叉搜索树：右子树的任何节点都比根节点大，左子树的任何节点都比根节点小。
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class niuke23 {
    public static void main(String[] args) {
        System.out.println(new niuke23().VerifySquenceOfBST(new int[]{1,7,2,4,5}));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        int var = sequence[sequence.length-1];
        int flag = -1;
        for (int i = sequence.length-2;i>=0;i--){
            if(sequence[i]<var&&flag==-1){
                flag=0;
            }else if(sequence[i]>var&&flag==0){
                return false;
            } else {
                continue;
            }
        }
        return true;
    }
}
