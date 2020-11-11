package com.newChallenge.tree;

import com.zto.algorithm.TreeNode;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/6
 */
public class LayerOrder {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node4.left=null;
        node4.right=null;
        node5.left=null;
        node5.right=null;
        node6.left=null;
        node6.right=null;
        node7.left=null;
        node7.right=null;
        layerMethod(node1);
    }
    public static void layerMethod(TreeNode treeNode){
        if(treeNode==null){
            return;
        }

        Queue<TreeNode> queue= new ArrayBlockingQueue<TreeNode>(10);
        int cur=1;
        int index=0;
        int next=0;
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            index++;
            System.out.print(node.getVal()+" ");
            if(node.left!=null){
                queue.add(node.left);
                next++;
            }

            if(node.right!=null){
                queue.add(node.right);
                next++;
            }
            if(cur==index){
                System.out.println();
                index=0;
                cur=next;
                next=0;
            }
        }
    }
}
