package com.niuke;

import com.zto.algorithm.ListNode;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/6/23
 **/
public class ReverseLinkedListFromleftToRight {
    public static void main(String[] args) {
         ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        ListNode n7=new ListNode(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=null;
        ListNode head = getResultEnhance(n1, 2, 7);
        System.out.println(head);
    }
   public static ListNode getResult(ListNode head,int left,int right){
        if(left==right){
            return head;
        }
        int index=1;
        ListNode cur=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode startPre=null;
        ListNode start=null;
        ListNode end=null;
        ListNode endNext=null;
        boolean isFind=false;
        while(cur!=null&&isFind==false){
            if(index==left){
                start=cur;
                startPre=pre;
            }
            if(index==right){
                end=cur;
                endNext=cur.next;
                isFind=true;
            }
            index++;
            pre=cur;
            cur=cur.next;
        }
        reverse(startPre,start,end,endNext);
        return dummy.next;

   }
   private static void reverse(ListNode startPre,ListNode start,ListNode end,ListNode endNext){
        ListNode cur=start;
        ListNode next=start.next;
        while(cur!=end){
            ListNode temp=next.next;
            next.next=cur;
            cur=next;
            next=temp;
        }
        start.next=endNext;
        startPre.next=cur;
   }

   public static ListNode getResultEnhance(ListNode head,int left,int right){
        if(left==right){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=head;
        ListNode pre=dummy;

        ListNode start=null;
        ListNode startPre=null;
        int index=1;
        while(index<=right){
            if(index==left){
                startPre=pre;
                start=cur;
            }
           if(index>=left+1){

              ListNode temp=cur.next;
              cur.next=pre;
              pre=cur;
              cur=temp;
              index++;
           }else{
               pre=cur;
               cur=cur.next;
               index++;
           }


        }
         startPre.next=pre;
         start.next=cur;
        return dummy.next;
   }
}
