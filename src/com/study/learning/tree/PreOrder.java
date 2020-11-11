package com.study.learning.tree;

import com.zto.algorithm.TreeNode;

import java.util.Stack;

/**
 * Author xujun
 * Create date 2020-01-06.
 * desc:
 */
public class PreOrder {
    private static Stack<TreeNode> stack = new Stack<>();
    private static TreeNode visited  = null;
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        backOrder1(node1);
    }
    public static void preOrder(TreeNode node){
       if(node==null) return;
        System.out.println(node.getVal());
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void middleOrder(TreeNode node){
        if(node!=null){
            middleOrder(node.left);
            System.out.println(node.getVal());
            middleOrder(node.right);
        }
    }
    public static  void backOrder(TreeNode node){
        if(node!=null){
            backOrder(node.left);
            backOrder(node.right);
            System.out.println(node.getVal());
        }
    }
    public static void preOrder1(TreeNode node){
       while(node!=null||!stack.isEmpty()){
           while(node!=null) {
               System.out.println(node.getVal());
               if(node.getRight()!=null) {
                   stack.add(node.getRight());
               }
               node=node.left;
           }
           if(!stack.isEmpty()) {
               node = stack.pop();
           }

       }
    }
    public static void middleOrder1(TreeNode node){
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.add(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node =stack.pop();
                System.out.println(node.getVal());
                node = node.right;
            }
        }
    }
    public static void backOrder1(TreeNode node){
         while(node!=null||!stack.isEmpty()){
             while(node!= null){
                 stack.add(node);
                 node =  node.left;
             }
             node = stack.peek();
             if(node.right!=null&&node.right!=visited){
                 node = node.right;
             }else{
                 TreeNode current =stack.pop();
                 visited = current;
                 System.out.println(current.getVal());
                 node = null;
             }
         }
    }
}
