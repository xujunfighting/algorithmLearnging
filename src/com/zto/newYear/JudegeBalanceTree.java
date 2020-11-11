package com.zto.newYear;

import com.zto.algorithm.TreeNode;

/**
 * Created by xujun on 2019-02-13.
 */
public class JudegeBalanceTree {
    private static boolean res=true;
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;
        isBalanceTree(n1);
        System.out.println(res);
    }
    public static int isBalanceTree(TreeNode node){
        boolean result=false;
        if(node==null){
           return 0;
        }
        int left=isBalanceTree(node.left);
        int right=isBalanceTree(node.right);
        if(Math.abs(left-right)>1){
            res=false;
        }
        return Math.max(left+1,right+1);
    }
}
