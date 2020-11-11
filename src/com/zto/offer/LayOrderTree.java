package com.zto.offer;

import com.zto.algorithm.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xujun on 2018-12-10.
 */
public class LayOrderTree {
    private static Queue<TreeNode> queue=new LinkedBlockingQueue<>();
    public static void main(String[] args){
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(5);
        TreeNode n4=new TreeNode(2);
        TreeNode n5=new TreeNode(3);
        TreeNode n6=new TreeNode(1);
        TreeNode n7=new TreeNode(6);
        n1.left=n2;
        n1.right=n5;
        n2.left=n3;
        n2.right=n4;
        n5.left=n6;
        n5.right=n7;
        print(n1,queue);
    }
    public static void print(TreeNode node, Queue<TreeNode> queue){
        if(node==null) return;
        queue.add(node);
        int startLevel=0;
        int currentLevel=1;
        int nextLevel=0;
        while(!queue.isEmpty()){
            node=queue.poll();
            System.out.print(node.getVal());
            startLevel++;

           if(node.left!=null){
              queue.add(node.left);
              nextLevel++;
           }
           if(node.right!=null){
               queue.add(node.right);
               nextLevel++;
           }
           if(startLevel==currentLevel){
               startLevel=0;
               currentLevel=nextLevel;
               nextLevel=0;
               System.out.println();
           }
        }
    }
}
