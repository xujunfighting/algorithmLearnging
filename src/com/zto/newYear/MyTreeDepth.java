package com.zto.newYear;

import com.zto.algorithm.TreeNode;

/**
 * Author xujun
 * Create date 2019-02-26.
 * desc:
 */
public class MyTreeDepth {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n5.right=n6;
        int res=depth(n1);
        System.out.println(res);
    }
    public static int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=depth(node.left);
        int right=depth(node.right);
        return left>right?left+1:right+1;
    }
}
