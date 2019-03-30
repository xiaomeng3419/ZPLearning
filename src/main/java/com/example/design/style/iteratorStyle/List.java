package com.example.design.style.iteratorStyle;

/**
 * Created by zhangpan on 2019/2/25.
 */
public interface List {
    public void add(Object obj);
    public Object get(int index);
    public Iterator iterator();
    public int getSize();
}
