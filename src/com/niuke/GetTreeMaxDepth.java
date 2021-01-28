package com.niuke;

import com.zto.algorithm.TreeNode;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/1/27
 */
public class GetTreeMaxDepth {
    public static void main(String[] args) {
            TreeNode node1=new TreeNode(1);
            TreeNode node2=new TreeNode(2);
            TreeNode node3=new TreeNode(3);
            TreeNode node4=new TreeNode(4);
            TreeNode node5=new TreeNode(5);
            TreeNode node6=new TreeNode(6);
            node1.left=node2;
            node1.right=node3;
            node2.left=node4;
            node2.right=node5;
            node3.left=node6;
            int depth = getDepth(node1);
        System.out.println(depth);

    }
    public static int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        int left=0;
        int right=0;
        if(root.left!=null) {
            left=getDepth(root.left);
        }
        if(root.right!=null){
            right=getDepth(root.right);
        }
        return Math.max(left+1,right+1);
    }
}
