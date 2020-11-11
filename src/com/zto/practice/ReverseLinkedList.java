package com.zto.practice;

import com.zto.algorithm.ListNode;

/**
 * Created by xujun on 2018-11-09.
 */
public class ReverseLinkedList {
    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode n=getReverse2(node1);
        print(n);
    }
    public static ListNode getReverse(ListNode node){
        if(node.next==null){
            return node;
        }
        ListNode current=node;
        ListNode next=node.next;
        ListNode v=getReverse(next);
        next.next=current;
        current.next=null;
        return v;
    }
    public static void print(ListNode node){
        while(node!=null){
            System.out.print(node.getValue()+" ");
            node=node.next;
        }
    }
    public static ListNode getReverse2(ListNode node){
        if(node==null||node.next==null){
            return node;
        }else{
          ListNode current=node;//定位当前节点
          ListNode next=current.next;//定位到下一个节点
          next.next=current;//将下一个节点的指针指向当前节点
          ListNode node3=next.next;//记录下一个节点的位置
         // current.next=null;//当前节点的next为空

        }
        return node;
    }
}
