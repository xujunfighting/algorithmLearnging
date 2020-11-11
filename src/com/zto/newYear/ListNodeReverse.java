package com.zto.newYear;

import com.zto.algorithm.ListNode;

/**
 * Created by xujun on 2019-01-08.
 */
public class ListNodeReverse {
    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode head=getReverse(node1);
        print(head);
    }
    public static ListNode getReverse(ListNode node){
        if(node==null){
            return null;
        }
        if(node.next==null){
            return node;
        }
        ListNode pre=node;
        ListNode next=node.next;
        ListNode head=getReverse(next);
        next.next=pre;
        pre.next=null;
        return head;
    }
    public static void print(ListNode  node){
        while (node!=null){
            System.out.print(node.getValue());
            node=node.next;
        }
    }
}
