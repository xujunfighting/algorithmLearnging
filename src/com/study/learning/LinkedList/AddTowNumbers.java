package study.learning.LinkedList;
import com.zto.algorithm.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class AddTowNumbers {
    public static void main(String[] args) {
        //[2,4,3]
        //[5,6,4]
        //[9]
//[1,9,9,9,9,9,9,9,9,9]
        ListNode l1= new ListNode(9);

        ListNode l4= new ListNode(1);
        ListNode l5= new ListNode(9);
        ListNode l6= new ListNode(9);
        ListNode l7= new ListNode(9);
        ListNode l8= new ListNode(9);
        ListNode l9= new ListNode(9);
        ListNode l10= new ListNode(9);
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;
        l8.next=l9;
        l9.next=l10;
        addTwoNumbers(l1,l4);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int res1=0;
        int res2=0;
        int pow=0;
        int val1=0;
        int val2=0;
        while(l1!=null||l2!=null){
            if(l1!=null){
                val1=l1.val;
            }else{
                val1=0;
            }
            if(l2!=null){
                val2=l2.val;
            }else{
                val2=0;
            }
            res1+=val1*Math.pow(10,pow);
            res2+=val2*Math.pow(10,pow);
            pow++;
            if(l1!=null)
            l1=l1.next;
            if(l2!=null)
            l2=l2.next;
        }

        int res=res1+res2;
        ListNode head=new ListNode(0);
        ListNode cur=head;
        if(res==0){
            return head;
        }
        while(res!=0){
            int val=res%10;
            ListNode node= new ListNode(val);
            cur.next=node;
            cur=cur.next;
            res=res/10;
        }
        return head.next;

    }
    public static ListNode addTwoNumbers2(ListNode l1,ListNode l2){
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
}
