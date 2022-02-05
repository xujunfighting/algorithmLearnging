package com.leetcode;

import com.zto.common.LinkedList;

/**
 * @author xujun
 * @date 2022-01-21
 **/
public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList l1=new LinkedList(1);
        LinkedList l2=new LinkedList(2);
        LinkedList l3=new LinkedList(3);
        LinkedList l4=new LinkedList(4);
        LinkedList l5=new LinkedList(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        LinkedList revsese = reverseLinedList(l1);
        System.out.println(revsese);
    }

    public static LinkedList reverseLinedList(LinkedList head){
        if(head==null||head.next==null){
            return head;
        }
        LinkedList pre=head;
        LinkedList next=pre.next;
        head=reverseLinedList(next);
        next.next=pre;
        pre.next=null;
        return head;
    }
}
