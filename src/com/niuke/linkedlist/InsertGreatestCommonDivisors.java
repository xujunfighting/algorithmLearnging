package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;

/**
 * @Author xujun
 * @Description
 * @Date 2023/8/13 10:50
 */
public class InsertGreatestCommonDivisors {

    public static void main(String[] args) {
        //18,6,10,3
        ListNode n1=new ListNode(18);
        ListNode n2=new ListNode(6);
        ListNode n3=new ListNode(10);
        ListNode n4=new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        ListNode result = getResult(n1);
        System.out.println(result);
    }

    public static ListNode getResult(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=head;
        ListNode next=head.next;
        while(next!=null){
            int val1 = pre.val;
            int val2=next.val;
            ListNode val=new ListNode(cal(val1,val2));
            pre.next=val;
            val.next=next;
            pre=next;
            next=next.next;
        }

        return head;
    }


    private static Integer cal(int a,int b){
        if(a<b){
            int temp=b;
            b=a;
            a=temp;
        }
        if(a%b==0){
            return b;
        }
        while(b!=1){
            if(a%b==0){
                return b;
            }
            int temp=b;
            b=a%b;
            a=temp;
        }
        return b;
    }
}
