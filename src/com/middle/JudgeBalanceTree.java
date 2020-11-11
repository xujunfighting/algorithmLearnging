package com.middle;

import com.zto.algorithm.TreeNode;

public class JudgeBalanceTree {
    public static boolean result=true;
    public static void main(String[] args) {
        TreeNode treeNode1= new TreeNode(1);
        TreeNode treeNode2= new TreeNode(2);
        TreeNode treeNode3= new TreeNode(3);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=null;
        treeNode2.right=null;
        treeNode3.left=null;
        treeNode3.right=null;
        int result=isBalancedTree(treeNode1);
        System.out.println(result);
    }
    public static int isBalancedTree(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=isBalancedTree(node.left);
        int right=isBalancedTree(node.right);
        if(Math.abs(left-right)>=2){
            result=false;
        }
        return Math.max(left,right)+1;
    }
}
