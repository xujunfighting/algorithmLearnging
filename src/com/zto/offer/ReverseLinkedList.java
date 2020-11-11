package com.zto.offer;

import com.zto.algorithm.ListNode;

/**
 * Created by xujun on 2018-11-28.
 */
public class ReverseLinkedList {
    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode node=method2(node1);
        print(node);
    }
    public static ListNode method(ListNode node){
       if(node==null){
           return null;
       }
       ListNode pre=null;
       ListNode next=null;
       ListNode cur=null;
       ListNode lastNode=null;
       ListNode head=node;
       while(node!=null){
           pre=node;
           next=node.next;
           cur=node.next.next;
           next.next=pre; //将后继元素指向前继元素
           pre.next=lastNode;
           lastNode=next;
           node=cur;
       }
       head=next;
       return head;
    }
    public static void print(ListNode node){
        while(node!=null){
            System.out.print(node.getValue()+" ");
            node=node.next;
        }
    }
    public static ListNode method2(ListNode node){
        if(node.next==null){
            return node;
        }
        ListNode pre=node;
        ListNode next=node.next;
        ListNode head=method2(next);
        pre.next=null;
        next.next=pre;
        return head;
    }
}
