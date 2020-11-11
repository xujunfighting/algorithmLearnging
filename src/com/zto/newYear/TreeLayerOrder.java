package com.zto.newYear;

import com.zto.algorithm.TreeNode;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Author xujun
 * Create date 2019-02-15.
 * desc:
 */
public class TreeLayerOrder {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        //print(node1);
        preOrder(node1);
    }
    public static void preOrder(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.getVal());
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void middleOrder(TreeNode node){

    }
    public static void print(TreeNode node){
         Queue<TreeNode> queue=new ArrayBlockingQueue<TreeNode>(30);
         queue.add(node);
          int pre=1;
          int cur=0;
          int next=0;
          while (!queue.isEmpty()){
              TreeNode current=queue.poll();
              System.out.print(current.getVal()+" ");
              cur++;
              if(current.left!=null){
                  queue.add(current.left);
                  next++;
              }
              if(current.right!=null){
                  queue.add(current.right);
                  next++;
              }
              if(cur==pre){
                  System.out.println();
                  pre=next;
                  next=0;
                  cur=0;
              }
          }
        }
    }


