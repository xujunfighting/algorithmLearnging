package com.niuke;

import com.zto.algorithm.ListNode;

/**
 * @version v1.0.0
 * @Description
 * @Author xujun
 * @Since 1.0
 * @Date 2021/5/11
 **/
public class ReverseKGroupInLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        ListNode result = solution(l1, 2);
        print(result);
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    private static ListNode solution(ListNode head,int k){

            if (head == null || k == 1) {
                return head;
            }
        /**
         * 创建临时前继空节点 后继指针指向head节点
         */
        ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode start = dummy;
            ListNode end = head;
            int count = 0;
            while (end != null) {
                /**
                 * 记录遍历的节点个数
                 */
                count++;
                // group
                if (count % k == 0) {
                    // reverse linked list (start, end]
                    start = reverse(start, end.next);
                    //指向后继节点
                    end = start.next;
                } else {
                    /**
                     * 不满足节点个数end节点一直后移
                     */
                    end = end.next;
                }
            }
            return dummy.next;
        }

        /**
         * reverse linked list from range (start, end), return last node.
         * for example:
         * 0->1->2->3->4->5->6->7->8
         * |           |
         * start       end
         *
         * After call start = reverse(start, end)
         *
         * 0->3->2->1->4->5->6->7->8
         *          |  |
         *       start end
         *       first
         *
         */
        private static ListNode reverse(ListNode start, ListNode end) {
            ListNode curr = start.next;
            ListNode prev = start;
            //记录第一个节点
            ListNode first = curr;
            while (curr != end){
                //记录当前节点的后继节点
                ListNode temp = curr.next;
                //当前节点指向前继节点
                curr.next = prev;
                //前继节点指向当前节点
                prev = curr;
                //当前节点指向后继节点
                curr = temp;
            }
            //空节点指向翻转链表的最后一个节点
            start.next = prev;
            //跳出循环表示curr=end
            //第一个节点指向end节点
            first.next = curr;
            return first;
        }

}


