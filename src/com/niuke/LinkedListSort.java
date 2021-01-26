package com.niuke;

import com.sun.crypto.provider.PBEWithMD5AndDESCipher;
import com.zto.algorithm.ListNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/25
 */
public class LinkedListSort {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(2);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node4.next=null;
        ListNode listNode = sortMethod(node1);
        print(listNode);

    }
    public static ListNode sortMethod(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        ListNode head=node;
        ListNode single=head.next;
        ListNode next=head.next.next;
        head.next=null;
        single.next=null;
        while(single!=null){
            head=subSortMethod(head,single);
            single=next;
            if(next==null){
                break;
            }
            next=next.next;
            single.next=null;
        }
        return head;
    }
    public static ListNode subSortMethod(ListNode head,ListNode single){
        if(single.val<head.val){
            single.next=head;
            head=single;
        }else{
            ListNode node=head;
            while(node!=null&&node.next!=null&&node.next.val<single.val){
                node=node.next;
            }
            single.next=node.next;
            node.next=single;
        }
        return head;
    }
    private static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}
