package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;

/**
 * @Author xujun
 * @Description
 * @Date 2023/8/6 09:26
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        //ListNode l6=new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        //l6.next=null;
        ListNode result = getResult2(l1);
        System.out.println(result);
    }

    public static ListNode getResult(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=head;
        ListNode q=head.next;
        ListNode w=q.next;
        ListNode h=q;
        q.next=p;
        head=p;
        p.next=null;
        while(w!=null){
           p=w;
           q=w.next;
           if(w.next!=null){
               w=w.next.next;
           }else{
               w=null;
           }
           if(q!=null){
               q.next=p;
               p.next=null;
               head.next=q;
               head=head.next.next;
           }else{
               head.next=p;
           }
        }
        return h;
    }


    public static ListNode getResult2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=head;
        ListNode q=head.next;
        ListNode listNode=getResult2(q.next);
        q.next=p;
        p.next=listNode;
        return q;
    }
}
