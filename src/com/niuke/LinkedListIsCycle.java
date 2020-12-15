package com.niuke;


import com.zto.common.LinkedList;

public class LinkedListIsCycle {
    public static void main(String[] args) {
        LinkedList l1=new LinkedList(1);
        LinkedList l2=new LinkedList(2);
        LinkedList l3=new LinkedList(3);
        LinkedList l4=new LinkedList(4);
        LinkedList l5=new LinkedList(5);
        LinkedList l6=new LinkedList(6);
        LinkedList l7=new LinkedList(7);
        LinkedList l8=new LinkedList(8);
        LinkedList l9=new LinkedList(9);
        LinkedList l10=new LinkedList(10);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;
        l8.next=l9;
        l9.next=l10;
        l10.next=l7;
        LinkedList cycle = isCycle(l1);
        System.out.println(cycle);
    }
    public static LinkedList isCycle(LinkedList head){
        LinkedList result=null;
        LinkedList l1=head;
        LinkedList l2=head;
        boolean isStart=true;
        while(l1!=null&&l2!=null){
            if(l1.getValue()==l2.getValue()&&!isStart){
                result=l1;
                return result;
            }
            isStart=false;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return result;
    }
}
