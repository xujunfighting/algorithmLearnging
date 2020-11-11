package com.zto.offer;

import com.zto.common.TreeNode;

import java.util.Stack;

/**
 * Created by xujun on 2018-12-05.
 */
public class BehindOrderTree {
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node9=new TreeNode(9);
        TreeNode node8=new TreeNode(8);
        TreeNode node7=new TreeNode(7);
        node4.left=node2;
        node4.right=node5;
        node2.left=node1;
        node2.right=node3;
        node5.right=node6;
        node6.right=node8;
        node8.left=node7;
        node8.right=node9;
        Stack<TreeNode> nodes=new  Stack<TreeNode>();
        preOrder(node4,nodes);
    }
    public static void method(TreeNode node){
        if(node!=null){
            method(node.left);
            method(node.right);
            System.out.print(node.value+" ");
        }
    }
    public static void method(TreeNode node, Stack<TreeNode> nodes){
        boolean is_start=true;
        TreeNode  current=null;
        while (!nodes.isEmpty()||is_start==true) {
            is_start = false;
            while (node!= null) {
                nodes.add(node);
                node=node.left;
            }
            TreeNode n2 = nodes.peek();
            if (n2.right != null&&n2.right!=current) {
                node=n2.right;
            } else {
                TreeNode val=nodes.pop();
                System.out.print(val.value);
                current=val;
            }
        }
    }
    public static void midOrder(TreeNode node,Stack<TreeNode> nodes){
         nodes.add(node);
        while(!nodes.isEmpty()){
            while(node.left!=null){
                node=node.left;
                nodes.add(node);
            }
            TreeNode n1=nodes.pop();
            System.out.print(n1.value+" ");
            if(n1.right!=null){
                node=n1.right;
                nodes.add(node);
            }
        }
    }
    public static void preOrder(TreeNode node, Stack<TreeNode> nodes){
        boolean is_start=true;
        while(!nodes.isEmpty()||is_start==true||node!=null) {
            is_start=false;
            while (node != null) {
                System.out.print(node.value + " ");
                if(node.right!=null){
                    nodes.add(node.right);
                }
                node = node.left;
            }
            if(!nodes.isEmpty()) {
                node = nodes.pop();
            }else{
                node=null;
            }
        }
    }
}
