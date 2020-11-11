package com.hard;

import com.zto.algorithm.ListNode;

public class FineKthToTail {
    public static void main(String[] args) {
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
        node6.next=null;
        ListNode head=getResult(node1,3);
        System.out.println(head);
    }
    public static ListNode getResult(ListNode listNode,int k){
        if(listNode==null||k<=0){
            return null;
        }
        int len=0;
        ListNode start=listNode;
        while(start!=null){
            len++;
            start=start.next;
        }
        if(k>len){
            return null;
        }
        ListNode step1=listNode;
        ListNode step2=listNode;
        int index=1;
        while(index<k){
            step1=step1.next;
            index++;
        }
        while(step1.next!=null){
            step1=step1.next;
            step2=step2.next;
        }
        return  step2;
    }
}
