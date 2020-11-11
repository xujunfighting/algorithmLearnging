package com.middle;

import com.zto.algorithm.TreeNode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class IsFullTree {
    public static void main(String[] args) {
        TreeNode node1= new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3= new TreeNode(3);
        TreeNode node4= new TreeNode(4);
        TreeNode node5= new TreeNode(5);
        TreeNode node6= new TreeNode(6);
        TreeNode node7= new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        node2.left=node6;
        node2.right=node7;
        boolean result=isFullTree(node1);
        System.out.println(result);
    }
    public static boolean isFullTree(TreeNode node){
        int layerCount=1;
        int index=0;
        int nextCount=0;
        int needCount=1;
        BlockingQueue<TreeNode> objects = new ArrayBlockingQueue<>(10);
        objects.add(node);
        while(!objects.isEmpty()){
            TreeNode t=objects.poll();
            index++;
            if(t.left!=null){
                objects.add(t.left);
                nextCount++;
            }
            if(t.right!=null){
                objects.add(t.right);
                nextCount++;
            }
            if(index==layerCount){
                if(index!=needCount){
                    return false;
                }
                needCount*=2;
                layerCount=nextCount;
                nextCount=0;
                index=0;
            }
        }
        return true;
    }
}
