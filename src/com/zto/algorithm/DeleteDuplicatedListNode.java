package com.zto.algorithm;

/**
 * Created by xujun on 2018-12-14.
 */
public class DeleteDuplicatedListNode {
    public static void main(String[] args){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n1=method(n1);
        print(n1);
    }
    public static void print(ListNode node){
        while(node!=null){
            System.out.print(node.getValue()+"");
            node=node.next;
        }
        System.out.println();
    }
    public static ListNode method(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        if(node!=null&&node.next!=null&&node.getValue()==node.next.getValue()){
            ListNode start=node;
            ListNode next=node.next;
            while(start.getValue()==next.getValue()){
                next=next.next;
            }
           return method(next);
        }else{
            node.next=method(node.next);
        }
        return node;
    }
    public static ListNode methodTest(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        return methodTest(node.next);
    }
}
