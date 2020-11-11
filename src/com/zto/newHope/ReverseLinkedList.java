package com.zto.newHope;

import com.zto.algorithm.ListNode;

/**
 * Author xujun
 * Create date 2019-06-21.
 * desc:
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        ListNode head=ReverseList(listNode1);
        System.out.println(head.getValue());
    }

    private static ListNode ReverseList(ListNode listNode1) {
        if(listNode1==null){
            return null;
        }
        if(listNode1.next==null){
            return listNode1;
        }
        ListNode pre=listNode1;
        ListNode next=listNode1.next;
        ListNode head=ReverseList(listNode1.next);
        next.next=pre;
        pre.next=null;
        return head;
    }


}
