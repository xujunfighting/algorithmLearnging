package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-28.
 */
public class LinkedListMytest {
    public static  void main(String [] args){
       ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        ListNode node8=new ListNode(8);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        ListNode node=null;
        if(node1!=null) {
             node = MyReverse(node1);
        }else{
            node=node1;
        }
        while(node!=null){
            System.out.print(node.getValue()+" ");
            node=node.next;
        }

    }
    public static ListNode MyReverse(ListNode head){
       if(head.next==null){
           return head;
       }
       ListNode next=head.next;
       head.next=null;
       ListNode result=MyReverse(next);
       next.next=head;
       return result;
    }
}
