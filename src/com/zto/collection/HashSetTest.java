package com.zto.collection;

import java.util.HashSet;

/**
 * Author xujun
 * Create date 2019-04-02.
 * desc:
 */
public class HashSetTest {
    public static void main(String[] args) {
//        Set<String> sets=new HashSet<>();
//        sets.add("123");
//        sets.add("123");
//        for(String str:sets){
//            System.out.println(str);
//        }
        HashSet<String> set=new HashSet<String>();
        set.add("1");
        set.add("456");
        set.add("123");
        set.add("234");
        for(String  str:set){
            System.out.println(str);
        }

    }
}
