package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/7/12
 **/
public class ChangeNearByLinkedNode {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        ListNode n7=new ListNode(7);
        n1.next=n2;
        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
//        n5.next=n6;
//        n6.next=n7;
        ListNode listNode = changeMethod(n1);
        System.out.println(listNode);

    }
    public static ListNode changeMethod(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        ListNode next=head.next;
        ListNode back=head.next.next;
        next.next=cur;
        head=next;
        while(next!=null){
            next.next=cur;
            if(back!=null&&back.next!=null) {
                cur.next = back.next;
            }else{
                cur.next=back;
                break;
            }
            cur=back;
            next=back.next;
            if(back.next!=null) {
                back = back.next.next;
            }
        }
        return head;

    }
}
