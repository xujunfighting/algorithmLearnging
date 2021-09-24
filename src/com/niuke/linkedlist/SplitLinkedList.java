package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;

/**
 * @author xujun
 * @Description
 * @create 2021-09-20 9:32 PM
 **/
public class SplitLinkedList {
//    输入：head = [1,4,3,2,5,2], x = 3
//
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(4);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(2);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(2);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode partition = partition(n1, 3);
        System.out.println(partition);

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode pre=new ListNode(0);
        ListNode p=pre;
        ListNode next=new ListNode(0);
        ListNode q=next;
        while(head!=null){
            if(head.val<x){
                pre.next=head;
                pre=pre.next;
            }else{
                next.next=head;
                next=next.next;
            }
            head=head.next;
        }
        pre.next=q.next;
        next.next=null;
        return p.next;
    }
}
