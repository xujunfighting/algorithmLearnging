package com.baidu;

import com.zto.algorithm.ListNode;

import java.util.Stack;

public class ReverseNListNode {
    public static ListNode head=new ListNode(0);
    public static boolean flag=true;
    public static void main(String[] args) {
        //   1->2->3->4->5     2->1->3->4->5
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        getNReverseListNode(node1,8);
        System.out.println(head);
    }
    public static ListNode getNReverseListNode(ListNode node, int n){
        if(n==1) {
            head=node;
            return head;
        }
        if(node==null||node.next==null){
            return node;
        }
        int index=n;
        ListNode cur=node;
        Stack<ListNode> listNodes = new Stack<>();
        while(index>0&&cur!=null){
            listNodes.add(cur);
            cur=cur.next;
            index--;
        }
        ListNode  pre=null;
        ListNode listNode1=null;
        if(!listNodes.isEmpty()){
              if(flag){
                  ListNode node1=listNodes.peek();
                  head=node1;
                  flag=false;
              }
              pre=listNodes.pop();//弹出第一个元素
              listNode1=pre;
              while (!listNodes.isEmpty()){
                  ListNode  listNode=listNodes.pop();
                  listNode.next=null;
                  pre.next=listNode;
                  pre=pre.next;
              }
        }
        pre.next=getNReverseListNode(cur,n);
        return listNode1;
    }
}
