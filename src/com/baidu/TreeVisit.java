package com.baidu;

import com.zto.algorithm.TreeNode;

import java.util.Stack;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/25
 */
public class TreeVisit {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        node2.left=node1;
        node2.right=node3;
        node1.left=node4;
        node1.right=node5;
        node3.left=node6;
        node3.right=node7;
        //preVisit(node2);
        //System.out.println();
        //middleVisit(node2);
        //System.out.println();
        rearVisit(node2);
        //System.out.println();
        //preVisit1(node2);
        //System.out.println();
        //middleVisit1(node2);
        System.out.println();
        rearVisit1(node2);
    }
    public static void preVisit(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preVisit(node.left);
        preVisit(node.right);
    }
    public static void middleVisit(TreeNode node){
        if(node==null){
            return;
        }
        middleVisit(node.left);
        System.out.print(node.val+" ");
        middleVisit(node.right);
    }
    public static void rearVisit(TreeNode node){
        if(node==null){
            return;
        }
        rearVisit(node.left);
        rearVisit(node.right);
        System.out.print(node.val+" ");
    }
    public static void preVisit1(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            while(treeNode!=null){
                System.out.print(treeNode.val+" ");
                stack.add(treeNode.right);
                treeNode=treeNode.left;
            }
        }
    }
    public static void middleVisit1(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.add(node);
                node=node.left;
            }
            node=stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                node=node.right;
            }else{
                node=null;
            }
        }
    }
    public static void rearVisit1(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=null;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.add(node);
                node=node.left;
            }
            TreeNode treeNode=stack.peek();
            if(treeNode.right!=null&&treeNode.right!=cur){
                node=treeNode.right;
            }else{
                System.out.print(treeNode.val+" ");
                cur=stack.pop();
                node=null;
            }
        }
    }
}
