package com.zto.algorithm;

/**
 * Created by xujun on 2018-09-14.
 */
public class DepthTreeTest {
    public static void main(String[] args){
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        n1.left=n2;
        n2.left=n3;
        n3.left=n4;
        n4.left=n5;
        n5.left=null;
        int result=getResult(n1);
        System.out.print(result);
    }

    public static int getResult(TreeNode n1){
        if(n1==null){
            return  0;
        }
        int left=getResult(n1.left);
        int right=getResult(n1.right);
        return left>right?(left+1):(right+1);
    }

}
