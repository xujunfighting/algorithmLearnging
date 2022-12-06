package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;

        ListNode n11=new ListNode(1);
        ListNode n22=new ListNode(2);
        ListNode n33=new ListNode(5);
        ListNode n44=new ListNode(6);
        n11.next=n22;
        n22.next=n33;
        n33.next=n44;
        n44.next=null;

        ListNode listNode = mergeTwoLists(n1, null);
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode n1,ListNode n2){
        ListNode head=null;
        if(n1==null&&n2==null){
            return head;
        }else if(n1==null&&n2!=null){
            return n2;
        }else if(n1!=null&&n2==null){
            return n1;
        }
        head=new ListNode(0);
        ListNode cur=head;
        while(n1!=null&&n2!=null){

            if(n1.val<n2.val){
                cur.next=n1;
                cur=cur.next;
                n1=n1.next;
            }else{
                cur.next=n2;
                cur=cur.next;
                n2=n2.next;
            }
        }

        if(n1!=null){
            cur.next=n1;
        }else if(n2!=null){
            cur.next=n2;
        }

        return head.next;
    }
}
