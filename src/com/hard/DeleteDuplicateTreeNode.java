package com.hard;


import com.zto.algorithm.ListNode;
import com.zto.common.TreeNode;

public class DeleteDuplicateTreeNode {
    public static void main(String[] args) {
       ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(1);
        ListNode node5=new ListNode(1);
        ListNode node6=new ListNode(1);
        ListNode node7=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=null;
        ListNode node=deleteDuplicateTreeNode(node1);
        System.out.println(node);
    }
    public static ListNode deleteDuplicateTreeNode(ListNode node){
        if (node == null) {
           return null;
        }
        if(node.next!=null){
            if(node.val==node.next.val){
                ListNode cur=node;
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                return deleteDuplicateTreeNode(cur.next);
            }else{
                node.next=deleteDuplicateTreeNode(node.next);
            }
        }else{
            return node;
        }
        return node;
    }
}
