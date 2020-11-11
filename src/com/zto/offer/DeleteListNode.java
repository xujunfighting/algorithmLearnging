package com.zto.offer;

import com.zto.algorithm.ListNode;

/**
 * Created by xujun on 2018-11-30.
 */
public class DeleteListNode {
    public static void main(String[] args){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode node=deleteListNode(n1,n1);
        print(node);
    }
    public static ListNode deleteListNode(ListNode node1, ListNode deleteNode){
      if (deleteNode==null){
          return node1;
      }
      if(node1.getValue()==deleteNode.getValue()){
          return node1.next;
      }
      ListNode head=node1;
      while(node1!=null){
         if(node1.next.getValue()==deleteNode.getValue()){
             if(node1.next.next!=null) {
                 node1.next = node1.next.next;
                 break;
             }else{
                 node1.next=null;
                 break;
             }
         }else{
             node1=node1.next;
         }
      }
      return head;
    }
    public static void print(ListNode node){
        while (node!=null){
            System.out.print(node.getValue()+" ");
            node=node.next;
        }
    }
}
