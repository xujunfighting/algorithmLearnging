package com.niuke.linkedlist;

import com.zto.algorithm.ListNode;
import java.math.BigDecimal;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/6/29
 **/
public class AddTwoLinkedListSum {
    public static void main(String[] args) {
      //[9,9,9,9,9,9,9], l2 = [9,9,9,9]
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(9);
        ListNode l3=new ListNode(9);
        ListNode l4=new ListNode(9);
        ListNode l5=new ListNode(9);
        ListNode l6=new ListNode(9);
        ListNode l7=new ListNode(9);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=null;

        ListNode l11=new ListNode(9);
        ListNode l22=new ListNode(9);
        ListNode l33=new ListNode(9);
        ListNode l44=new ListNode(9);
        l11.next=l22;
        l22.next=l33;
        l33.next=l44;
        ListNode result = getResult(l1, l11);


    }
    private static ListNode getResult(ListNode l1,ListNode l2){

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        while(l1!=null){
            sb1.append(l1.val);

            l1=l1.next;
        }
        while(l2!=null){
            sb2.append(l2.val);
            l2=l2.next;
        }
        String s1 = sb1.reverse().toString();
        String s2 = sb2.reverse().toString();
        char[] sum=new StringBuffer(new BigDecimal(s1).add(new BigDecimal(s2)).toString()).reverse().toString().toCharArray();
        ListNode summy=new ListNode(0);
        ListNode cur=summy;
        int count=sum.length;
        int index=0;
        while(index<count){
            cur.next=new ListNode(Integer.parseInt(sum[index]+""));
            cur=cur.next;
            index++;
        }
        return summy.next;
    }

}
