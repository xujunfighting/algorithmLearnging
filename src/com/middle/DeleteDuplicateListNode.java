package com.middle;

import com.zto.algorithm.ListNode;

public class DeleteDuplicateListNode {
    public static void main(String[] args) {
        ListNode node0=new ListNode(0);
        ListNode node1= new ListNode(1);
        ListNode node2= new ListNode(1);
        ListNode node3= new ListNode(3);
        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=null;
        ListNode head=getSingleListNode(node0);
        System.out.println(head);
    }
    public static ListNode getSingleListNode(ListNode node){
        if(node.next!=null){
           if(node.getValue()==node.next.getValue()){//当前元素相等
                ListNode next=node.next;
                while(next.getValue()==node.getValue()){
                    next=next.next;//找到第一个和目前相同元素不同的元素
                }
                return getSingleListNode(next);
            }else{
               node.next=getSingleListNode(node.next);
           }
        }
        return node;
    }
}
