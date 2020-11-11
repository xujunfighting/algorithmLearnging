package com.zto.method;

import com.zto.common.LinkedList;

/**
 * Author xujun
 * Create date 2019-04-04.
 * desc:
 */
public class Cyc1_3 {

    public static void main(String[] args) {
        LinkedList head=new LinkedList(1);
        LinkedList current=head;
        for(int i=2;i<=4;i++){
            LinkedList node=new LinkedList(i);
            current.next=node;
            current=node;
        }
        current.next=head;
        LinkedList node=head;
        int count=0;//计数
        while(node.next!=node){
            count++;
            if(count==2){
                node.next=node.next.next;
                count=0;
            }
            node=node.next;
        }
        System.out.println(node.getValue());
    }

}
