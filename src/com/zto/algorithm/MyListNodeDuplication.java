package com.zto.algorithm;

/**
 * Created by xujun on 2018-08-28.
 */
public class MyListNodeDuplication {
    public static void main(String[] args){
       ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(3);  ListNode n5=new ListNode(3);
        ListNode n6=new ListNode(6);
        ListNode n7=new ListNode(7);
        ListNode n8=new ListNode(8);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=null;
        ListNode  head=myDuplicationTest(n1);
        while(head!=null){
            System.out.print(head.getValue()+" ");
            head=head.next;
        }



    }
    public static ListNode myDuplicationTest(ListNode head){
         if(head==null||head.next==null){
             return head;
         }
          ListNode node=head.next;
         if(node.getValue()==head.getValue()){

             while(head.getValue()==node.getValue()){
                 node=node.next;
             }
             //查找到第一个不相同的节点
             return  myDuplicationTest(node);
         }else{
             head.next=myDuplicationTest(node);
             return head;
         }

    }
}
