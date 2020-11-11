package com.newChallenge.tree;

import com.zto.algorithm.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/7/31
 */
public class BackOrder {
    private static TreeNode pre=null;
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
        method(node1);
    }
    public static void method(TreeNode node){
        if(node==null){
            return;
        }
        method(node.left);
        method(node.right);
        System.out.println(node.getVal());
    }

    public static void method1(TreeNode node){
         if(node==null){
             return;
         }
        Stack<TreeNode> treeNodes = new Stack<>();
        while(!treeNodes.isEmpty()||node!=null){
             while(node!=null){
                 treeNodes.add(node);
                 node=node.left;
             }
             TreeNode cur=treeNodes.peek();

            if(cur.right!=null&&cur.left==pre){
                node=cur.right;
            }else{
                TreeNode treeNode=treeNodes.pop();
                pre=treeNode;
                System.out.println(treeNode.getVal());
            }
        }
    }
}
