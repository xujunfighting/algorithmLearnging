package com.zto.charjump;

import com.zto.algorithm.TreeNode;

/**
 * Author xujun
 * Create date 2019-07-23.
 * desc:
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
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
    }
}
