package com.zto.test;

import com.zto.common.LinkedList;

/**
 * Created by xujun on 2018-12-19.
 */
public class ReverseLinkedList {
    public static void main(String[] args){
        LinkedList l1=new LinkedList(1);
        LinkedList l2=new LinkedList(2);
        LinkedList l3=new LinkedList(3);
        LinkedList l4=new LinkedList(4);
        LinkedList l5=new LinkedList(5);
        LinkedList l6=new LinkedList(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        LinkedList node=reverse(l1);
        print(node);
    }
    public static LinkedList reverse(LinkedList l1){
         if(l1.next==null){
             return l1;
         }
         LinkedList pre=l1;
         LinkedList next=l1.next;
         LinkedList head=reverse(next);
         next.next=pre;
         pre.next=null;
         return head;
    }
    public static void print(LinkedList node){
        while(node!=null){
            System.out.print(node.getValue()+" ");
            node=node.next;
        }
        System.out.println();
    }
}
