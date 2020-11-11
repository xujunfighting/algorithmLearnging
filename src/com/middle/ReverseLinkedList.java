package com.middle;

import com.zto.algorithm.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
         ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=null;
        ListNode head=reverseList(listNode1);
        System.out.println(head);
    }
    public static ListNode reverseList(ListNode node){
        if(node.next==null){
            return node;
        }
        ListNode cur=node.next;
        ListNode head=reverseList(node.next);
        cur.next=node;
        cur=node;
        cur.next=null;
        return head;
    }
}
