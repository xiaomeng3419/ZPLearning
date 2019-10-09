package com.example.leetcode;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月22日 17:00
 * @ModificationHistory:
 */
public class Leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode107 root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        List<Integer> item  =  new ArrayList<>();
        LinkedBlockingQueue<TreeNode107> queue = new LinkedBlockingQueue<TreeNode107>();
        if(root == null){
            return null;
        }
//        TreeNode107 cut = root;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> oneLevel = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {

                TreeNode107 cut = queue.poll();
                oneLevel.add(cut.val);

                if(cut.left!=null)
                    queue.add(cut.left);
                if(cut.right!=null)
                    queue.add(cut.right);
            }
            result.addFirst(oneLevel);
        }

            return result;
    }

}
class TreeNode107 {
    int val;
    TreeNode107 left;
    TreeNode107 right;
    TreeNode107(int x) { val = x; }
}