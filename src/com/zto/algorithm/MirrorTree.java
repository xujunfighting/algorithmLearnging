package com.zto.algorithm;

import javax.management.QueryEval;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xujun on 2018-11-01.
 */
public class MirrorTree {
    public static void main(String[] args){
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
        print(node1);
        node1=getMirrorTree(node1);
        print(node1);
    }
    public static TreeNode getMirrorTree(TreeNode node){
        TreeNode tree=node;
        Queue<TreeNode> trees=new LinkedBlockingDeque<>();
        trees.add(tree);
        while(!trees.isEmpty()){
            TreeNode child=trees.poll();
            if(child.left!=null&&child.right!=null){
                trees.add(child.left);
                trees.add(child.right);
                TreeNode temp1=child.left;
                TreeNode temp2=child.right;
                child.left=temp2;
                child.right=temp1;
            }else if(child.left!=null&&child.right==null){
                 trees.add(child.left);
                 TreeNode temp=child.left;
                 child.right=temp;
                 child.left=null;
            }else if(child.left==null&&child.right!=null){
                trees.add(child.right);
                TreeNode temp=child.right;
                child.left=temp;
                child.right=null;
            }
        }
        return node;
    }
    public static void print(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> tree=new LinkedBlockingDeque<>();
        tree.add(node);
        int cur=1;//记录当前层次的节点数
        int next=0;
        int count=0;
        while(!tree.isEmpty()){
            TreeNode current=tree.poll();
            System.out.print(current.getVal()+" ");
            count++;
            if(current.left!=null){
                tree.add(current.left);
                next++;
            }
            if(current.right!=null){
                tree.add(current.right);
                next++;
            }
            if(count==cur){
                System.out.println();
                count=0;
                cur=next;
                next=0;
            }
        }
    }
}
