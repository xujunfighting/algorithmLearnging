package com.middle;

import com.zto.algorithm.ListNode;

public class LinkedListContainsCricyle {
    public static void main(String[] args) {
        ListNode listNode= new ListNode(1);
        listNode.next=null;
        getResult(listNode);
    }
    public static ListNode getResult(ListNode list){
        if(list==null){
            return null;
        }
        ListNode step1=list;
        ListNode step2=list;
        ListNode step3=list;
        boolean isStart=true;
        ListNode res=null;
        while(step1!=null&&step2!=null&&(step1!=step2||isStart)){
            isStart=false;
            step1=step1.next;
            if(step2.next!=null)
            step2=step2.next.next;
        }
        if(step1==null||step2==null){
            return null;
        }else if(step1==step2){//存在环
            while(step1.val!=step3.val){
                step1=step1.next;
                step3=step3.next;
            }
            res=step1;
        }
        return res;
    }
}
