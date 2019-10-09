package com.example.collection;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class CDemo7 implements Serializable {
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
