package com.middle;

import com.zto.algorithm.TreeNode;

public class DepthOfTree {
    public static void main(String[] args) {
        TreeNode treeNode1= new TreeNode(1);
        TreeNode treeNode2= new TreeNode(2);
        TreeNode treeNode3= new TreeNode(3);
        TreeNode treeNode33= new TreeNode(3);
        TreeNode treeNode22= new TreeNode(2);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode33;
        treeNode3.right=treeNode22;
        int result=depthOfTreeNode(treeNode1);
        System.out.println(result);
    }
    public static int depthOfTreeNode(TreeNode treeNode){
         if(treeNode==null){
             return 0;
         }
         int left=depthOfTreeNode(treeNode.left);
         int right=depthOfTreeNode(treeNode.right);
         return left>right?left+1:right+1;
    }
}
