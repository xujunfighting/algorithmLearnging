package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-23.
 */
public class ReverseLinkedList {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d=new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=null;
      reversePring(a);
//        while(head!=null){
//            System.out.println(head.getValue());
//            head=head.next;
//        }
    }
    public static ListNode reverse(ListNode head){

            if (head == null || head.next == null) {
            return head;
            }
            ListNode secondElem = head.next;
            head.next = null;
            ListNode reverseRest = reverse(secondElem);
            secondElem.next = head;
            return reverseRest;
        }
       public static void  reversePring(ListNode node){
        if(node!=null){
            reversePring(node.next);
            System.out.print(node.getValue());
        }
       }

}
