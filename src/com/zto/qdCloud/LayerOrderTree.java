package com.zto.qdCloud;

import com.zto.algorithm.TreeNode;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author xujun
 * Create date 2019-04-26.
 * desc:
 */
public class LayerOrderTree {
    public static void main(String[] args) {

        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        method(node1);
    }
    public static void method(TreeNode node1){
        LinkedBlockingQueue<TreeNode> nodes=new LinkedBlockingQueue<>();
        int current=1;
        int next=0;
        int index=0;
        nodes.add(node1);
        while(!nodes.isEmpty()){
            TreeNode node=nodes.poll();
            System.out.print(node.getVal());
            index++;
            if(node.left!=null){
                nodes.add(node.left);
                next++;
            }
            if(node.right!=null){
                nodes.add(node.right);
                next++;
            }
            if(index==current){
                current=next;
                next=0;
                index=0;
                System.out.println();
            }
        }

    }
}
