package com.example.collection.skiplist;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月16日 0:25
 * @ModificationHistory:
 */
public class SkipListNode implements Comparable {

    private int value;
    private SkipListNode next = null;
    private SkipListNode downNext = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SkipListNode getNext() {
        return next;
    }

    public void setNext(SkipListNode next) {
        this.next = next;
    }

    public SkipListNode getDownNext() {
        return downNext;
    }

    public void setDownNext(SkipListNode downNext) {
        this.downNext = downNext;
    }

    @Override
    public int compareTo(Object o) {
        return this.value > ((SkipListNode)o).value ? 1 : -1;
    }
}