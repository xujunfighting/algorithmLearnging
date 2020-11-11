package com.zto.newYear;

import com.zto.common.LinkedList;

/**
 * Created by xujun on 2019-01-29.
 */
public class ReverseLinkedListNew {
    public static void main(String[] args) {
        LinkedList n1=new LinkedList(1);
        LinkedList n2=new LinkedList(2);
        LinkedList n3=new LinkedList(3);
        LinkedList n4=new LinkedList(4);
        LinkedList n5=new LinkedList(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        LinkedList head=method(n1);
        print(head);
    }
    public static LinkedList method(LinkedList node){
        if(node==null||node.next==null){
            return node;
        }
        LinkedList pre=node;
        LinkedList next=pre.next;
        LinkedList head=method(node.next);
        next.next=pre;
        pre.next=null;
        return head;
    }
     public static void print(LinkedList node){
        while(node!=null){
            System.out.println(node.getValue());
            node=node.next;
        }
     }
}
