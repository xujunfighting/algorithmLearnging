package com.zto.algorithm;

/**
 * Created by xujun on 2018-10-18.
 */
public class MyReverseLinkedList {
    public static void main(String[] args){
       ListNode n1=new ListNode(1);
       ListNode n2=new ListNode(2);
       ListNode n3=new ListNode(3);
       ListNode n4=new ListNode(4);
       ListNode n5=new ListNode(5);
       n1.next=n2;
       n2.next=n3;
       n3.next=n4;
       n4.next=n5;
       //ListNode head=n5;

       ListNode node=reverse2(n1);
       //n1.next=null;
       print(node);
    }
    public static ListNode reverse1(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        ListNode pre=node;
        ListNode next=reverse1(pre.next);
        pre.next=null;
        next.next=pre;
        return pre;
    }
    public static ListNode reverse2(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        ListNode tmp1=node;
        ListNode tmp2=tmp1.next;
        ListNode head=reverse2(node.next);
        tmp1.next=null;
        tmp2.next=tmp1;
        return head;
    }
    public static void print(ListNode node){
        while(node!=null){
            System.out.print(node.getValue()+" ");
            node=node.next;
        }
    }
}
