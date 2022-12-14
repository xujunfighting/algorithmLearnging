package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
         //[-1,5,3,4,0]

        ListNode n1=new ListNode(4);
        ListNode n2=new ListNode(2);
        ListNode n0=new ListNode(1);
        ListNode n3=new ListNode(3);
        n1.next=n2;
        n2.next=n0;
        n0.next=n3;
        ListNode result = getResult(n1);
        System.out.println(result);
    }

    public static ListNode getResult(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode tail=head;
        //当前节点的前后指针指向空 后续节点在遍历前先会把前置指针指向空
        ListNode cur=head.next;
        head.next=null;
        ListNode next=null;
        ListNode index=null;
        ListNode pre=null;
        while(cur!=null){
            next=cur.next;
            cur.next=null;
            //遍历节点大于当前有序数组的最大值 直接将元素添加到最后
            if(cur.val>=tail.val){
                tail.next=cur;
                tail=cur;
                cur.next=null;
                cur=next;
            }else{
               index=head;
                pre=null;
                while(index.val<cur.val){
                    pre=index;
                    index=index.next;
                }
                //没有进行后续的遍历 head节点的值大于cur值
                if(pre==null){
                    cur.next=head;
                    head=cur;
                    cur=next;
                }else{
                    pre.next=cur;
                    cur.next=index;
                    cur=next;
                }
            }
        }
        return head;
    }
}
