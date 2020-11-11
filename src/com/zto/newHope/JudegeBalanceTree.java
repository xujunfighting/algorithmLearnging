package com.zto.newHope;

import com.zto.algorithm.TreeNode;

/**
 * Author xujun
 * Create date 2019-06-06.
 * desc:
 */
public class JudegeBalanceTree {
    public static boolean  result=true;
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node4.right=node5;
        int res=judgeBalanceTree2(node1);
        System.out.println(result);
    }
    public static int judgeBalanceTree(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftDepth=judgeBalanceTree(node.left);
        int rightDepth=judgeBalanceTree(node.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
    public static int judgeBalanceTree2(TreeNode node){
        if(node==null){
           return 0;
        }
        int leftDepth=judgeBalanceTree2(node.left);
        int rightDepth=judgeBalanceTree2(node.right);
        if(Math.abs(leftDepth-rightDepth)>1){
            result=false;
        }
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }

}
