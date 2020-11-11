package com.middle;

import com.zto.algorithm.TreeNode;

public class IsBalancedTree {
    static boolean result=true;
    public static void main(String[] args) {
        TreeNode t1= new TreeNode(1);
        TreeNode t2= new TreeNode(2);
        TreeNode t3= new TreeNode(3);
        TreeNode t4= new TreeNode(4);
        TreeNode t5= new TreeNode(5);
        TreeNode t6= new TreeNode(6);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t5.left=t6;
        int dep=getResult(t1);
        //{1,2,3,4,5,#,#,#,#,6}
        System.out.println(result);
    }
    public static int getResult(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        if(treeNode.left==null&&treeNode.right==null){
            return 1;
        }
        int left=getResult(treeNode.left);
        int right=getResult(treeNode.right);
        if(Math.abs(left-right)>1){
            result=false;
        }
        return Math.max(left+1,right+1);
    }
}
