package com.newChallenge.tree;

import com.zto.algorithm.TreeNode;

/**
 * @author xujun
 * @date 2022-01-21
 **/
public class FindNearestCommonParent {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        TreeNode result = getResult(n1, n4, n2);
        System.out.println(result);
    }

    public static TreeNode getResult(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return root;
        }
        if (left.val == root.val || right.val == root.val) {
            return root;
        }
        TreeNode leftNode = getResult(root.left, left, right);
        TreeNode rightNode = getResult(root.right, left, right);
        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode == null && rightNode != null) {
            return rightNode;
        } else if (leftNode != null && rightNode == null) {
            return leftNode;
        }
        return null;

    }
}
