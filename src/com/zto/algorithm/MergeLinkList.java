package com.zto.algorithm;

/**
 * Created by xujun on 2018-11-09.
 */
public class MergeLinkList {
    public static  void main(String[] args){

    }
    public static ListNode mergeList(ListNode node1,ListNode node2){
        int len1=0;
        int len2=0;
        ListNode n1=node1;
        ListNode n2=node2;
        while(n1!=null){
            len1++;
            n1=n1.next;
        }
        while(n2!=null){
            len2++;
            n2=n2.next;
        }
        return null;
    }
    public static ListNode mergeListNode(ListNode n1,ListNode n2){
        ListNode node1=n1;
        ListNode node2=n2;
        ListNode head=null;
        if(n1.getValue()<n2.getValue()){

        }
        return null;
    }
}
