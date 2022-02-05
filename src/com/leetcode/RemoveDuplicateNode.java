package com.leetcode;

import com.zto.common.LinkedList;

/**
 * @author xujun
 * @date 2022-01-21
 **/
public class RemoveDuplicateNode {
    public static void main(String[] args) {
        LinkedList l1=new LinkedList(1);
        LinkedList l2=new LinkedList(1);
        LinkedList l3=new LinkedList(2);
        LinkedList l4=new LinkedList(2);
        LinkedList l5=new LinkedList(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        LinkedList linkedList = removeDuplicate(l1);
        System.out.println(linkedList);
    }

    public static LinkedList removeDuplicate(LinkedList head){
        if(head==null||head.next==null){
            return head;
        }
        if(head.getValue().equals(head.getNext().getValue())){
            while(head.getValue().equals(head.getNext().getValue())){
                head=head.next;
            }
            return removeDuplicate(head);
        }else{
            head.next=removeDuplicate(head.next);
        }
        return head;
    }
}
