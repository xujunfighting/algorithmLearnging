package com.newChallenge.linkedList;

import com.zto.common.LinkedList;

/**
 * @author xujun
 * @date 2022-01-19
 **/
public class DeleteDuplicateLinkedListNode {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1);
        LinkedList l2 = new LinkedList(1);
        LinkedList l3 = new LinkedList(2);
        LinkedList l4 = new LinkedList(2);
        LinkedList l5 = new LinkedList(3);
        LinkedList l6 = new LinkedList(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        LinkedList result = getResult(l1);
        System.out.println(result);

    }

    public static LinkedList getResult(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.getValue().equals(head.next.getValue())) {
            return getResult(head.next);
        } else {
            head.next = getResult(head.next);
        }
        return head;
    }
}
