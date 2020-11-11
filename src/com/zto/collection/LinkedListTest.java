package com.zto.collection;

import java.util.LinkedList;

/**
 * Author xujun
 * Create date 2019-04-03.
 * desc:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("123");
        linkedList.add("123");
        for(String str:linkedList){
            System.out.println(str);
        }
    }
}
