package com.example.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangpan on 2019/4/2.
 * 当一个类被JVM加载，这个类就会历经初始化的过程。既然这个类没有其他静态的变量需要初始化，那么初始化过程就会顺利完成。
 * 而定义在类里面的静态类LazyHolder直到JVM确定LazyHolder一定会被执行时才会去初始化。当静态方法getInstance调用时，
 * 静态类LazyHolder才会被执行，当这件事第一次发生时，JVM就会去加载并初始化LazyHolder。LazyHolder
 * 的初始化导致了静态变量INSTANCE因为外部类（就是指LazyHolder）执行私有的构造器而被初始化。
 * 由于类的初始化过程是串行的（由java语言说明保障），就无需并行同步操作了。
 * 并且，因为初始化阶段在串行操作里写入静态变量INSTANCE，所有接下来的并行调用getInstance方法会正确返回相同的INSTANCE，
 * 而不需要额外的同步开销。


 */
public class CDemo7 {
    public static void main(String[] args) {

          }
    private CDemo7() {}

 private static class LazyHolder {
 private static final CDemo7 INSTANCE = new CDemo7();
  }
  public static CDemo7 getInstance() {
    return LazyHolder.INSTANCE;
  }

}
