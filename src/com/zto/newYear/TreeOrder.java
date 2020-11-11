package com.zto.newYear;

import com.zto.algorithm.TreeNode;

import java.util.Stack;

/**
 * Author xujun
 * Create date 2019-02-25.
 * desc:
 */
public class TreeOrder {
    static Stack<TreeNode> stack=new Stack<>();
    static TreeNode current=null;
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        postOrder1(n1);
    }
    public static void preOrder(TreeNode node){
        if(node==null) return;
        System.out.print(node.getVal()+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void middleOrder(TreeNode node){
        if(node==null) return;
        middleOrder(node.left);
        System.out.print(node.getVal()+" ");
        middleOrder(node.right);
    }
    public static void postOrder(TreeNode node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.getVal());
    }
    public static void preOrder1(TreeNode node){
        while(node!=null||!stack.isEmpty()) {
            while(node!=null){
                System.out.print(node.getVal()+" ");
                stack.add(node);
                node=node.left;
            }
            TreeNode test=stack.pop();
            if(test.right!=null){
                node=test.right;
            }

        }
    }
    public static void middleOrder1(TreeNode node){
        while (!stack.isEmpty()||node!=null){
            while (node!=null){
                stack.add(node);
                node=node.left;
            }
            TreeNode test=stack.pop();//访问第一个左子树
            System.out.println(test.getVal());
            if(test.right!=null){
                node=test.right;
            }
        }
    }
    public static void postOrder1(TreeNode node){
        while (node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.add(node);
                node=node.left;
            }
             TreeNode test=stack.peek();
            if(test.right!=null&&test.left==current){//判断当前节点的右子树是否存在
                node=test.right;
            }else{
                TreeNode n=stack.pop();
                System.out.print(n.getVal());
                current=n;
            }

        }
    }
}
