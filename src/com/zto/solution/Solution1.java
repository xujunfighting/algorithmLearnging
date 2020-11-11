package com.zto.solution;

import com.zto.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author xujun
 * Create date 2019-03-02.
 * desc:
 */
public class Solution1 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        List<Integer> res=printListFromTailToHead(n1);
    }
    public static List<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> lists=new ArrayList<>();
        List<Integer> newLists=new ArrayList<>();
        while(listNode!=null){
            lists.add(listNode.getValue());
            listNode=listNode.next;
        }
        int i=lists.size()-1;
        while(i>=0){
            newLists.add(lists.get(i));
            i--;
        }
        return newLists;
    }
}
