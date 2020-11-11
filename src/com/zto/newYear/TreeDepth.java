package com.zto.newYear;

import com.zto.algorithm.TreeNode;

/**
 * Created by xujun on 2019-01-09.
 */
public class TreeDepth {
    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node6=new TreeNode(6);
        TreeNode node3=new TreeNode(3);
        TreeNode node5=new TreeNode(5);
        TreeNode node4=new TreeNode(4);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        node1.left=node6;
        node1.right=node3;
        node6.left=node4;
        node6.right=node5;
        node3.left=node8;
        node3.right=node9;
        int result=depth(node1);
        System.out.print(result);
    }
    public static int depth(TreeNode node) {
        if (node == null) {
             return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        return left + 1 >= right + 1 ? left + 1 : right + 1;
    }

}
