package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/9
 **/
public class DeleteLastNNode {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        //n1.next=n2;
//        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;

        ListNode result = getResult(n1, 1);
        System.out.println(result);

    }
    public static ListNode getResult(ListNode head,int n){
       ListNode summy=new ListNode(0);
       summy.next=head;

       ListNode pre=summy;
       int index=1;
       while(head.next!=null&&index<n){
           head=head.next;
           index++;
       }
       while(head.next!=null){
           head=head.next;
           pre=pre.next;
       }
       pre.next=pre.next.next;
       return summy.next;
    }
}
