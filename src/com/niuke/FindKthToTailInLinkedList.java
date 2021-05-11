package com.niuke;

import com.zto.algorithm.ListNode;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/5/11
 **/
public class FindKthToTailInLinkedList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        ListNode result = getResult(5, l1);
        System.out.println(result);


    }
    private static ListNode getResult(int k, ListNode listNode){
        if(listNode==null){
            return null;
        }
        ListNode p=listNode;
        ListNode q=listNode;
        for(int i=0;i<k;i++){
           if(q==null){
               return null;
           }
           q=q.next;
        }
        while(q!=null){
            p=p.next;
            q=q.next;
        }
        return p;
    }

}
