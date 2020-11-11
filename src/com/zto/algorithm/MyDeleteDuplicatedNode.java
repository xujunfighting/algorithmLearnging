package com.zto.algorithm;

/**
 * Created by xujun on 2018-10-15.
 */
public class MyDeleteDuplicatedNode {
    public static  void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        getResult1(node1);
        print(node1);
        System.out.println();
    }
    public static ListNode deleteDuplication(ListNode pHead)
    {
        //递归结束条件 节点为空或者节点的下一个节点为空，就返回该节点。
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        //下一个节点与当前节点的value相同
        if(pHead.getValue()==pHead.next.getValue()){
            ListNode node=pHead.next;
            //找到与pHead节点不相同的节点，开始递归
            while(node!=null && node.getValue()==pHead.getValue()){
                node=node.next;
            }
           deleteDuplication(node);
        }
        //下一个节点与当前节点的value不相同
        else{
            pHead.next= deleteDuplication(pHead.next);

        }
      return  pHead;
    }
   public static ListNode getResult1(ListNode node){
        //node表示第一个节点
        if(node==null||node.next==null){
            return node;
        }else {
            ListNode head=node;
            while (node.next!= null) {
                ListNode node1 = node;//node1记录第一个节点
                ListNode node2 = node1.next;
                if (node2.next != null && node2.getValue() == node2.next.getValue()) {
                    while (node2.next != null && node2.getValue() == node2.next.getValue()) {
                        node2.next = node2.next.next;
                    }
                    node1.next = node2.next;
                    node=node1.next;
                    if(node==null){
                        return head;
                    }
                }else{
                    node=node.next;
                    if(node==null){
                        return head;
                    }
                }

            }

        }
        return node;
   }

    public static void print(ListNode node){
        while(node!=null){
            System.out.print(node.getValue());
            node=node.next;
        }
    }
}
