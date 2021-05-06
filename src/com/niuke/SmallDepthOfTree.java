package com.niuke;

import com.zto.algorithm.TreeNode;

public class SmallDepthOfTree {
    public static void main(String[] args) {
         TreeNode n1=new TreeNode(1);
         TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.right=n5;
        int result = getResult(n1);
        System.out.println(result);

    }
    public static int getResult(TreeNode root){
        if(root==null){
            return 0;
        }
        int right=getResult(root.right);
        int left=getResult(root.left);
        int depth=Math.min(right,left)+1;
        return depth;
    }
}
