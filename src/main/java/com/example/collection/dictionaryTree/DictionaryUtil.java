package com.example.collection.dictionaryTree;

/**
 * Created by zhangpan on 2019/3/30.
 */
public class DictionaryUtil {

    public enum DictionaryParams{
        SIZE(100);
        private int capacity;
        public int getCapacity(){
            return capacity;
        }
        DictionaryParams(int capacity){
            this.capacity = capacity;
        }
    }
}
