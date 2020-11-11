package com.newChallenge.linkedList;

import com.zto.algorithm.ListNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/7/24
 */
public class DeteleDuplicateLinkedNode {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(1);
        ListNode n4=new ListNode(2);
        ListNode n5=new ListNode(3);
        ListNode n6=new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;
        ListNode head = removeDuplicateNode(n1);
        System.out.println(head);

    }
    public static ListNode removeDuplicateNode(ListNode node){
        if(node==null){
            return node;
        }
        if(node.val==node.next.val){
            while(node!=null&&node.next!=null&&node.val==node.next.val){
                node=node.next;
            }
            return removeDuplicateNode(node.next);
        }else{
            node.next=removeDuplicateNode(node.next);
        }
        return node;
    }
}
