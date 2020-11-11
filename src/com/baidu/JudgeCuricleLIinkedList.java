package com.baidu;

import com.zto.algorithm.ListNode;

import java.util.Stack;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/12
 */
public class JudgeCuricleLIinkedList {
    public static void main(String[] args) {
          ListNode node1=new ListNode(1);
          ListNode node2=new ListNode(2);
          ListNode node3=new ListNode(3);
          ListNode node4=new ListNode(2);
          ListNode node5=new ListNode(1);
          node1.next=node2;
          node2.next=node3;
          node3.next=node4;
          node4.next=node5;
          node5.next=null;
          boolean result = getResult(node1);
        System.out.println(result);
    }
    public static boolean getResult(ListNode node){
        int len = getLen(node);
        Stack<Integer> stacks=new Stack<>();
        if(len%2==0){
            for(int i=1;i<=len;i++){
                if(i>(len/2)&&node.val==stacks.peek()){
                    stacks.pop();
                }else{
                    stacks.push(node.val);
                }
                node=node.next;
            }
        }else{
             for(int i=1;i<=len;i++){
                 if(i>(len/2+1)&&node.val==stacks.peek()){
                     stacks.pop();
                 }else if(i<(len/2)){
                     stacks.push(node.val);
                 }
                 node=node.next;
             }
        }
        if (stacks.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static int getLen(ListNode node){
        int index=0;
        while(node!=null){
            index++;
            node=node.next;
        }
        return index;
    }
}
