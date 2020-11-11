package com.middle;

import com.zto.algorithm.ListNode;

public class MergerSortedList {
    public static void main(String[] args) {
         ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;
        ListNode n11=new ListNode(1);
        ListNode n22=new ListNode(2);
        n11.next=n22;
        n22.next=null;
        getResult(n1,n11);
    }
    public static ListNode getResult(ListNode n1,ListNode n2){
        ListNode head=new ListNode(0);

        ListNode cur=head;
        ListNode next=head;
        while(n1!=null&&n2!=null){
            if(n1.val<n2.val){
                cur=n1;
                n1=n1.next;
            }else{
                cur=n2;
                n2=n2.next;
            }
            next.next=cur;
            next=cur;
        }
        if(n1!=null){
          next.next=n1;
        }
        if(n2!=null){
          next.next=n2;
        }
        return head.next;
    }
}
