package com.zto.newHope;

import com.zto.algorithm.ListNode;

/**
 * Author xujun
 * Create date 2019-06-10.
 * desc:
 */
public class LastNumberOfQueue {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5,6,7,8,9};
        int count=3;
        int index=1;
        int res=getLastNumber(a,3,1);
        System.out.println(res);
    }
    public static int getLastNumber(int[] a,int count,int index){
         ListNode node1=new ListNode(a[0]);
         ListNode current=node1;
         for(int i=1;i<a.length;i++){
             ListNode  node=new ListNode(a[i]);
             current.next=node;
             current=node;
         }
         current.next=node1;
         current=node1;
         while (current.next!=current){//当前节点的下一个数据不为本身
             if(index==2){
                 index=0;
                 current.next=current.next.next;
             }else{
                 current=current.next;
                 index++;
             }
         }
         return current.getValue();
    }
}
