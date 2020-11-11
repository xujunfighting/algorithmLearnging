package com.newChallenge.tree;

import com.zto.algorithm.TreeNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/6
 */
public class JudgeBalancedTree {
    private  static Boolean res=true;
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node4.left=null;
        node4.right=null;
        node5.left=node8;
        node5.right=null;
        node6.left=null;
        node6.right=null;
        node7.left=null;
        node7.right=null;
        node8.left=null;
        node8.right=null;
        int depth=isBalancedTree(node1);
        System.out.println(depth);
        System.out.println(res);
    }
    public static int isBalancedTree(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        int left=isBalancedTree(treeNode.left);
        int right=isBalancedTree(treeNode.right);
        System.out.println(treeNode.getVal());
        int result=Math.max(left+1,right+1);
        if(Math.abs(left-right)>1){
            res=false;
        }
        return result;
    }
}
