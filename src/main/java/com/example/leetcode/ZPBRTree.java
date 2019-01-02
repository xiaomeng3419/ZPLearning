package com.example.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhangpan
 * @deprecated 红黑树
 * @version 1.1
 * Created by zhangpan on 2018/12/26.
 * 手写红黑树，红黑树的5条性质
 * 1、根节点必须为黑色
 * 2、每个节点或者是黑色，或者是红色。
 * 3、 每个叶子节点是黑色。 [注意：这里叶子节点，是指为空的叶子节点！]
 * 4、如果一个节点是红色的，则它的子节点必须是黑色的
 * 5、从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点
 *
 */
public class ZPBRTree {

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    public boolean insertNode(){
     return true;
    }

    public boolean deleteNode(){return true;}



    public void  rotateLeft(){

    }
    public void rotateRight(){}










    static final class ZPBRTNode<K,V> implements Map.Entry<K,V>{
        K key;
        V value;
        ZPBRTree.ZPBRTNode<K,V> left;
        ZPBRTree.ZPBRTNode<K,V> right;
        ZPBRTree.ZPBRTNode<K,V> parent;
        boolean color = BLACK;

        /**
         * Make a new cell with given key, value, and parent, and with
         * {@code null} child links, and BLACK color.
         */
        ZPBRTNode(K key, V value, ZPBRTree.ZPBRTNode<K,V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        /**
         * Returns the key.
         *
         * @return the key
         */
        public K getKey() {
            return key;
        }

        /**
         * Returns the value associated with the key.
         *
         * @return the value associated with the key
         */
        public V getValue() {
            return value;
        }

        /**
         * Replaces the value currently associated with the key with the given
         * value.
         *
         * @return the value associated with the key before this method was
         *         called
         */
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;

            return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
        }

        public int hashCode() {
            int keyHash = (key==null ? 0 : key.hashCode());
            int valueHash = (value==null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        public String toString() {
            return key + "=" + value;
        }

    }
    static final boolean valEquals(Object o1, Object o2) {
        return (o1==null ? o2==null : o1.equals(o2));
    }
}
