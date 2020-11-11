package com.middle;

import com.zto.algorithm.TreeNode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LayerOrderTree {
    public static void main(String[] args) {
           TreeNode node1= new TreeNode(1);
           TreeNode node2= new TreeNode(2);
           TreeNode node3= new TreeNode(3);
           TreeNode node4= new TreeNode(4);
           TreeNode node5= new TreeNode(5);
           node1.left=node2;
           node1.right=node3;
           node3.left=node4;
           node3.right=node5;
           layerTreeOrder(node1);
    }
    public static void layerTreeOrder(TreeNode t){
        int count=1;
        int index=0;
        int next=0;
        BlockingQueue<TreeNode> blockingQueue = new ArrayBlockingQueue(10);
        blockingQueue.add(t);
        while(!blockingQueue.isEmpty()){
            TreeNode node=blockingQueue.poll();
            System.out.print(node.getVal()+" ");
            index++;
            if(node.left!=null){
                next++;
                blockingQueue.add(node.left);
            }
            if(node.right!=null){
                next++;
                blockingQueue.add(node.right);
            }
            if(index==count){
                System.out.println();
                count=next;
                next=0;
                index=0;
            }
        }
    }
}
