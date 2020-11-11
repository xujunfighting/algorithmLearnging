package com.collections;

import java.util.TreeMap;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/6
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,String> maps=new TreeMap<>();
        maps.put(1,"1");
        maps.put(2,"2");
        maps.put(3,"3");
        System.out.println(maps);
    }
}
