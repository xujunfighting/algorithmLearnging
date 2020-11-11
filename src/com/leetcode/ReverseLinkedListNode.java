package com.leetcode;

import com.zto.common.LinkedList;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/2
 */
public class ReverseLinkedListNode {
    public static void main(String[] args) {
        LinkedList node1=new LinkedList(1);
        LinkedList node2=new LinkedList(2);
        LinkedList node3=new LinkedList(3);
        LinkedList node4=new LinkedList(4);
        LinkedList node5=new LinkedList(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        LinkedList linkedList = reverseLinkedList(node1);
        System.out.println(linkedList);

    }
    public static LinkedList reverseLinkedList(LinkedList node){
        if(node==null||node.next==null){
            return node;
        }
        LinkedList pre=node;
        LinkedList head=reverseLinkedList(node.next);
        LinkedList next=node.next;
        next.next=pre;
        pre.next=null;
        return head;
    }
}
