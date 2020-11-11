package com.zto.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Author xujun
 * Create date 2019-04-03.
 * desc:
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Object> maps=new HashMap();
        maps.put("123","123");
        maps.put("234","234");
        maps.get("123");
        int result="123456".hashCode()^("123".hashCode()>>>16);
        String val=String.valueOf(maps.get("123"));
    }
}
