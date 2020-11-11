package com.zto.offer;

import java.util.LinkedList;

/**
 * Created by xujun on 2018-12-29.
 */
public class LinkListTest {
    public static void main(String[] args){
        LinkedList<Integer> lists=new LinkedList<>();
        lists.add(1);
        lists.offer(2);
        lists.offer(3);
        lists.offer(4);
        int res=lists.pop();
        int res1=lists.pop();
        int res2=lists.removeLast();
    }

}
