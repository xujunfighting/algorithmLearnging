package com.newChallenge.linkedList;

import com.zto.algorithm.ListNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/7/24
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;
        ListNode head = reverseListNode(n1);
        System.out.println(head);
    }
    public static ListNode reverseListNode(ListNode node){

        if(node.next==null||node==null){
            return node;
        }
        ListNode next=node.next;
        ListNode head=reverseListNode(node.next);
        next.next=node;
        node.next=null;
        return head;
    }
}
