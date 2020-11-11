package com.zto.algorithm;



/**
 * Created by xujun on 2018-09-05.
 */
public class TreeNode {
    public int val;
    public TreeNode right=null;
    public  TreeNode left=null;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }
}
