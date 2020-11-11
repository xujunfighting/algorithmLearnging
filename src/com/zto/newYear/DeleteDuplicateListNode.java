package com.zto.newYear;

import com.zto.algorithm.ListNode;

/**
 * Created by xujun on 2019-01-08.
 */
public class DeleteDuplicateListNode {
    public static ListNode head=null;
    public static ListNode current=new ListNode(0);
    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        ListNode node8=new ListNode(8);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        ListNode node=method(node5);
        print(node);
    }
    public static ListNode method(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        if(node!=null){
            ListNode q=node;
            ListNode p=node.next;
            //遍历数据找到第一个不相同的元素
            if(p.getValue()==q.getValue()) {
                while (p != null && p.getValue() == q.getValue()) {
                    p = p.next;
                }
               return method(p);//继续遍历最新的一个不是空的节点
            }else{
                node.next=method(node.next);
            }
        }
        return node;
    }
    public static void print(ListNode node){
        while(node!=null){
            System.out.print(node.getValue()+" ");
            node=node.next;
        }
    }
}
