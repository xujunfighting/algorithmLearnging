package com.newChallenge.tree;

import com.zto.algorithm.TreeNode;

/**
 * @author xujun
 * @date 2022-01-25
 **/
public class BiggestSubBST {
    public static void main(String[] args) {

    }

    public static TreeNode getResult(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        return null;
    }
}
