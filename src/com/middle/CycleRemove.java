package com.middle;


public class CycleRemove {
    public static void main(String[] args) {
       getResult(5,3);
    }
    public static int getResult(int n,int m){
        if(n<1||m<1) return -1;
        if(n==1){
            return n;
        }
        ListNode head = new ListNode(0);
        ListNode p=head;
        for(int i=0;i<n;i++){
            ListNode cur=new ListNode(i);
            p.next=cur;
            p=p.next;
        }
        p.next=head.next;
        p=head.next;
        int index=0;
        while(p.next!=p){
            if(index==m-2){
                index=0;
                p.next=p.next.next;
            }
            p = p.next;
            index++;
        }
        return p.val;
    }
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
