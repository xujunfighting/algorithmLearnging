package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;

public class RotateRight {
    public static void main(String[] args) {
        ListNode n1=new ListNode(0);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(2);
//        ListNode n4=new ListNode(4);
//        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=null;
//        n4.next=n5;
//        n5.next=null;
       rotateRight(n1,4);
    }

    public static ListNode rotateRight(ListNode head, int k) {
         if(head==null||head.next==null||k==0){
             return head;
         }
         int totalCount=0;
         ListNode cur=head;
         ListNode tail=null;
         while(cur!=null){
             totalCount++;
             if(cur.next==null){
                 tail=cur;
             }
             cur=cur.next;
         }
         k=k%totalCount;
         k=totalCount-k;
         cur=head;
         for(int i=1;i<k;i++){
             cur=cur.next;
         }

         tail.next=head;
         head=cur.next;
         cur.next=null;
         return head;
    }
}
