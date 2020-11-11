package com.middle;

import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        ListNode node1= new ListNode(1);
        ListNode node2= new ListNode(2);
        ListNode node3= new ListNode(3);
        ListNode node4= new ListNode(4);
        ListNode node5= new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        ListNode head=reverseNode(node1);
        System.out.println(head);
    }
    public static ListNode reverseMethod(ListNode node){
        if(node.next==null) {
             return node;
        }
            ListNode cur= node.next;
            ListNode head=reverseMethod(node.next);
            cur.next=node;
            node.next=null;
            return head;

    }
    public static ListNode reverseNode(ListNode node){
        Stack<ListNode> listNodeStack = new Stack<ListNode>();
        ListNode head=node;
        while(node!=null){
            listNodeStack.add(node);

            node=node.next;
        }
        head.next=null;
        ListNode listNode=new ListNode(1);
        head=listNode;
        while(!listNodeStack.isEmpty()){
            listNode.next=listNodeStack.pop();
            listNode=listNode.next;
        }
        return head.next;
    }
    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
}
