package com.zto.maptest;

import java.util.HashMap;
import java.util.Map;

/**
 * Author xujun
 * Create date 2019-10-12.
 * desc:
 */
public class MapCapacity {
    private static final int MAXIMUM_CAPACITY = 16;

    public static void main(String[] args) {
        Map<String,Object> maps=new HashMap<>();
        maps.put("123","123");
        maps.put("234","234");
        maps.get("234");
        System.out.println("234".hashCode());
            int cap=8;
            tableSizeFor(cap);
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

    }
}
