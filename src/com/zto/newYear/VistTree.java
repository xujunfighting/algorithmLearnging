package com.zto.newYear;

import com.zto.algorithm.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by xujun on 2019-01-08.
 */
public class VistTree {
    private static Stack<TreeNode> stack=new Stack<TreeNode>();
    private static TreeNode current=null;
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node6=new TreeNode(6);
        TreeNode node3=new TreeNode(3);
        TreeNode node5=new TreeNode(5);
        TreeNode node4=new TreeNode(4);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        node1.left=node6;
        node1.right=node3;
        node6.left=node4;
        node6.right=node5;
        node3.left=node8;
        node3.right=node9;
        layerVisit(node1);
    }
    public static void preVist(TreeNode node){
        while(node!=null||!stack.isEmpty()) {
            while (node!= null) {
                print(node);
                if(node.left!=null) {
                    stack.add(node);
                }
                node = node.left;
            }
            if(!stack.isEmpty()) {
                node = stack.pop();
            }
            if(node!=null&&node.right!=null){
                node=node.right;
            }
        }
    }
    public static void middleVist(TreeNode node){
        while(node!=null||!stack.isEmpty()){
           while (node!=null){
               stack.push(node);
               node=node.left;
           }
           node=stack.pop();
           print(node);
           if(node.right!=null){
              node=node.right;
           }else{
               node=null;
           }
        }
    }
    public static void postVisit(TreeNode node){
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.peek();
            if(node.right!=null&&current!=node.right){
                 node=node.right;
            }else{
                node=stack.pop();
                print(node);
                current=node;
                node=null;
            }
        }
    }
    public static void layerVisit(TreeNode node){
        Queue<TreeNode> queue=new ArrayBlockingQueue<TreeNode>(100);
        int last=1;
        int index=0;
        int current=1;
        int next=0;
        queue.add(node);//将根节点添加到队列中
        while(!queue.isEmpty()){
            TreeNode tree=queue.poll();
            System.out.print(tree.getVal()+" ");
            index++;//遍历数据个数增加1
            if(tree.right!=null){
                queue.add(tree.left);
                next++;
            }
            if(tree.left!=null){
                queue.add(tree.right);
                next++;
            }
            if(index==current){
                index=0;
                current=next;
                next=0;
                System.out.println();
            }
        }

    }
    public static void print(TreeNode node){
        System.out.print(node.getVal()+" ");
    }
}
