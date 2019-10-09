package com.example.collection.autolearning;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月05日 0:18
 * @ModificationHistory:
 */
public class CPUCore {

    public static void main(String[] args) {
        int availProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("avail processors count: " + availProcessors);
    }
}
