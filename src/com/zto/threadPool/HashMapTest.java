package com.zto.threadPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Author xujun
 * Create date 2019-02-17.
 * desc:
 */
public class HashMapTest {
    public static int MAXIMUM_CAPACITY=100;
    public static void main(String[] args) {
        Map<String,String> maps=new HashMap<>(2);
        maps.put("1","1");
        maps.put("2","2");
        maps.put("3","3");
        int a=1<<4;// 2 4 8 16
        System.out.println(100>>1);
        //int result=tableSizeFor(100);
        //System.out.println(result);
    }
    public static  int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
