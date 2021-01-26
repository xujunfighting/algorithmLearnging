package com.niuke;

import com.zto.algorithm.ListNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/26
 */
public class DeleteDuplicateListNode {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(1);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        ListNode listNode = deleteDuplicateListNode(node1);
        System.out.println(listNode);
    }
    public static ListNode deleteDuplicateListNode(ListNode node){
        if(node!=null){
            if(node!=null&&node.next!=null&&node.val==node.next.val){
                   while(node.val==node.next.val){
                       node=node.next;
                   }
                   return deleteDuplicateListNode(node.next);
            }else{
                node.next=deleteDuplicateListNode(node.next);
            }
        }
        return node;
    }


}
