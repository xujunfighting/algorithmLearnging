package com.zto.offer;

import com.zto.common.LinkedList;

/**
 * Created by xujun on 2018-11-26.
 */
public class LinkedListReverse {

    public static void main(String[] args){
        LinkedList l1=new LinkedList(1);
        LinkedList l2=new LinkedList(2);
        LinkedList l3=new LinkedList(3);
        LinkedList l4=new LinkedList(4);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        method1(l1);
    }
    public static void method1(LinkedList lists){
        if(lists==null){
            return;
        }
        method1(lists.getNext());
        System.out.print(lists.getValue());
    }
}
