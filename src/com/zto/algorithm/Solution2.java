package com.zto.algorithm;

/**
 * Author xujun
 * Create date 2019-10-04.
 * desc:
 */
public class Solution2 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int res1 = getResult(l1, 1);
        int res2 = getResult(l2, 1);
        int res = res1 + res2;
        return getListNode(res);
    }

    public static int getResult(ListNode node, int count) {
        int result = 0;
        while (node != null) {
            result += node.val * count;
            count = count * 10;
            node = node.next;
        }
        return result;
    }

    public static ListNode getListNode(int res) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        if (res == 0) return node;
        while (res != 0) {
            ListNode sub = new ListNode(res % 10);
            res = res / 10;
            node.next = sub;
            node = sub;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode  l1=new ListNode(9);
        //[9]
        //[1,9,9,9,9,9,9,9,9,9]
        ListNode l2=new ListNode(1);
        ListNode l22=new ListNode(9);
        ListNode l222=new ListNode(9);
        l2.next=l22;
        l22.next=l222;
        addTwoNumbers(l1,l2);

    }
}

